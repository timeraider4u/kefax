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
		final EList<? extends EObject> Expr_48_list = AsmStatement_48_Var
		.getExpr();
		Assert.assertNotNull(Expr_48_list);
		Assert.assertEquals(8, Expr_48_list.size());
		//48
		final LogicalOrExpression LogicalOrExpression_49_Var
		 = (LogicalOrExpression)Expr_48_list.get(0);
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
		final Constant Constant_63_Var
		 = (Constant)PrimaryExpression_62_Var
		.getConst();
		Assert.assertNotNull(Constant_63_Var
		);
		Assert.assertEquals("\"int $0x80\"", Constant_63_Var
		.getStr());
		//63
		final LogicalOrExpression LogicalOrExpression_64_Var
		 = (LogicalOrExpression)Expr_48_list.get(1);
		Assert.assertNotNull(LogicalOrExpression_64_Var
		);
		final EList<? extends EObject> Expr_64_list = LogicalOrExpression_64_Var
		.getExpr();
		Assert.assertNotNull(Expr_64_list);
		Assert.assertEquals(1, Expr_64_list.size());
		//64
		final LogicalAndExpression LogicalAndExpression_65_Var
		 = (LogicalAndExpression)Expr_64_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_65_Var
		);
		final EList<? extends EObject> Expr_65_list = LogicalAndExpression_65_Var
		.getExpr();
		Assert.assertNotNull(Expr_65_list);
		Assert.assertEquals(1, Expr_65_list.size());
		//65
		final InclusiveOrExpression InclusiveOrExpression_66_Var
		 = (InclusiveOrExpression)Expr_65_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_66_Var
		);
		final EList<? extends EObject> Expr_66_list = InclusiveOrExpression_66_Var
		.getExpr();
		Assert.assertNotNull(Expr_66_list);
		Assert.assertEquals(1, Expr_66_list.size());
		//66
		final ExclusiveOrExpression ExclusiveOrExpression_67_Var
		 = (ExclusiveOrExpression)Expr_66_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_67_Var
		);
		final EList<? extends EObject> Expr_67_list = ExclusiveOrExpression_67_Var
		.getExpr();
		Assert.assertNotNull(Expr_67_list);
		Assert.assertEquals(1, Expr_67_list.size());
		//67
		final AndExpression AndExpression_68_Var
		 = (AndExpression)Expr_67_list.get(0);
		Assert.assertNotNull(AndExpression_68_Var
		);
		final EList<? extends EObject> Expr_68_list = AndExpression_68_Var
		.getExpr();
		Assert.assertNotNull(Expr_68_list);
		Assert.assertEquals(1, Expr_68_list.size());
		//68
		final EqualityExpression EqualityExpression_69_Var
		 = (EqualityExpression)Expr_68_list.get(0);
		Assert.assertNotNull(EqualityExpression_69_Var
		);
		final EList<? extends EObject> Expr_69_list = EqualityExpression_69_Var
		.getExpr();
		Assert.assertNotNull(Expr_69_list);
		Assert.assertEquals(1, Expr_69_list.size());
		//69
		final RelationalExpression RelationalExpression_70_Var
		 = (RelationalExpression)Expr_69_list.get(0);
		Assert.assertNotNull(RelationalExpression_70_Var
		);
		final EList<? extends EObject> Expr_70_list = RelationalExpression_70_Var
		.getExpr();
		Assert.assertNotNull(Expr_70_list);
		Assert.assertEquals(1, Expr_70_list.size());
		//70
		final ShiftExpression ShiftExpression_71_Var
		 = (ShiftExpression)Expr_70_list.get(0);
		Assert.assertNotNull(ShiftExpression_71_Var
		);
		final EList<? extends EObject> Expr_71_list = ShiftExpression_71_Var
		.getExpr();
		Assert.assertNotNull(Expr_71_list);
		Assert.assertEquals(1, Expr_71_list.size());
		//71
		final AdditiveExpression AdditiveExpression_72_Var
		 = (AdditiveExpression)Expr_71_list.get(0);
		Assert.assertNotNull(AdditiveExpression_72_Var
		);
		final EList<? extends EObject> Expr_72_list = AdditiveExpression_72_Var
		.getExpr();
		Assert.assertNotNull(Expr_72_list);
		Assert.assertEquals(1, Expr_72_list.size());
		//72
		final MultiplicativeExpression MultiplicativeExpression_73_Var
		 = (MultiplicativeExpression)Expr_72_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_73_Var
		);
		final EList<? extends EObject> Expr_73_list = MultiplicativeExpression_73_Var
		.getExpr();
		Assert.assertNotNull(Expr_73_list);
		Assert.assertEquals(1, Expr_73_list.size());
		//73
		final CastExpression CastExpression_74_Var
		 = (CastExpression)Expr_73_list.get(0);
		Assert.assertNotNull(CastExpression_74_Var
		);
		//74
		final UnaryExpression UnaryExpression_75_Var
		 = (UnaryExpression)CastExpression_74_Var
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
		final Constant Constant_78_Var
		 = (Constant)PrimaryExpression_77_Var
		.getConst();
		Assert.assertNotNull(Constant_78_Var
		);
		Assert.assertEquals("\"=a\"", Constant_78_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_78_list = PostfixExpression_76_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_78_list);
		Assert.assertEquals(1, ArgumentExpressionList_78_list.size());
		//78
		final ArgumentExpressionList ArgumentExpressionList_79_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_78_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_79_Var
		);
		final EList<? extends EObject> Expr_79_list = ArgumentExpressionList_79_Var
		.getExpr();
		Assert.assertNotNull(Expr_79_list);
		Assert.assertEquals(1, Expr_79_list.size());
		//79
		final AssignmentExpression AssignmentExpression_80_Var
		 = (AssignmentExpression)Expr_79_list.get(0);
		Assert.assertNotNull(AssignmentExpression_80_Var
		);
		//80
		final ConditionalExpression ConditionalExpression_81_Var
		 = (ConditionalExpression)AssignmentExpression_80_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_81_Var
		);
		//81
		final LogicalOrExpression LogicalOrExpression_82_Var
		 = (LogicalOrExpression)ConditionalExpression_81_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_82_Var
		);
		final EList<? extends EObject> Expr_82_list = LogicalOrExpression_82_Var
		.getExpr();
		Assert.assertNotNull(Expr_82_list);
		Assert.assertEquals(1, Expr_82_list.size());
		//82
		final LogicalAndExpression LogicalAndExpression_83_Var
		 = (LogicalAndExpression)Expr_82_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_83_Var
		);
		final EList<? extends EObject> Expr_83_list = LogicalAndExpression_83_Var
		.getExpr();
		Assert.assertNotNull(Expr_83_list);
		Assert.assertEquals(1, Expr_83_list.size());
		//83
		final InclusiveOrExpression InclusiveOrExpression_84_Var
		 = (InclusiveOrExpression)Expr_83_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_84_Var
		);
		final EList<? extends EObject> Expr_84_list = InclusiveOrExpression_84_Var
		.getExpr();
		Assert.assertNotNull(Expr_84_list);
		Assert.assertEquals(1, Expr_84_list.size());
		//84
		final ExclusiveOrExpression ExclusiveOrExpression_85_Var
		 = (ExclusiveOrExpression)Expr_84_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_85_Var
		);
		final EList<? extends EObject> Expr_85_list = ExclusiveOrExpression_85_Var
		.getExpr();
		Assert.assertNotNull(Expr_85_list);
		Assert.assertEquals(1, Expr_85_list.size());
		//85
		final AndExpression AndExpression_86_Var
		 = (AndExpression)Expr_85_list.get(0);
		Assert.assertNotNull(AndExpression_86_Var
		);
		final EList<? extends EObject> Expr_86_list = AndExpression_86_Var
		.getExpr();
		Assert.assertNotNull(Expr_86_list);
		Assert.assertEquals(1, Expr_86_list.size());
		//86
		final EqualityExpression EqualityExpression_87_Var
		 = (EqualityExpression)Expr_86_list.get(0);
		Assert.assertNotNull(EqualityExpression_87_Var
		);
		final EList<? extends EObject> Expr_87_list = EqualityExpression_87_Var
		.getExpr();
		Assert.assertNotNull(Expr_87_list);
		Assert.assertEquals(1, Expr_87_list.size());
		//87
		final RelationalExpression RelationalExpression_88_Var
		 = (RelationalExpression)Expr_87_list.get(0);
		Assert.assertNotNull(RelationalExpression_88_Var
		);
		final EList<? extends EObject> Expr_88_list = RelationalExpression_88_Var
		.getExpr();
		Assert.assertNotNull(Expr_88_list);
		Assert.assertEquals(1, Expr_88_list.size());
		//88
		final ShiftExpression ShiftExpression_89_Var
		 = (ShiftExpression)Expr_88_list.get(0);
		Assert.assertNotNull(ShiftExpression_89_Var
		);
		final EList<? extends EObject> Expr_89_list = ShiftExpression_89_Var
		.getExpr();
		Assert.assertNotNull(Expr_89_list);
		Assert.assertEquals(1, Expr_89_list.size());
		//89
		final AdditiveExpression AdditiveExpression_90_Var
		 = (AdditiveExpression)Expr_89_list.get(0);
		Assert.assertNotNull(AdditiveExpression_90_Var
		);
		final EList<? extends EObject> Expr_90_list = AdditiveExpression_90_Var
		.getExpr();
		Assert.assertNotNull(Expr_90_list);
		Assert.assertEquals(1, Expr_90_list.size());
		//90
		final MultiplicativeExpression MultiplicativeExpression_91_Var
		 = (MultiplicativeExpression)Expr_90_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_91_Var
		);
		final EList<? extends EObject> Expr_91_list = MultiplicativeExpression_91_Var
		.getExpr();
		Assert.assertNotNull(Expr_91_list);
		Assert.assertEquals(1, Expr_91_list.size());
		//91
		final CastExpression CastExpression_92_Var
		 = (CastExpression)Expr_91_list.get(0);
		Assert.assertNotNull(CastExpression_92_Var
		);
		//92
		final UnaryExpression UnaryExpression_93_Var
		 = (UnaryExpression)CastExpression_92_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_93_Var
		);
		//93
		final PostfixExpression PostfixExpression_94_Var
		 = (PostfixExpression)UnaryExpression_93_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_94_Var
		);
		final EList<? extends EObject> Expr_94_list = PostfixExpression_94_Var
		.getExpr();
		Assert.assertNotNull(Expr_94_list);
		Assert.assertEquals(1, Expr_94_list.size());
		//94
		final PrimaryExpression PrimaryExpression_95_Var
		 = (PrimaryExpression)Expr_94_list.get(0);
		Assert.assertNotNull(PrimaryExpression_95_Var
		);
		Assert.assertEquals("res", PrimaryExpression_95_Var
		.getId());
		//95
		final LogicalOrExpression LogicalOrExpression_96_Var
		 = (LogicalOrExpression)Expr_48_list.get(2);
		Assert.assertNotNull(LogicalOrExpression_96_Var
		);
		final EList<? extends EObject> Expr_96_list = LogicalOrExpression_96_Var
		.getExpr();
		Assert.assertNotNull(Expr_96_list);
		Assert.assertEquals(1, Expr_96_list.size());
		//96
		final LogicalAndExpression LogicalAndExpression_97_Var
		 = (LogicalAndExpression)Expr_96_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_97_Var
		);
		final EList<? extends EObject> Expr_97_list = LogicalAndExpression_97_Var
		.getExpr();
		Assert.assertNotNull(Expr_97_list);
		Assert.assertEquals(1, Expr_97_list.size());
		//97
		final InclusiveOrExpression InclusiveOrExpression_98_Var
		 = (InclusiveOrExpression)Expr_97_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_98_Var
		);
		final EList<? extends EObject> Expr_98_list = InclusiveOrExpression_98_Var
		.getExpr();
		Assert.assertNotNull(Expr_98_list);
		Assert.assertEquals(1, Expr_98_list.size());
		//98
		final ExclusiveOrExpression ExclusiveOrExpression_99_Var
		 = (ExclusiveOrExpression)Expr_98_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_99_Var
		);
		final EList<? extends EObject> Expr_99_list = ExclusiveOrExpression_99_Var
		.getExpr();
		Assert.assertNotNull(Expr_99_list);
		Assert.assertEquals(1, Expr_99_list.size());
		//99
		final AndExpression AndExpression_100_Var
		 = (AndExpression)Expr_99_list.get(0);
		Assert.assertNotNull(AndExpression_100_Var
		);
		final EList<? extends EObject> Expr_100_list = AndExpression_100_Var
		.getExpr();
		Assert.assertNotNull(Expr_100_list);
		Assert.assertEquals(1, Expr_100_list.size());
		//100
		final EqualityExpression EqualityExpression_101_Var
		 = (EqualityExpression)Expr_100_list.get(0);
		Assert.assertNotNull(EqualityExpression_101_Var
		);
		final EList<? extends EObject> Expr_101_list = EqualityExpression_101_Var
		.getExpr();
		Assert.assertNotNull(Expr_101_list);
		Assert.assertEquals(1, Expr_101_list.size());
		//101
		final RelationalExpression RelationalExpression_102_Var
		 = (RelationalExpression)Expr_101_list.get(0);
		Assert.assertNotNull(RelationalExpression_102_Var
		);
		final EList<? extends EObject> Expr_102_list = RelationalExpression_102_Var
		.getExpr();
		Assert.assertNotNull(Expr_102_list);
		Assert.assertEquals(1, Expr_102_list.size());
		//102
		final ShiftExpression ShiftExpression_103_Var
		 = (ShiftExpression)Expr_102_list.get(0);
		Assert.assertNotNull(ShiftExpression_103_Var
		);
		final EList<? extends EObject> Expr_103_list = ShiftExpression_103_Var
		.getExpr();
		Assert.assertNotNull(Expr_103_list);
		Assert.assertEquals(1, Expr_103_list.size());
		//103
		final AdditiveExpression AdditiveExpression_104_Var
		 = (AdditiveExpression)Expr_103_list.get(0);
		Assert.assertNotNull(AdditiveExpression_104_Var
		);
		final EList<? extends EObject> Expr_104_list = AdditiveExpression_104_Var
		.getExpr();
		Assert.assertNotNull(Expr_104_list);
		Assert.assertEquals(1, Expr_104_list.size());
		//104
		final MultiplicativeExpression MultiplicativeExpression_105_Var
		 = (MultiplicativeExpression)Expr_104_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_105_Var
		);
		final EList<? extends EObject> Expr_105_list = MultiplicativeExpression_105_Var
		.getExpr();
		Assert.assertNotNull(Expr_105_list);
		Assert.assertEquals(1, Expr_105_list.size());
		//105
		final CastExpression CastExpression_106_Var
		 = (CastExpression)Expr_105_list.get(0);
		Assert.assertNotNull(CastExpression_106_Var
		);
		//106
		final UnaryExpression UnaryExpression_107_Var
		 = (UnaryExpression)CastExpression_106_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_107_Var
		);
		//107
		final PostfixExpression PostfixExpression_108_Var
		 = (PostfixExpression)UnaryExpression_107_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_108_Var
		);
		final EList<? extends EObject> Expr_108_list = PostfixExpression_108_Var
		.getExpr();
		Assert.assertNotNull(Expr_108_list);
		Assert.assertEquals(1, Expr_108_list.size());
		//108
		final PrimaryExpression PrimaryExpression_109_Var
		 = (PrimaryExpression)Expr_108_list.get(0);
		Assert.assertNotNull(PrimaryExpression_109_Var
		);
		//109
		final Constant Constant_110_Var
		 = (Constant)PrimaryExpression_109_Var
		.getConst();
		Assert.assertNotNull(Constant_110_Var
		);
		Assert.assertEquals("\"+b\"", Constant_110_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_110_list = PostfixExpression_108_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_110_list);
		Assert.assertEquals(1, ArgumentExpressionList_110_list.size());
		//110
		final ArgumentExpressionList ArgumentExpressionList_111_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_110_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_111_Var
		);
		final EList<? extends EObject> Expr_111_list = ArgumentExpressionList_111_Var
		.getExpr();
		Assert.assertNotNull(Expr_111_list);
		Assert.assertEquals(1, Expr_111_list.size());
		//111
		final AssignmentExpression AssignmentExpression_112_Var
		 = (AssignmentExpression)Expr_111_list.get(0);
		Assert.assertNotNull(AssignmentExpression_112_Var
		);
		//112
		final ConditionalExpression ConditionalExpression_113_Var
		 = (ConditionalExpression)AssignmentExpression_112_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_113_Var
		);
		//113
		final LogicalOrExpression LogicalOrExpression_114_Var
		 = (LogicalOrExpression)ConditionalExpression_113_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_114_Var
		);
		final EList<? extends EObject> Expr_114_list = LogicalOrExpression_114_Var
		.getExpr();
		Assert.assertNotNull(Expr_114_list);
		Assert.assertEquals(1, Expr_114_list.size());
		//114
		final LogicalAndExpression LogicalAndExpression_115_Var
		 = (LogicalAndExpression)Expr_114_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_115_Var
		);
		final EList<? extends EObject> Expr_115_list = LogicalAndExpression_115_Var
		.getExpr();
		Assert.assertNotNull(Expr_115_list);
		Assert.assertEquals(1, Expr_115_list.size());
		//115
		final InclusiveOrExpression InclusiveOrExpression_116_Var
		 = (InclusiveOrExpression)Expr_115_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_116_Var
		);
		final EList<? extends EObject> Expr_116_list = InclusiveOrExpression_116_Var
		.getExpr();
		Assert.assertNotNull(Expr_116_list);
		Assert.assertEquals(1, Expr_116_list.size());
		//116
		final ExclusiveOrExpression ExclusiveOrExpression_117_Var
		 = (ExclusiveOrExpression)Expr_116_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_117_Var
		);
		final EList<? extends EObject> Expr_117_list = ExclusiveOrExpression_117_Var
		.getExpr();
		Assert.assertNotNull(Expr_117_list);
		Assert.assertEquals(1, Expr_117_list.size());
		//117
		final AndExpression AndExpression_118_Var
		 = (AndExpression)Expr_117_list.get(0);
		Assert.assertNotNull(AndExpression_118_Var
		);
		final EList<? extends EObject> Expr_118_list = AndExpression_118_Var
		.getExpr();
		Assert.assertNotNull(Expr_118_list);
		Assert.assertEquals(1, Expr_118_list.size());
		//118
		final EqualityExpression EqualityExpression_119_Var
		 = (EqualityExpression)Expr_118_list.get(0);
		Assert.assertNotNull(EqualityExpression_119_Var
		);
		final EList<? extends EObject> Expr_119_list = EqualityExpression_119_Var
		.getExpr();
		Assert.assertNotNull(Expr_119_list);
		Assert.assertEquals(1, Expr_119_list.size());
		//119
		final RelationalExpression RelationalExpression_120_Var
		 = (RelationalExpression)Expr_119_list.get(0);
		Assert.assertNotNull(RelationalExpression_120_Var
		);
		final EList<? extends EObject> Expr_120_list = RelationalExpression_120_Var
		.getExpr();
		Assert.assertNotNull(Expr_120_list);
		Assert.assertEquals(1, Expr_120_list.size());
		//120
		final ShiftExpression ShiftExpression_121_Var
		 = (ShiftExpression)Expr_120_list.get(0);
		Assert.assertNotNull(ShiftExpression_121_Var
		);
		final EList<? extends EObject> Expr_121_list = ShiftExpression_121_Var
		.getExpr();
		Assert.assertNotNull(Expr_121_list);
		Assert.assertEquals(1, Expr_121_list.size());
		//121
		final AdditiveExpression AdditiveExpression_122_Var
		 = (AdditiveExpression)Expr_121_list.get(0);
		Assert.assertNotNull(AdditiveExpression_122_Var
		);
		final EList<? extends EObject> Expr_122_list = AdditiveExpression_122_Var
		.getExpr();
		Assert.assertNotNull(Expr_122_list);
		Assert.assertEquals(1, Expr_122_list.size());
		//122
		final MultiplicativeExpression MultiplicativeExpression_123_Var
		 = (MultiplicativeExpression)Expr_122_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_123_Var
		);
		final EList<? extends EObject> Expr_123_list = MultiplicativeExpression_123_Var
		.getExpr();
		Assert.assertNotNull(Expr_123_list);
		Assert.assertEquals(1, Expr_123_list.size());
		//123
		final CastExpression CastExpression_124_Var
		 = (CastExpression)Expr_123_list.get(0);
		Assert.assertNotNull(CastExpression_124_Var
		);
		//124
		final UnaryExpression UnaryExpression_125_Var
		 = (UnaryExpression)CastExpression_124_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_125_Var
		);
		//125
		final PostfixExpression PostfixExpression_126_Var
		 = (PostfixExpression)UnaryExpression_125_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_126_Var
		);
		final EList<? extends EObject> Expr_126_list = PostfixExpression_126_Var
		.getExpr();
		Assert.assertNotNull(Expr_126_list);
		Assert.assertEquals(1, Expr_126_list.size());
		//126
		final PrimaryExpression PrimaryExpression_127_Var
		 = (PrimaryExpression)Expr_126_list.get(0);
		Assert.assertNotNull(PrimaryExpression_127_Var
		);
		Assert.assertEquals("arg1", PrimaryExpression_127_Var
		.getId());
		//127
		final LogicalOrExpression LogicalOrExpression_128_Var
		 = (LogicalOrExpression)Expr_48_list.get(3);
		Assert.assertNotNull(LogicalOrExpression_128_Var
		);
		final EList<? extends EObject> Expr_128_list = LogicalOrExpression_128_Var
		.getExpr();
		Assert.assertNotNull(Expr_128_list);
		Assert.assertEquals(1, Expr_128_list.size());
		//128
		final LogicalAndExpression LogicalAndExpression_129_Var
		 = (LogicalAndExpression)Expr_128_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_129_Var
		);
		final EList<? extends EObject> Expr_129_list = LogicalAndExpression_129_Var
		.getExpr();
		Assert.assertNotNull(Expr_129_list);
		Assert.assertEquals(1, Expr_129_list.size());
		//129
		final InclusiveOrExpression InclusiveOrExpression_130_Var
		 = (InclusiveOrExpression)Expr_129_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_130_Var
		);
		final EList<? extends EObject> Expr_130_list = InclusiveOrExpression_130_Var
		.getExpr();
		Assert.assertNotNull(Expr_130_list);
		Assert.assertEquals(1, Expr_130_list.size());
		//130
		final ExclusiveOrExpression ExclusiveOrExpression_131_Var
		 = (ExclusiveOrExpression)Expr_130_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_131_Var
		);
		final EList<? extends EObject> Expr_131_list = ExclusiveOrExpression_131_Var
		.getExpr();
		Assert.assertNotNull(Expr_131_list);
		Assert.assertEquals(1, Expr_131_list.size());
		//131
		final AndExpression AndExpression_132_Var
		 = (AndExpression)Expr_131_list.get(0);
		Assert.assertNotNull(AndExpression_132_Var
		);
		final EList<? extends EObject> Expr_132_list = AndExpression_132_Var
		.getExpr();
		Assert.assertNotNull(Expr_132_list);
		Assert.assertEquals(1, Expr_132_list.size());
		//132
		final EqualityExpression EqualityExpression_133_Var
		 = (EqualityExpression)Expr_132_list.get(0);
		Assert.assertNotNull(EqualityExpression_133_Var
		);
		final EList<? extends EObject> Expr_133_list = EqualityExpression_133_Var
		.getExpr();
		Assert.assertNotNull(Expr_133_list);
		Assert.assertEquals(1, Expr_133_list.size());
		//133
		final RelationalExpression RelationalExpression_134_Var
		 = (RelationalExpression)Expr_133_list.get(0);
		Assert.assertNotNull(RelationalExpression_134_Var
		);
		final EList<? extends EObject> Expr_134_list = RelationalExpression_134_Var
		.getExpr();
		Assert.assertNotNull(Expr_134_list);
		Assert.assertEquals(1, Expr_134_list.size());
		//134
		final ShiftExpression ShiftExpression_135_Var
		 = (ShiftExpression)Expr_134_list.get(0);
		Assert.assertNotNull(ShiftExpression_135_Var
		);
		final EList<? extends EObject> Expr_135_list = ShiftExpression_135_Var
		.getExpr();
		Assert.assertNotNull(Expr_135_list);
		Assert.assertEquals(1, Expr_135_list.size());
		//135
		final AdditiveExpression AdditiveExpression_136_Var
		 = (AdditiveExpression)Expr_135_list.get(0);
		Assert.assertNotNull(AdditiveExpression_136_Var
		);
		final EList<? extends EObject> Expr_136_list = AdditiveExpression_136_Var
		.getExpr();
		Assert.assertNotNull(Expr_136_list);
		Assert.assertEquals(1, Expr_136_list.size());
		//136
		final MultiplicativeExpression MultiplicativeExpression_137_Var
		 = (MultiplicativeExpression)Expr_136_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_137_Var
		);
		final EList<? extends EObject> Expr_137_list = MultiplicativeExpression_137_Var
		.getExpr();
		Assert.assertNotNull(Expr_137_list);
		Assert.assertEquals(1, Expr_137_list.size());
		//137
		final CastExpression CastExpression_138_Var
		 = (CastExpression)Expr_137_list.get(0);
		Assert.assertNotNull(CastExpression_138_Var
		);
		//138
		final UnaryExpression UnaryExpression_139_Var
		 = (UnaryExpression)CastExpression_138_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_139_Var
		);
		//139
		final PostfixExpression PostfixExpression_140_Var
		 = (PostfixExpression)UnaryExpression_139_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_140_Var
		);
		final EList<? extends EObject> Expr_140_list = PostfixExpression_140_Var
		.getExpr();
		Assert.assertNotNull(Expr_140_list);
		Assert.assertEquals(1, Expr_140_list.size());
		//140
		final PrimaryExpression PrimaryExpression_141_Var
		 = (PrimaryExpression)Expr_140_list.get(0);
		Assert.assertNotNull(PrimaryExpression_141_Var
		);
		//141
		final Constant Constant_142_Var
		 = (Constant)PrimaryExpression_141_Var
		.getConst();
		Assert.assertNotNull(Constant_142_Var
		);
		Assert.assertEquals("\"+c\"", Constant_142_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_142_list = PostfixExpression_140_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_142_list);
		Assert.assertEquals(1, ArgumentExpressionList_142_list.size());
		//142
		final ArgumentExpressionList ArgumentExpressionList_143_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_142_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_143_Var
		);
		final EList<? extends EObject> Expr_143_list = ArgumentExpressionList_143_Var
		.getExpr();
		Assert.assertNotNull(Expr_143_list);
		Assert.assertEquals(1, Expr_143_list.size());
		//143
		final AssignmentExpression AssignmentExpression_144_Var
		 = (AssignmentExpression)Expr_143_list.get(0);
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
		//157
		final PostfixExpression PostfixExpression_158_Var
		 = (PostfixExpression)UnaryExpression_157_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_158_Var
		);
		final EList<? extends EObject> Expr_158_list = PostfixExpression_158_Var
		.getExpr();
		Assert.assertNotNull(Expr_158_list);
		Assert.assertEquals(1, Expr_158_list.size());
		//158
		final PrimaryExpression PrimaryExpression_159_Var
		 = (PrimaryExpression)Expr_158_list.get(0);
		Assert.assertNotNull(PrimaryExpression_159_Var
		);
		Assert.assertEquals("arg2", PrimaryExpression_159_Var
		.getId());
		//159
		final LogicalOrExpression LogicalOrExpression_160_Var
		 = (LogicalOrExpression)Expr_48_list.get(4);
		Assert.assertNotNull(LogicalOrExpression_160_Var
		);
		final EList<? extends EObject> Expr_160_list = LogicalOrExpression_160_Var
		.getExpr();
		Assert.assertNotNull(Expr_160_list);
		Assert.assertEquals(1, Expr_160_list.size());
		//160
		final LogicalAndExpression LogicalAndExpression_161_Var
		 = (LogicalAndExpression)Expr_160_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_161_Var
		);
		final EList<? extends EObject> Expr_161_list = LogicalAndExpression_161_Var
		.getExpr();
		Assert.assertNotNull(Expr_161_list);
		Assert.assertEquals(1, Expr_161_list.size());
		//161
		final InclusiveOrExpression InclusiveOrExpression_162_Var
		 = (InclusiveOrExpression)Expr_161_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_162_Var
		);
		final EList<? extends EObject> Expr_162_list = InclusiveOrExpression_162_Var
		.getExpr();
		Assert.assertNotNull(Expr_162_list);
		Assert.assertEquals(1, Expr_162_list.size());
		//162
		final ExclusiveOrExpression ExclusiveOrExpression_163_Var
		 = (ExclusiveOrExpression)Expr_162_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_163_Var
		);
		final EList<? extends EObject> Expr_163_list = ExclusiveOrExpression_163_Var
		.getExpr();
		Assert.assertNotNull(Expr_163_list);
		Assert.assertEquals(1, Expr_163_list.size());
		//163
		final AndExpression AndExpression_164_Var
		 = (AndExpression)Expr_163_list.get(0);
		Assert.assertNotNull(AndExpression_164_Var
		);
		final EList<? extends EObject> Expr_164_list = AndExpression_164_Var
		.getExpr();
		Assert.assertNotNull(Expr_164_list);
		Assert.assertEquals(1, Expr_164_list.size());
		//164
		final EqualityExpression EqualityExpression_165_Var
		 = (EqualityExpression)Expr_164_list.get(0);
		Assert.assertNotNull(EqualityExpression_165_Var
		);
		final EList<? extends EObject> Expr_165_list = EqualityExpression_165_Var
		.getExpr();
		Assert.assertNotNull(Expr_165_list);
		Assert.assertEquals(1, Expr_165_list.size());
		//165
		final RelationalExpression RelationalExpression_166_Var
		 = (RelationalExpression)Expr_165_list.get(0);
		Assert.assertNotNull(RelationalExpression_166_Var
		);
		final EList<? extends EObject> Expr_166_list = RelationalExpression_166_Var
		.getExpr();
		Assert.assertNotNull(Expr_166_list);
		Assert.assertEquals(1, Expr_166_list.size());
		//166
		final ShiftExpression ShiftExpression_167_Var
		 = (ShiftExpression)Expr_166_list.get(0);
		Assert.assertNotNull(ShiftExpression_167_Var
		);
		final EList<? extends EObject> Expr_167_list = ShiftExpression_167_Var
		.getExpr();
		Assert.assertNotNull(Expr_167_list);
		Assert.assertEquals(1, Expr_167_list.size());
		//167
		final AdditiveExpression AdditiveExpression_168_Var
		 = (AdditiveExpression)Expr_167_list.get(0);
		Assert.assertNotNull(AdditiveExpression_168_Var
		);
		final EList<? extends EObject> Expr_168_list = AdditiveExpression_168_Var
		.getExpr();
		Assert.assertNotNull(Expr_168_list);
		Assert.assertEquals(1, Expr_168_list.size());
		//168
		final MultiplicativeExpression MultiplicativeExpression_169_Var
		 = (MultiplicativeExpression)Expr_168_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_169_Var
		);
		final EList<? extends EObject> Expr_169_list = MultiplicativeExpression_169_Var
		.getExpr();
		Assert.assertNotNull(Expr_169_list);
		Assert.assertEquals(1, Expr_169_list.size());
		//169
		final CastExpression CastExpression_170_Var
		 = (CastExpression)Expr_169_list.get(0);
		Assert.assertNotNull(CastExpression_170_Var
		);
		//170
		final UnaryExpression UnaryExpression_171_Var
		 = (UnaryExpression)CastExpression_170_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_171_Var
		);
		//171
		final PostfixExpression PostfixExpression_172_Var
		 = (PostfixExpression)UnaryExpression_171_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_172_Var
		);
		final EList<? extends EObject> Expr_172_list = PostfixExpression_172_Var
		.getExpr();
		Assert.assertNotNull(Expr_172_list);
		Assert.assertEquals(1, Expr_172_list.size());
		//172
		final PrimaryExpression PrimaryExpression_173_Var
		 = (PrimaryExpression)Expr_172_list.get(0);
		Assert.assertNotNull(PrimaryExpression_173_Var
		);
		//173
		final Constant Constant_174_Var
		 = (Constant)PrimaryExpression_173_Var
		.getConst();
		Assert.assertNotNull(Constant_174_Var
		);
		Assert.assertEquals("\"+d\"", Constant_174_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_174_list = PostfixExpression_172_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_174_list);
		Assert.assertEquals(1, ArgumentExpressionList_174_list.size());
		//174
		final ArgumentExpressionList ArgumentExpressionList_175_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_174_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_175_Var
		);
		final EList<? extends EObject> Expr_175_list = ArgumentExpressionList_175_Var
		.getExpr();
		Assert.assertNotNull(Expr_175_list);
		Assert.assertEquals(1, Expr_175_list.size());
		//175
		final AssignmentExpression AssignmentExpression_176_Var
		 = (AssignmentExpression)Expr_175_list.get(0);
		Assert.assertNotNull(AssignmentExpression_176_Var
		);
		//176
		final ConditionalExpression ConditionalExpression_177_Var
		 = (ConditionalExpression)AssignmentExpression_176_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_177_Var
		);
		//177
		final LogicalOrExpression LogicalOrExpression_178_Var
		 = (LogicalOrExpression)ConditionalExpression_177_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_178_Var
		);
		final EList<? extends EObject> Expr_178_list = LogicalOrExpression_178_Var
		.getExpr();
		Assert.assertNotNull(Expr_178_list);
		Assert.assertEquals(1, Expr_178_list.size());
		//178
		final LogicalAndExpression LogicalAndExpression_179_Var
		 = (LogicalAndExpression)Expr_178_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_179_Var
		);
		final EList<? extends EObject> Expr_179_list = LogicalAndExpression_179_Var
		.getExpr();
		Assert.assertNotNull(Expr_179_list);
		Assert.assertEquals(1, Expr_179_list.size());
		//179
		final InclusiveOrExpression InclusiveOrExpression_180_Var
		 = (InclusiveOrExpression)Expr_179_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_180_Var
		);
		final EList<? extends EObject> Expr_180_list = InclusiveOrExpression_180_Var
		.getExpr();
		Assert.assertNotNull(Expr_180_list);
		Assert.assertEquals(1, Expr_180_list.size());
		//180
		final ExclusiveOrExpression ExclusiveOrExpression_181_Var
		 = (ExclusiveOrExpression)Expr_180_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_181_Var
		);
		final EList<? extends EObject> Expr_181_list = ExclusiveOrExpression_181_Var
		.getExpr();
		Assert.assertNotNull(Expr_181_list);
		Assert.assertEquals(1, Expr_181_list.size());
		//181
		final AndExpression AndExpression_182_Var
		 = (AndExpression)Expr_181_list.get(0);
		Assert.assertNotNull(AndExpression_182_Var
		);
		final EList<? extends EObject> Expr_182_list = AndExpression_182_Var
		.getExpr();
		Assert.assertNotNull(Expr_182_list);
		Assert.assertEquals(1, Expr_182_list.size());
		//182
		final EqualityExpression EqualityExpression_183_Var
		 = (EqualityExpression)Expr_182_list.get(0);
		Assert.assertNotNull(EqualityExpression_183_Var
		);
		final EList<? extends EObject> Expr_183_list = EqualityExpression_183_Var
		.getExpr();
		Assert.assertNotNull(Expr_183_list);
		Assert.assertEquals(1, Expr_183_list.size());
		//183
		final RelationalExpression RelationalExpression_184_Var
		 = (RelationalExpression)Expr_183_list.get(0);
		Assert.assertNotNull(RelationalExpression_184_Var
		);
		final EList<? extends EObject> Expr_184_list = RelationalExpression_184_Var
		.getExpr();
		Assert.assertNotNull(Expr_184_list);
		Assert.assertEquals(1, Expr_184_list.size());
		//184
		final ShiftExpression ShiftExpression_185_Var
		 = (ShiftExpression)Expr_184_list.get(0);
		Assert.assertNotNull(ShiftExpression_185_Var
		);
		final EList<? extends EObject> Expr_185_list = ShiftExpression_185_Var
		.getExpr();
		Assert.assertNotNull(Expr_185_list);
		Assert.assertEquals(1, Expr_185_list.size());
		//185
		final AdditiveExpression AdditiveExpression_186_Var
		 = (AdditiveExpression)Expr_185_list.get(0);
		Assert.assertNotNull(AdditiveExpression_186_Var
		);
		final EList<? extends EObject> Expr_186_list = AdditiveExpression_186_Var
		.getExpr();
		Assert.assertNotNull(Expr_186_list);
		Assert.assertEquals(1, Expr_186_list.size());
		//186
		final MultiplicativeExpression MultiplicativeExpression_187_Var
		 = (MultiplicativeExpression)Expr_186_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_187_Var
		);
		final EList<? extends EObject> Expr_187_list = MultiplicativeExpression_187_Var
		.getExpr();
		Assert.assertNotNull(Expr_187_list);
		Assert.assertEquals(1, Expr_187_list.size());
		//187
		final CastExpression CastExpression_188_Var
		 = (CastExpression)Expr_187_list.get(0);
		Assert.assertNotNull(CastExpression_188_Var
		);
		//188
		final UnaryExpression UnaryExpression_189_Var
		 = (UnaryExpression)CastExpression_188_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_189_Var
		);
		//189
		final PostfixExpression PostfixExpression_190_Var
		 = (PostfixExpression)UnaryExpression_189_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_190_Var
		);
		final EList<? extends EObject> Expr_190_list = PostfixExpression_190_Var
		.getExpr();
		Assert.assertNotNull(Expr_190_list);
		Assert.assertEquals(1, Expr_190_list.size());
		//190
		final PrimaryExpression PrimaryExpression_191_Var
		 = (PrimaryExpression)Expr_190_list.get(0);
		Assert.assertNotNull(PrimaryExpression_191_Var
		);
		Assert.assertEquals("arg3", PrimaryExpression_191_Var
		.getId());
		//191
		final LogicalOrExpression LogicalOrExpression_192_Var
		 = (LogicalOrExpression)Expr_48_list.get(5);
		Assert.assertNotNull(LogicalOrExpression_192_Var
		);
		final EList<? extends EObject> Expr_192_list = LogicalOrExpression_192_Var
		.getExpr();
		Assert.assertNotNull(Expr_192_list);
		Assert.assertEquals(1, Expr_192_list.size());
		//192
		final LogicalAndExpression LogicalAndExpression_193_Var
		 = (LogicalAndExpression)Expr_192_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_193_Var
		);
		final EList<? extends EObject> Expr_193_list = LogicalAndExpression_193_Var
		.getExpr();
		Assert.assertNotNull(Expr_193_list);
		Assert.assertEquals(1, Expr_193_list.size());
		//193
		final InclusiveOrExpression InclusiveOrExpression_194_Var
		 = (InclusiveOrExpression)Expr_193_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_194_Var
		);
		final EList<? extends EObject> Expr_194_list = InclusiveOrExpression_194_Var
		.getExpr();
		Assert.assertNotNull(Expr_194_list);
		Assert.assertEquals(1, Expr_194_list.size());
		//194
		final ExclusiveOrExpression ExclusiveOrExpression_195_Var
		 = (ExclusiveOrExpression)Expr_194_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_195_Var
		);
		final EList<? extends EObject> Expr_195_list = ExclusiveOrExpression_195_Var
		.getExpr();
		Assert.assertNotNull(Expr_195_list);
		Assert.assertEquals(1, Expr_195_list.size());
		//195
		final AndExpression AndExpression_196_Var
		 = (AndExpression)Expr_195_list.get(0);
		Assert.assertNotNull(AndExpression_196_Var
		);
		final EList<? extends EObject> Expr_196_list = AndExpression_196_Var
		.getExpr();
		Assert.assertNotNull(Expr_196_list);
		Assert.assertEquals(1, Expr_196_list.size());
		//196
		final EqualityExpression EqualityExpression_197_Var
		 = (EqualityExpression)Expr_196_list.get(0);
		Assert.assertNotNull(EqualityExpression_197_Var
		);
		final EList<? extends EObject> Expr_197_list = EqualityExpression_197_Var
		.getExpr();
		Assert.assertNotNull(Expr_197_list);
		Assert.assertEquals(1, Expr_197_list.size());
		//197
		final RelationalExpression RelationalExpression_198_Var
		 = (RelationalExpression)Expr_197_list.get(0);
		Assert.assertNotNull(RelationalExpression_198_Var
		);
		final EList<? extends EObject> Expr_198_list = RelationalExpression_198_Var
		.getExpr();
		Assert.assertNotNull(Expr_198_list);
		Assert.assertEquals(1, Expr_198_list.size());
		//198
		final ShiftExpression ShiftExpression_199_Var
		 = (ShiftExpression)Expr_198_list.get(0);
		Assert.assertNotNull(ShiftExpression_199_Var
		);
		final EList<? extends EObject> Expr_199_list = ShiftExpression_199_Var
		.getExpr();
		Assert.assertNotNull(Expr_199_list);
		Assert.assertEquals(1, Expr_199_list.size());
		//199
		final AdditiveExpression AdditiveExpression_200_Var
		 = (AdditiveExpression)Expr_199_list.get(0);
		Assert.assertNotNull(AdditiveExpression_200_Var
		);
		final EList<? extends EObject> Expr_200_list = AdditiveExpression_200_Var
		.getExpr();
		Assert.assertNotNull(Expr_200_list);
		Assert.assertEquals(1, Expr_200_list.size());
		//200
		final MultiplicativeExpression MultiplicativeExpression_201_Var
		 = (MultiplicativeExpression)Expr_200_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_201_Var
		);
		final EList<? extends EObject> Expr_201_list = MultiplicativeExpression_201_Var
		.getExpr();
		Assert.assertNotNull(Expr_201_list);
		Assert.assertEquals(1, Expr_201_list.size());
		//201
		final CastExpression CastExpression_202_Var
		 = (CastExpression)Expr_201_list.get(0);
		Assert.assertNotNull(CastExpression_202_Var
		);
		//202
		final UnaryExpression UnaryExpression_203_Var
		 = (UnaryExpression)CastExpression_202_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_203_Var
		);
		//203
		final PostfixExpression PostfixExpression_204_Var
		 = (PostfixExpression)UnaryExpression_203_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_204_Var
		);
		final EList<? extends EObject> Expr_204_list = PostfixExpression_204_Var
		.getExpr();
		Assert.assertNotNull(Expr_204_list);
		Assert.assertEquals(1, Expr_204_list.size());
		//204
		final PrimaryExpression PrimaryExpression_205_Var
		 = (PrimaryExpression)Expr_204_list.get(0);
		Assert.assertNotNull(PrimaryExpression_205_Var
		);
		//205
		final Constant Constant_206_Var
		 = (Constant)PrimaryExpression_205_Var
		.getConst();
		Assert.assertNotNull(Constant_206_Var
		);
		Assert.assertEquals("\"a\"", Constant_206_Var
		.getStr());
		final EList<? extends EObject> ArgumentExpressionList_206_list = PostfixExpression_204_Var
		.getArgumentExpressionList();
		Assert.assertNotNull(ArgumentExpressionList_206_list);
		Assert.assertEquals(1, ArgumentExpressionList_206_list.size());
		//206
		final ArgumentExpressionList ArgumentExpressionList_207_Var
		 = (ArgumentExpressionList)ArgumentExpressionList_206_list.get(0);
		Assert.assertNotNull(ArgumentExpressionList_207_Var
		);
		final EList<? extends EObject> Expr_207_list = ArgumentExpressionList_207_Var
		.getExpr();
		Assert.assertNotNull(Expr_207_list);
		Assert.assertEquals(1, Expr_207_list.size());
		//207
		final AssignmentExpression AssignmentExpression_208_Var
		 = (AssignmentExpression)Expr_207_list.get(0);
		Assert.assertNotNull(AssignmentExpression_208_Var
		);
		//208
		final ConditionalExpression ConditionalExpression_209_Var
		 = (ConditionalExpression)AssignmentExpression_208_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_209_Var
		);
		//209
		final LogicalOrExpression LogicalOrExpression_210_Var
		 = (LogicalOrExpression)ConditionalExpression_209_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_210_Var
		);
		final EList<? extends EObject> Expr_210_list = LogicalOrExpression_210_Var
		.getExpr();
		Assert.assertNotNull(Expr_210_list);
		Assert.assertEquals(1, Expr_210_list.size());
		//210
		final LogicalAndExpression LogicalAndExpression_211_Var
		 = (LogicalAndExpression)Expr_210_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_211_Var
		);
		final EList<? extends EObject> Expr_211_list = LogicalAndExpression_211_Var
		.getExpr();
		Assert.assertNotNull(Expr_211_list);
		Assert.assertEquals(1, Expr_211_list.size());
		//211
		final InclusiveOrExpression InclusiveOrExpression_212_Var
		 = (InclusiveOrExpression)Expr_211_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_212_Var
		);
		final EList<? extends EObject> Expr_212_list = InclusiveOrExpression_212_Var
		.getExpr();
		Assert.assertNotNull(Expr_212_list);
		Assert.assertEquals(1, Expr_212_list.size());
		//212
		final ExclusiveOrExpression ExclusiveOrExpression_213_Var
		 = (ExclusiveOrExpression)Expr_212_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_213_Var
		);
		final EList<? extends EObject> Expr_213_list = ExclusiveOrExpression_213_Var
		.getExpr();
		Assert.assertNotNull(Expr_213_list);
		Assert.assertEquals(1, Expr_213_list.size());
		//213
		final AndExpression AndExpression_214_Var
		 = (AndExpression)Expr_213_list.get(0);
		Assert.assertNotNull(AndExpression_214_Var
		);
		final EList<? extends EObject> Expr_214_list = AndExpression_214_Var
		.getExpr();
		Assert.assertNotNull(Expr_214_list);
		Assert.assertEquals(1, Expr_214_list.size());
		//214
		final EqualityExpression EqualityExpression_215_Var
		 = (EqualityExpression)Expr_214_list.get(0);
		Assert.assertNotNull(EqualityExpression_215_Var
		);
		final EList<? extends EObject> Expr_215_list = EqualityExpression_215_Var
		.getExpr();
		Assert.assertNotNull(Expr_215_list);
		Assert.assertEquals(1, Expr_215_list.size());
		//215
		final RelationalExpression RelationalExpression_216_Var
		 = (RelationalExpression)Expr_215_list.get(0);
		Assert.assertNotNull(RelationalExpression_216_Var
		);
		final EList<? extends EObject> Expr_216_list = RelationalExpression_216_Var
		.getExpr();
		Assert.assertNotNull(Expr_216_list);
		Assert.assertEquals(1, Expr_216_list.size());
		//216
		final ShiftExpression ShiftExpression_217_Var
		 = (ShiftExpression)Expr_216_list.get(0);
		Assert.assertNotNull(ShiftExpression_217_Var
		);
		final EList<? extends EObject> Expr_217_list = ShiftExpression_217_Var
		.getExpr();
		Assert.assertNotNull(Expr_217_list);
		Assert.assertEquals(1, Expr_217_list.size());
		//217
		final AdditiveExpression AdditiveExpression_218_Var
		 = (AdditiveExpression)Expr_217_list.get(0);
		Assert.assertNotNull(AdditiveExpression_218_Var
		);
		final EList<? extends EObject> Expr_218_list = AdditiveExpression_218_Var
		.getExpr();
		Assert.assertNotNull(Expr_218_list);
		Assert.assertEquals(1, Expr_218_list.size());
		//218
		final MultiplicativeExpression MultiplicativeExpression_219_Var
		 = (MultiplicativeExpression)Expr_218_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_219_Var
		);
		final EList<? extends EObject> Expr_219_list = MultiplicativeExpression_219_Var
		.getExpr();
		Assert.assertNotNull(Expr_219_list);
		Assert.assertEquals(1, Expr_219_list.size());
		//219
		final CastExpression CastExpression_220_Var
		 = (CastExpression)Expr_219_list.get(0);
		Assert.assertNotNull(CastExpression_220_Var
		);
		//220
		final UnaryExpression UnaryExpression_221_Var
		 = (UnaryExpression)CastExpression_220_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_221_Var
		);
		//221
		final PostfixExpression PostfixExpression_222_Var
		 = (PostfixExpression)UnaryExpression_221_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_222_Var
		);
		final EList<? extends EObject> Expr_222_list = PostfixExpression_222_Var
		.getExpr();
		Assert.assertNotNull(Expr_222_list);
		Assert.assertEquals(1, Expr_222_list.size());
		//222
		final PrimaryExpression PrimaryExpression_223_Var
		 = (PrimaryExpression)Expr_222_list.get(0);
		Assert.assertNotNull(PrimaryExpression_223_Var
		);
		//223
		final Constant Constant_224_Var
		 = (Constant)PrimaryExpression_223_Var
		.getConst();
		Assert.assertNotNull(Constant_224_Var
		);
		Assert.assertEquals("128", Constant_224_Var
		.getDec());
		//224
		final LogicalOrExpression LogicalOrExpression_225_Var
		 = (LogicalOrExpression)Expr_48_list.get(6);
		Assert.assertNotNull(LogicalOrExpression_225_Var
		);
		final EList<? extends EObject> Expr_225_list = LogicalOrExpression_225_Var
		.getExpr();
		Assert.assertNotNull(Expr_225_list);
		Assert.assertEquals(1, Expr_225_list.size());
		//225
		final LogicalAndExpression LogicalAndExpression_226_Var
		 = (LogicalAndExpression)Expr_225_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_226_Var
		);
		final EList<? extends EObject> Expr_226_list = LogicalAndExpression_226_Var
		.getExpr();
		Assert.assertNotNull(Expr_226_list);
		Assert.assertEquals(1, Expr_226_list.size());
		//226
		final InclusiveOrExpression InclusiveOrExpression_227_Var
		 = (InclusiveOrExpression)Expr_226_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_227_Var
		);
		final EList<? extends EObject> Expr_227_list = InclusiveOrExpression_227_Var
		.getExpr();
		Assert.assertNotNull(Expr_227_list);
		Assert.assertEquals(1, Expr_227_list.size());
		//227
		final ExclusiveOrExpression ExclusiveOrExpression_228_Var
		 = (ExclusiveOrExpression)Expr_227_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_228_Var
		);
		final EList<? extends EObject> Expr_228_list = ExclusiveOrExpression_228_Var
		.getExpr();
		Assert.assertNotNull(Expr_228_list);
		Assert.assertEquals(1, Expr_228_list.size());
		//228
		final AndExpression AndExpression_229_Var
		 = (AndExpression)Expr_228_list.get(0);
		Assert.assertNotNull(AndExpression_229_Var
		);
		final EList<? extends EObject> Expr_229_list = AndExpression_229_Var
		.getExpr();
		Assert.assertNotNull(Expr_229_list);
		Assert.assertEquals(1, Expr_229_list.size());
		//229
		final EqualityExpression EqualityExpression_230_Var
		 = (EqualityExpression)Expr_229_list.get(0);
		Assert.assertNotNull(EqualityExpression_230_Var
		);
		final EList<? extends EObject> Expr_230_list = EqualityExpression_230_Var
		.getExpr();
		Assert.assertNotNull(Expr_230_list);
		Assert.assertEquals(1, Expr_230_list.size());
		//230
		final RelationalExpression RelationalExpression_231_Var
		 = (RelationalExpression)Expr_230_list.get(0);
		Assert.assertNotNull(RelationalExpression_231_Var
		);
		final EList<? extends EObject> Expr_231_list = RelationalExpression_231_Var
		.getExpr();
		Assert.assertNotNull(Expr_231_list);
		Assert.assertEquals(1, Expr_231_list.size());
		//231
		final ShiftExpression ShiftExpression_232_Var
		 = (ShiftExpression)Expr_231_list.get(0);
		Assert.assertNotNull(ShiftExpression_232_Var
		);
		final EList<? extends EObject> Expr_232_list = ShiftExpression_232_Var
		.getExpr();
		Assert.assertNotNull(Expr_232_list);
		Assert.assertEquals(1, Expr_232_list.size());
		//232
		final AdditiveExpression AdditiveExpression_233_Var
		 = (AdditiveExpression)Expr_232_list.get(0);
		Assert.assertNotNull(AdditiveExpression_233_Var
		);
		final EList<? extends EObject> Expr_233_list = AdditiveExpression_233_Var
		.getExpr();
		Assert.assertNotNull(Expr_233_list);
		Assert.assertEquals(1, Expr_233_list.size());
		//233
		final MultiplicativeExpression MultiplicativeExpression_234_Var
		 = (MultiplicativeExpression)Expr_233_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_234_Var
		);
		final EList<? extends EObject> Expr_234_list = MultiplicativeExpression_234_Var
		.getExpr();
		Assert.assertNotNull(Expr_234_list);
		Assert.assertEquals(1, Expr_234_list.size());
		//234
		final CastExpression CastExpression_235_Var
		 = (CastExpression)Expr_234_list.get(0);
		Assert.assertNotNull(CastExpression_235_Var
		);
		//235
		final UnaryExpression UnaryExpression_236_Var
		 = (UnaryExpression)CastExpression_235_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_236_Var
		);
		//236
		final PostfixExpression PostfixExpression_237_Var
		 = (PostfixExpression)UnaryExpression_236_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_237_Var
		);
		final EList<? extends EObject> Expr_237_list = PostfixExpression_237_Var
		.getExpr();
		Assert.assertNotNull(Expr_237_list);
		Assert.assertEquals(1, Expr_237_list.size());
		//237
		final PrimaryExpression PrimaryExpression_238_Var
		 = (PrimaryExpression)Expr_237_list.get(0);
		Assert.assertNotNull(PrimaryExpression_238_Var
		);
		//238
		final Constant Constant_239_Var
		 = (Constant)PrimaryExpression_238_Var
		.getConst();
		Assert.assertNotNull(Constant_239_Var
		);
		Assert.assertEquals("\"memory\"", Constant_239_Var
		.getStr());
		//239
		final LogicalOrExpression LogicalOrExpression_240_Var
		 = (LogicalOrExpression)Expr_48_list.get(7);
		Assert.assertNotNull(LogicalOrExpression_240_Var
		);
		final EList<? extends EObject> Expr_240_list = LogicalOrExpression_240_Var
		.getExpr();
		Assert.assertNotNull(Expr_240_list);
		Assert.assertEquals(1, Expr_240_list.size());
		//240
		final LogicalAndExpression LogicalAndExpression_241_Var
		 = (LogicalAndExpression)Expr_240_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_241_Var
		);
		final EList<? extends EObject> Expr_241_list = LogicalAndExpression_241_Var
		.getExpr();
		Assert.assertNotNull(Expr_241_list);
		Assert.assertEquals(1, Expr_241_list.size());
		//241
		final InclusiveOrExpression InclusiveOrExpression_242_Var
		 = (InclusiveOrExpression)Expr_241_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_242_Var
		);
		final EList<? extends EObject> Expr_242_list = InclusiveOrExpression_242_Var
		.getExpr();
		Assert.assertNotNull(Expr_242_list);
		Assert.assertEquals(1, Expr_242_list.size());
		//242
		final ExclusiveOrExpression ExclusiveOrExpression_243_Var
		 = (ExclusiveOrExpression)Expr_242_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_243_Var
		);
		final EList<? extends EObject> Expr_243_list = ExclusiveOrExpression_243_Var
		.getExpr();
		Assert.assertNotNull(Expr_243_list);
		Assert.assertEquals(1, Expr_243_list.size());
		//243
		final AndExpression AndExpression_244_Var
		 = (AndExpression)Expr_243_list.get(0);
		Assert.assertNotNull(AndExpression_244_Var
		);
		final EList<? extends EObject> Expr_244_list = AndExpression_244_Var
		.getExpr();
		Assert.assertNotNull(Expr_244_list);
		Assert.assertEquals(1, Expr_244_list.size());
		//244
		final EqualityExpression EqualityExpression_245_Var
		 = (EqualityExpression)Expr_244_list.get(0);
		Assert.assertNotNull(EqualityExpression_245_Var
		);
		final EList<? extends EObject> Expr_245_list = EqualityExpression_245_Var
		.getExpr();
		Assert.assertNotNull(Expr_245_list);
		Assert.assertEquals(1, Expr_245_list.size());
		//245
		final RelationalExpression RelationalExpression_246_Var
		 = (RelationalExpression)Expr_245_list.get(0);
		Assert.assertNotNull(RelationalExpression_246_Var
		);
		final EList<? extends EObject> Expr_246_list = RelationalExpression_246_Var
		.getExpr();
		Assert.assertNotNull(Expr_246_list);
		Assert.assertEquals(1, Expr_246_list.size());
		//246
		final ShiftExpression ShiftExpression_247_Var
		 = (ShiftExpression)Expr_246_list.get(0);
		Assert.assertNotNull(ShiftExpression_247_Var
		);
		final EList<? extends EObject> Expr_247_list = ShiftExpression_247_Var
		.getExpr();
		Assert.assertNotNull(Expr_247_list);
		Assert.assertEquals(1, Expr_247_list.size());
		//247
		final AdditiveExpression AdditiveExpression_248_Var
		 = (AdditiveExpression)Expr_247_list.get(0);
		Assert.assertNotNull(AdditiveExpression_248_Var
		);
		final EList<? extends EObject> Expr_248_list = AdditiveExpression_248_Var
		.getExpr();
		Assert.assertNotNull(Expr_248_list);
		Assert.assertEquals(1, Expr_248_list.size());
		//248
		final MultiplicativeExpression MultiplicativeExpression_249_Var
		 = (MultiplicativeExpression)Expr_248_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_249_Var
		);
		final EList<? extends EObject> Expr_249_list = MultiplicativeExpression_249_Var
		.getExpr();
		Assert.assertNotNull(Expr_249_list);
		Assert.assertEquals(1, Expr_249_list.size());
		//249
		final CastExpression CastExpression_250_Var
		 = (CastExpression)Expr_249_list.get(0);
		Assert.assertNotNull(CastExpression_250_Var
		);
		//250
		final UnaryExpression UnaryExpression_251_Var
		 = (UnaryExpression)CastExpression_250_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_251_Var
		);
		//251
		final PostfixExpression PostfixExpression_252_Var
		 = (PostfixExpression)UnaryExpression_251_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_252_Var
		);
		final EList<? extends EObject> Expr_252_list = PostfixExpression_252_Var
		.getExpr();
		Assert.assertNotNull(Expr_252_list);
		Assert.assertEquals(1, Expr_252_list.size());
		//252
		final PrimaryExpression PrimaryExpression_253_Var
		 = (PrimaryExpression)Expr_252_list.get(0);
		Assert.assertNotNull(PrimaryExpression_253_Var
		);
		//253
		final Constant Constant_254_Var
		 = (Constant)PrimaryExpression_253_Var
		.getConst();
		Assert.assertNotNull(Constant_254_Var
		);
		Assert.assertEquals("\"cc\"", Constant_254_Var
		.getStr());
		Assert.assertEquals(";", AsmStatement_48_Var
		.getSemi());
		//254
		final Statement Statement_255_Var
		 = (Statement)Statement_46_list.get(1);
		Assert.assertNotNull(Statement_255_Var
		);
		//255
		final SelectionStatement SelectionStatement_256_Var
		 = (SelectionStatement)Statement_255_Var
		.getStmt();
		Assert.assertNotNull(SelectionStatement_256_Var
		);
		Assert.assertEquals("if", SelectionStatement_256_Var
		.getIf());
		//256
		final Expression Expression_257_Var
		 = (Expression)SelectionStatement_256_Var
		.getExpr();
		Assert.assertNotNull(Expression_257_Var
		);
		final EList<? extends EObject> ExprExpr_257_list = Expression_257_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_257_list);
		Assert.assertEquals(1, ExprExpr_257_list.size());
		//257
		final AssignmentExpression AssignmentExpression_258_Var
		 = (AssignmentExpression)ExprExpr_257_list.get(0);
		Assert.assertNotNull(AssignmentExpression_258_Var
		);
		//258
		final ConditionalExpression ConditionalExpression_259_Var
		 = (ConditionalExpression)AssignmentExpression_258_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_259_Var
		);
		//259
		final LogicalOrExpression LogicalOrExpression_260_Var
		 = (LogicalOrExpression)ConditionalExpression_259_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_260_Var
		);
		final EList<? extends EObject> Expr_260_list = LogicalOrExpression_260_Var
		.getExpr();
		Assert.assertNotNull(Expr_260_list);
		Assert.assertEquals(1, Expr_260_list.size());
		//260
		final LogicalAndExpression LogicalAndExpression_261_Var
		 = (LogicalAndExpression)Expr_260_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_261_Var
		);
		final EList<? extends EObject> Expr_261_list = LogicalAndExpression_261_Var
		.getExpr();
		Assert.assertNotNull(Expr_261_list);
		Assert.assertEquals(2, Expr_261_list.size());
		//261
		final InclusiveOrExpression InclusiveOrExpression_262_Var
		 = (InclusiveOrExpression)Expr_261_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_262_Var
		);
		final EList<? extends EObject> Expr_262_list = InclusiveOrExpression_262_Var
		.getExpr();
		Assert.assertNotNull(Expr_262_list);
		Assert.assertEquals(1, Expr_262_list.size());
		//262
		final ExclusiveOrExpression ExclusiveOrExpression_263_Var
		 = (ExclusiveOrExpression)Expr_262_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_263_Var
		);
		final EList<? extends EObject> Expr_263_list = ExclusiveOrExpression_263_Var
		.getExpr();
		Assert.assertNotNull(Expr_263_list);
		Assert.assertEquals(1, Expr_263_list.size());
		//263
		final AndExpression AndExpression_264_Var
		 = (AndExpression)Expr_263_list.get(0);
		Assert.assertNotNull(AndExpression_264_Var
		);
		final EList<? extends EObject> Expr_264_list = AndExpression_264_Var
		.getExpr();
		Assert.assertNotNull(Expr_264_list);
		Assert.assertEquals(1, Expr_264_list.size());
		//264
		final EqualityExpression EqualityExpression_265_Var
		 = (EqualityExpression)Expr_264_list.get(0);
		Assert.assertNotNull(EqualityExpression_265_Var
		);
		final EList<? extends EObject> Expr_265_list = EqualityExpression_265_Var
		.getExpr();
		Assert.assertNotNull(Expr_265_list);
		Assert.assertEquals(1, Expr_265_list.size());
		//265
		final RelationalExpression RelationalExpression_266_Var
		 = (RelationalExpression)Expr_265_list.get(0);
		Assert.assertNotNull(RelationalExpression_266_Var
		);
		Assert.assertEquals("[<=]", RelationalExpression_266_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_266_list = RelationalExpression_266_Var
		.getExpr();
		Assert.assertNotNull(Expr_266_list);
		Assert.assertEquals(2, Expr_266_list.size());
		//266
		final ShiftExpression ShiftExpression_267_Var
		 = (ShiftExpression)Expr_266_list.get(0);
		Assert.assertNotNull(ShiftExpression_267_Var
		);
		final EList<? extends EObject> Expr_267_list = ShiftExpression_267_Var
		.getExpr();
		Assert.assertNotNull(Expr_267_list);
		Assert.assertEquals(1, Expr_267_list.size());
		//267
		final AdditiveExpression AdditiveExpression_268_Var
		 = (AdditiveExpression)Expr_267_list.get(0);
		Assert.assertNotNull(AdditiveExpression_268_Var
		);
		final EList<? extends EObject> Expr_268_list = AdditiveExpression_268_Var
		.getExpr();
		Assert.assertNotNull(Expr_268_list);
		Assert.assertEquals(1, Expr_268_list.size());
		//268
		final MultiplicativeExpression MultiplicativeExpression_269_Var
		 = (MultiplicativeExpression)Expr_268_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_269_Var
		);
		final EList<? extends EObject> Expr_269_list = MultiplicativeExpression_269_Var
		.getExpr();
		Assert.assertNotNull(Expr_269_list);
		Assert.assertEquals(1, Expr_269_list.size());
		//269
		final CastExpression CastExpression_270_Var
		 = (CastExpression)Expr_269_list.get(0);
		Assert.assertNotNull(CastExpression_270_Var
		);
		//270
		final UnaryExpression UnaryExpression_271_Var
		 = (UnaryExpression)CastExpression_270_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_271_Var
		);
		//271
		final CastExpression CastExpression_272_Var
		 = (CastExpression)UnaryExpression_271_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_272_Var
		);
		//272
		final UnaryExpression UnaryExpression_273_Var
		 = (UnaryExpression)CastExpression_272_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_273_Var
		);
		//273
		final PostfixExpression PostfixExpression_274_Var
		 = (PostfixExpression)UnaryExpression_273_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_274_Var
		);
		final EList<? extends EObject> Expr_274_list = PostfixExpression_274_Var
		.getExpr();
		Assert.assertNotNull(Expr_274_list);
		Assert.assertEquals(1, Expr_274_list.size());
		//274
		final PrimaryExpression PrimaryExpression_275_Var
		 = (PrimaryExpression)Expr_274_list.get(0);
		Assert.assertNotNull(PrimaryExpression_275_Var
		);
		//275
		final Constant Constant_276_Var
		 = (Constant)PrimaryExpression_275_Var
		.getConst();
		Assert.assertNotNull(Constant_276_Var
		);
		Assert.assertEquals("125", Constant_276_Var
		.getDec());
		//276
		final UnaryOperator UnaryOperator_277_Var
		 = (UnaryOperator)UnaryExpression_271_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_277_Var
		);
		Assert.assertEquals("-", UnaryOperator_277_Var
		.getOp());
		//277
		final ShiftExpression ShiftExpression_278_Var
		 = (ShiftExpression)Expr_266_list.get(1);
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
		Assert.assertEquals("res", PrimaryExpression_284_Var
		.getId());
		//284
		final InclusiveOrExpression InclusiveOrExpression_285_Var
		 = (InclusiveOrExpression)Expr_261_list.get(1);
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
		Assert.assertEquals("[<]", RelationalExpression_289_Var
		.getOp().toString());
		final EList<? extends EObject> Expr_289_list = RelationalExpression_289_Var
		.getExpr();
		Assert.assertNotNull(Expr_289_list);
		Assert.assertEquals(2, Expr_289_list.size());
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
		Assert.assertEquals("res", PrimaryExpression_296_Var
		.getId());
		//296
		final ShiftExpression ShiftExpression_297_Var
		 = (ShiftExpression)Expr_289_list.get(1);
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
		//303
		final Constant Constant_304_Var
		 = (Constant)PrimaryExpression_303_Var
		.getConst();
		Assert.assertNotNull(Constant_304_Var
		);
		Assert.assertEquals("0", Constant_304_Var
		.getDec());
		//304
		final Statement Statement_305_Var
		 = (Statement)SelectionStatement_256_Var
		.getIfStatement();
		Assert.assertNotNull(Statement_305_Var
		);
		//305
		final CompoundStatement CompoundStatement_306_Var
		 = (CompoundStatement)Statement_305_Var
		.getStmt();
		Assert.assertNotNull(CompoundStatement_306_Var
		);
		//306
		final BodyStatement BodyStatement_307_Var
		 = (BodyStatement)CompoundStatement_306_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_307_Var
		);
		final EList<? extends EObject> BlockList_307_list = BodyStatement_307_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_307_list);
		Assert.assertEquals(1, BlockList_307_list.size());
		//307
		final BlockList BlockList_308_Var
		 = (BlockList)BlockList_307_list.get(0);
		Assert.assertNotNull(BlockList_308_Var
		);
		final EList<? extends EObject> Statement_308_list = BlockList_308_Var
		.getStatement();
		Assert.assertNotNull(Statement_308_list);
		Assert.assertEquals(2, Statement_308_list.size());
		//308
		final Statement Statement_309_Var
		 = (Statement)Statement_308_list.get(0);
		Assert.assertNotNull(Statement_309_Var
		);
		//309
		final ExpressionStatement ExpressionStatement_310_Var
		 = (ExpressionStatement)Statement_309_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_310_Var
		);
		//310
		final Expression Expression_311_Var
		 = (Expression)ExpressionStatement_310_Var
		.getExpression();
		Assert.assertNotNull(Expression_311_Var
		);
		final EList<? extends EObject> ExprExpr_311_list = Expression_311_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_311_list);
		Assert.assertEquals(1, ExprExpr_311_list.size());
		//311
		final AssignmentExpression AssignmentExpression_312_Var
		 = (AssignmentExpression)ExprExpr_311_list.get(0);
		Assert.assertNotNull(AssignmentExpression_312_Var
		);
		//312
		final UnaryExpression UnaryExpression_313_Var
		 = (UnaryExpression)AssignmentExpression_312_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_313_Var
		);
		//313
		final PostfixExpression PostfixExpression_314_Var
		 = (PostfixExpression)UnaryExpression_313_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_314_Var
		);
		final EList<? extends EObject> Expr_314_list = PostfixExpression_314_Var
		.getExpr();
		Assert.assertNotNull(Expr_314_list);
		Assert.assertEquals(1, Expr_314_list.size());
		//314
		final PrimaryExpression PrimaryExpression_315_Var
		 = (PrimaryExpression)Expr_314_list.get(0);
		Assert.assertNotNull(PrimaryExpression_315_Var
		);
		Assert.assertEquals("errno", PrimaryExpression_315_Var
		.getId());
		//315
		final AssignmentOperator AssignmentOperator_316_Var
		 = (AssignmentOperator)AssignmentExpression_312_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_316_Var
		);
		Assert.assertEquals("=", AssignmentOperator_316_Var
		.getOp());
		//316
		final AssignmentExpression AssignmentExpression_317_Var
		 = (AssignmentExpression)AssignmentExpression_312_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_317_Var
		);
		//317
		final ConditionalExpression ConditionalExpression_318_Var
		 = (ConditionalExpression)AssignmentExpression_317_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_318_Var
		);
		//318
		final LogicalOrExpression LogicalOrExpression_319_Var
		 = (LogicalOrExpression)ConditionalExpression_318_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_319_Var
		);
		final EList<? extends EObject> Expr_319_list = LogicalOrExpression_319_Var
		.getExpr();
		Assert.assertNotNull(Expr_319_list);
		Assert.assertEquals(1, Expr_319_list.size());
		//319
		final LogicalAndExpression LogicalAndExpression_320_Var
		 = (LogicalAndExpression)Expr_319_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_320_Var
		);
		final EList<? extends EObject> Expr_320_list = LogicalAndExpression_320_Var
		.getExpr();
		Assert.assertNotNull(Expr_320_list);
		Assert.assertEquals(1, Expr_320_list.size());
		//320
		final InclusiveOrExpression InclusiveOrExpression_321_Var
		 = (InclusiveOrExpression)Expr_320_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_321_Var
		);
		final EList<? extends EObject> Expr_321_list = InclusiveOrExpression_321_Var
		.getExpr();
		Assert.assertNotNull(Expr_321_list);
		Assert.assertEquals(1, Expr_321_list.size());
		//321
		final ExclusiveOrExpression ExclusiveOrExpression_322_Var
		 = (ExclusiveOrExpression)Expr_321_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_322_Var
		);
		final EList<? extends EObject> Expr_322_list = ExclusiveOrExpression_322_Var
		.getExpr();
		Assert.assertNotNull(Expr_322_list);
		Assert.assertEquals(1, Expr_322_list.size());
		//322
		final AndExpression AndExpression_323_Var
		 = (AndExpression)Expr_322_list.get(0);
		Assert.assertNotNull(AndExpression_323_Var
		);
		final EList<? extends EObject> Expr_323_list = AndExpression_323_Var
		.getExpr();
		Assert.assertNotNull(Expr_323_list);
		Assert.assertEquals(1, Expr_323_list.size());
		//323
		final EqualityExpression EqualityExpression_324_Var
		 = (EqualityExpression)Expr_323_list.get(0);
		Assert.assertNotNull(EqualityExpression_324_Var
		);
		final EList<? extends EObject> Expr_324_list = EqualityExpression_324_Var
		.getExpr();
		Assert.assertNotNull(Expr_324_list);
		Assert.assertEquals(1, Expr_324_list.size());
		//324
		final RelationalExpression RelationalExpression_325_Var
		 = (RelationalExpression)Expr_324_list.get(0);
		Assert.assertNotNull(RelationalExpression_325_Var
		);
		final EList<? extends EObject> Expr_325_list = RelationalExpression_325_Var
		.getExpr();
		Assert.assertNotNull(Expr_325_list);
		Assert.assertEquals(1, Expr_325_list.size());
		//325
		final ShiftExpression ShiftExpression_326_Var
		 = (ShiftExpression)Expr_325_list.get(0);
		Assert.assertNotNull(ShiftExpression_326_Var
		);
		final EList<? extends EObject> Expr_326_list = ShiftExpression_326_Var
		.getExpr();
		Assert.assertNotNull(Expr_326_list);
		Assert.assertEquals(1, Expr_326_list.size());
		//326
		final AdditiveExpression AdditiveExpression_327_Var
		 = (AdditiveExpression)Expr_326_list.get(0);
		Assert.assertNotNull(AdditiveExpression_327_Var
		);
		final EList<? extends EObject> Expr_327_list = AdditiveExpression_327_Var
		.getExpr();
		Assert.assertNotNull(Expr_327_list);
		Assert.assertEquals(1, Expr_327_list.size());
		//327
		final MultiplicativeExpression MultiplicativeExpression_328_Var
		 = (MultiplicativeExpression)Expr_327_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_328_Var
		);
		final EList<? extends EObject> Expr_328_list = MultiplicativeExpression_328_Var
		.getExpr();
		Assert.assertNotNull(Expr_328_list);
		Assert.assertEquals(1, Expr_328_list.size());
		//328
		final CastExpression CastExpression_329_Var
		 = (CastExpression)Expr_328_list.get(0);
		Assert.assertNotNull(CastExpression_329_Var
		);
		//329
		final UnaryExpression UnaryExpression_330_Var
		 = (UnaryExpression)CastExpression_329_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_330_Var
		);
		//330
		final UnaryOperator UnaryOperator_331_Var
		 = (UnaryOperator)UnaryExpression_330_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_331_Var
		);
		Assert.assertEquals("-", UnaryOperator_331_Var
		.getOp());
		//331
		final CastExpression CastExpression_332_Var
		 = (CastExpression)UnaryExpression_330_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_332_Var
		);
		//332
		final UnaryExpression UnaryExpression_333_Var
		 = (UnaryExpression)CastExpression_332_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_333_Var
		);
		//333
		final PostfixExpression PostfixExpression_334_Var
		 = (PostfixExpression)UnaryExpression_333_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_334_Var
		);
		final EList<? extends EObject> Expr_334_list = PostfixExpression_334_Var
		.getExpr();
		Assert.assertNotNull(Expr_334_list);
		Assert.assertEquals(1, Expr_334_list.size());
		//334
		final PrimaryExpression PrimaryExpression_335_Var
		 = (PrimaryExpression)Expr_334_list.get(0);
		Assert.assertNotNull(PrimaryExpression_335_Var
		);
		Assert.assertEquals("res", PrimaryExpression_335_Var
		.getId());
		//335
		final Statement Statement_336_Var
		 = (Statement)Statement_308_list.get(1);
		Assert.assertNotNull(Statement_336_Var
		);
		//336
		final ExpressionStatement ExpressionStatement_337_Var
		 = (ExpressionStatement)Statement_336_Var
		.getStmt();
		Assert.assertNotNull(ExpressionStatement_337_Var
		);
		//337
		final Expression Expression_338_Var
		 = (Expression)ExpressionStatement_337_Var
		.getExpression();
		Assert.assertNotNull(Expression_338_Var
		);
		final EList<? extends EObject> ExprExpr_338_list = Expression_338_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_338_list);
		Assert.assertEquals(1, ExprExpr_338_list.size());
		//338
		final AssignmentExpression AssignmentExpression_339_Var
		 = (AssignmentExpression)ExprExpr_338_list.get(0);
		Assert.assertNotNull(AssignmentExpression_339_Var
		);
		//339
		final UnaryExpression UnaryExpression_340_Var
		 = (UnaryExpression)AssignmentExpression_339_Var
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
		final AssignmentOperator AssignmentOperator_343_Var
		 = (AssignmentOperator)AssignmentExpression_339_Var
		.getOp();
		Assert.assertNotNull(AssignmentOperator_343_Var
		);
		Assert.assertEquals("=", AssignmentOperator_343_Var
		.getOp());
		//343
		final AssignmentExpression AssignmentExpression_344_Var
		 = (AssignmentExpression)AssignmentExpression_339_Var
		.getAssignmentExpr();
		Assert.assertNotNull(AssignmentExpression_344_Var
		);
		//344
		final ConditionalExpression ConditionalExpression_345_Var
		 = (ConditionalExpression)AssignmentExpression_344_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_345_Var
		);
		//345
		final LogicalOrExpression LogicalOrExpression_346_Var
		 = (LogicalOrExpression)ConditionalExpression_345_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_346_Var
		);
		final EList<? extends EObject> Expr_346_list = LogicalOrExpression_346_Var
		.getExpr();
		Assert.assertNotNull(Expr_346_list);
		Assert.assertEquals(1, Expr_346_list.size());
		//346
		final LogicalAndExpression LogicalAndExpression_347_Var
		 = (LogicalAndExpression)Expr_346_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_347_Var
		);
		final EList<? extends EObject> Expr_347_list = LogicalAndExpression_347_Var
		.getExpr();
		Assert.assertNotNull(Expr_347_list);
		Assert.assertEquals(1, Expr_347_list.size());
		//347
		final InclusiveOrExpression InclusiveOrExpression_348_Var
		 = (InclusiveOrExpression)Expr_347_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_348_Var
		);
		final EList<? extends EObject> Expr_348_list = InclusiveOrExpression_348_Var
		.getExpr();
		Assert.assertNotNull(Expr_348_list);
		Assert.assertEquals(1, Expr_348_list.size());
		//348
		final ExclusiveOrExpression ExclusiveOrExpression_349_Var
		 = (ExclusiveOrExpression)Expr_348_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_349_Var
		);
		final EList<? extends EObject> Expr_349_list = ExclusiveOrExpression_349_Var
		.getExpr();
		Assert.assertNotNull(Expr_349_list);
		Assert.assertEquals(1, Expr_349_list.size());
		//349
		final AndExpression AndExpression_350_Var
		 = (AndExpression)Expr_349_list.get(0);
		Assert.assertNotNull(AndExpression_350_Var
		);
		final EList<? extends EObject> Expr_350_list = AndExpression_350_Var
		.getExpr();
		Assert.assertNotNull(Expr_350_list);
		Assert.assertEquals(1, Expr_350_list.size());
		//350
		final EqualityExpression EqualityExpression_351_Var
		 = (EqualityExpression)Expr_350_list.get(0);
		Assert.assertNotNull(EqualityExpression_351_Var
		);
		final EList<? extends EObject> Expr_351_list = EqualityExpression_351_Var
		.getExpr();
		Assert.assertNotNull(Expr_351_list);
		Assert.assertEquals(1, Expr_351_list.size());
		//351
		final RelationalExpression RelationalExpression_352_Var
		 = (RelationalExpression)Expr_351_list.get(0);
		Assert.assertNotNull(RelationalExpression_352_Var
		);
		final EList<? extends EObject> Expr_352_list = RelationalExpression_352_Var
		.getExpr();
		Assert.assertNotNull(Expr_352_list);
		Assert.assertEquals(1, Expr_352_list.size());
		//352
		final ShiftExpression ShiftExpression_353_Var
		 = (ShiftExpression)Expr_352_list.get(0);
		Assert.assertNotNull(ShiftExpression_353_Var
		);
		final EList<? extends EObject> Expr_353_list = ShiftExpression_353_Var
		.getExpr();
		Assert.assertNotNull(Expr_353_list);
		Assert.assertEquals(1, Expr_353_list.size());
		//353
		final AdditiveExpression AdditiveExpression_354_Var
		 = (AdditiveExpression)Expr_353_list.get(0);
		Assert.assertNotNull(AdditiveExpression_354_Var
		);
		final EList<? extends EObject> Expr_354_list = AdditiveExpression_354_Var
		.getExpr();
		Assert.assertNotNull(Expr_354_list);
		Assert.assertEquals(1, Expr_354_list.size());
		//354
		final MultiplicativeExpression MultiplicativeExpression_355_Var
		 = (MultiplicativeExpression)Expr_354_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_355_Var
		);
		final EList<? extends EObject> Expr_355_list = MultiplicativeExpression_355_Var
		.getExpr();
		Assert.assertNotNull(Expr_355_list);
		Assert.assertEquals(1, Expr_355_list.size());
		//355
		final CastExpression CastExpression_356_Var
		 = (CastExpression)Expr_355_list.get(0);
		Assert.assertNotNull(CastExpression_356_Var
		);
		//356
		final UnaryExpression UnaryExpression_357_Var
		 = (UnaryExpression)CastExpression_356_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_357_Var
		);
		//357
		final UnaryOperator UnaryOperator_358_Var
		 = (UnaryOperator)UnaryExpression_357_Var
		.getOp();
		Assert.assertNotNull(UnaryOperator_358_Var
		);
		Assert.assertEquals("-", UnaryOperator_358_Var
		.getOp());
		//358
		final CastExpression CastExpression_359_Var
		 = (CastExpression)UnaryExpression_357_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_359_Var
		);
		//359
		final UnaryExpression UnaryExpression_360_Var
		 = (UnaryExpression)CastExpression_359_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_360_Var
		);
		//360
		final PostfixExpression PostfixExpression_361_Var
		 = (PostfixExpression)UnaryExpression_360_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_361_Var
		);
		final EList<? extends EObject> Expr_361_list = PostfixExpression_361_Var
		.getExpr();
		Assert.assertNotNull(Expr_361_list);
		Assert.assertEquals(1, Expr_361_list.size());
		//361
		final PrimaryExpression PrimaryExpression_362_Var
		 = (PrimaryExpression)Expr_361_list.get(0);
		Assert.assertNotNull(PrimaryExpression_362_Var
		);
		//362
		final Constant Constant_363_Var
		 = (Constant)PrimaryExpression_362_Var
		.getConst();
		Assert.assertNotNull(Constant_363_Var
		);
		Assert.assertEquals("1", Constant_363_Var
		.getDec());
		//363
		final Statement Statement_364_Var
		 = (Statement)Statement_46_list.get(2);
		Assert.assertNotNull(Statement_364_Var
		);
		//364
		final JumpStatement JumpStatement_365_Var
		 = (JumpStatement)Statement_364_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_365_Var
		);
		//365
		final Expression Expression_366_Var
		 = (Expression)JumpStatement_365_Var
		.getExpr();
		Assert.assertNotNull(Expression_366_Var
		);
		final EList<? extends EObject> ExprExpr_366_list = Expression_366_Var
		.getExprExpr();
		Assert.assertNotNull(ExprExpr_366_list);
		Assert.assertEquals(1, ExprExpr_366_list.size());
		//366
		final AssignmentExpression AssignmentExpression_367_Var
		 = (AssignmentExpression)ExprExpr_366_list.get(0);
		Assert.assertNotNull(AssignmentExpression_367_Var
		);
		//367
		final ConditionalExpression ConditionalExpression_368_Var
		 = (ConditionalExpression)AssignmentExpression_367_Var
		.getExpr();
		Assert.assertNotNull(ConditionalExpression_368_Var
		);
		//368
		final LogicalOrExpression LogicalOrExpression_369_Var
		 = (LogicalOrExpression)ConditionalExpression_368_Var
		.getExpr();
		Assert.assertNotNull(LogicalOrExpression_369_Var
		);
		final EList<? extends EObject> Expr_369_list = LogicalOrExpression_369_Var
		.getExpr();
		Assert.assertNotNull(Expr_369_list);
		Assert.assertEquals(1, Expr_369_list.size());
		//369
		final LogicalAndExpression LogicalAndExpression_370_Var
		 = (LogicalAndExpression)Expr_369_list.get(0);
		Assert.assertNotNull(LogicalAndExpression_370_Var
		);
		final EList<? extends EObject> Expr_370_list = LogicalAndExpression_370_Var
		.getExpr();
		Assert.assertNotNull(Expr_370_list);
		Assert.assertEquals(1, Expr_370_list.size());
		//370
		final InclusiveOrExpression InclusiveOrExpression_371_Var
		 = (InclusiveOrExpression)Expr_370_list.get(0);
		Assert.assertNotNull(InclusiveOrExpression_371_Var
		);
		final EList<? extends EObject> Expr_371_list = InclusiveOrExpression_371_Var
		.getExpr();
		Assert.assertNotNull(Expr_371_list);
		Assert.assertEquals(1, Expr_371_list.size());
		//371
		final ExclusiveOrExpression ExclusiveOrExpression_372_Var
		 = (ExclusiveOrExpression)Expr_371_list.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_372_Var
		);
		final EList<? extends EObject> Expr_372_list = ExclusiveOrExpression_372_Var
		.getExpr();
		Assert.assertNotNull(Expr_372_list);
		Assert.assertEquals(1, Expr_372_list.size());
		//372
		final AndExpression AndExpression_373_Var
		 = (AndExpression)Expr_372_list.get(0);
		Assert.assertNotNull(AndExpression_373_Var
		);
		final EList<? extends EObject> Expr_373_list = AndExpression_373_Var
		.getExpr();
		Assert.assertNotNull(Expr_373_list);
		Assert.assertEquals(1, Expr_373_list.size());
		//373
		final EqualityExpression EqualityExpression_374_Var
		 = (EqualityExpression)Expr_373_list.get(0);
		Assert.assertNotNull(EqualityExpression_374_Var
		);
		final EList<? extends EObject> Expr_374_list = EqualityExpression_374_Var
		.getExpr();
		Assert.assertNotNull(Expr_374_list);
		Assert.assertEquals(1, Expr_374_list.size());
		//374
		final RelationalExpression RelationalExpression_375_Var
		 = (RelationalExpression)Expr_374_list.get(0);
		Assert.assertNotNull(RelationalExpression_375_Var
		);
		final EList<? extends EObject> Expr_375_list = RelationalExpression_375_Var
		.getExpr();
		Assert.assertNotNull(Expr_375_list);
		Assert.assertEquals(1, Expr_375_list.size());
		//375
		final ShiftExpression ShiftExpression_376_Var
		 = (ShiftExpression)Expr_375_list.get(0);
		Assert.assertNotNull(ShiftExpression_376_Var
		);
		final EList<? extends EObject> Expr_376_list = ShiftExpression_376_Var
		.getExpr();
		Assert.assertNotNull(Expr_376_list);
		Assert.assertEquals(1, Expr_376_list.size());
		//376
		final AdditiveExpression AdditiveExpression_377_Var
		 = (AdditiveExpression)Expr_376_list.get(0);
		Assert.assertNotNull(AdditiveExpression_377_Var
		);
		final EList<? extends EObject> Expr_377_list = AdditiveExpression_377_Var
		.getExpr();
		Assert.assertNotNull(Expr_377_list);
		Assert.assertEquals(1, Expr_377_list.size());
		//377
		final MultiplicativeExpression MultiplicativeExpression_378_Var
		 = (MultiplicativeExpression)Expr_377_list.get(0);
		Assert.assertNotNull(MultiplicativeExpression_378_Var
		);
		final EList<? extends EObject> Expr_378_list = MultiplicativeExpression_378_Var
		.getExpr();
		Assert.assertNotNull(Expr_378_list);
		Assert.assertEquals(1, Expr_378_list.size());
		//378
		final CastExpression CastExpression_379_Var
		 = (CastExpression)Expr_378_list.get(0);
		Assert.assertNotNull(CastExpression_379_Var
		);
		//379
		final UnaryExpression UnaryExpression_380_Var
		 = (UnaryExpression)CastExpression_379_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_380_Var
		);
		//380
		final PostfixExpression PostfixExpression_381_Var
		 = (PostfixExpression)UnaryExpression_380_Var
		.getExpr();
		Assert.assertNotNull(PostfixExpression_381_Var
		);
		final EList<? extends EObject> Expr_381_list = PostfixExpression_381_Var
		.getExpr();
		Assert.assertNotNull(Expr_381_list);
		Assert.assertEquals(1, Expr_381_list.size());
		//381
		final PrimaryExpression PrimaryExpression_382_Var
		 = (PrimaryExpression)Expr_381_list.get(0);
		Assert.assertNotNull(PrimaryExpression_382_Var
		);
		Assert.assertEquals("res", PrimaryExpression_382_Var
		.getId());
		Assert.assertEquals("return", JumpStatement_365_Var
		.getReturn());
		Assert.assertEquals(";", JumpStatement_365_Var
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
	
}


