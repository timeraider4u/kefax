package at.jku.weiner.c.common.xtexttests;

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
import at.jku.weiner.c.common.tests.CommonInjectorProvider;
import at.jku.weiner.c.common.parser.antlr.CommonParser;
import at.jku.weiner.c.common.parser.antlr.internal.InternalCommonLexer;
import at.jku.weiner.c.common.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.common.common.PrimaryExpression;
import at.jku.weiner.c.common.common.AdditiveExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
import at.jku.weiner.c.common.common.PrimaryExpression;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CommonInjectorProvider.class)
public class Test0003_Parentheses {
	@Inject
	private ParseHelper<PrimaryExpression> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalCommonLexer lexer;
	@Inject
	private CommonParser parser;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("txt",
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
			"res/Test0003_Parentheses.txt");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_SKW_LEFTPAREN",
				"RULE_DECIMAL_LITERAL",
				"RULE_WHITESPACE",
				"RULE_SKW_PLUS",
				"RULE_WHITESPACE",
				"RULE_DECIMAL_LITERAL",
				"RULE_SKW_RIGHTPAREN",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0003_Parentheses.txt");
		final PrimaryExpression PrimaryExpression_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(PrimaryExpression_0_Var
		);
		
		Assert.assertNotNull(PrimaryExpression_0_Var
		);
		Assert.assertTrue(PrimaryExpression_0_Var
		.isParentheses());
		//0
		final AdditiveExpression AdditiveExpression_1_Var
		 = (AdditiveExpression)PrimaryExpression_0_Var
		.getExpr();
		Assert.assertNotNull(AdditiveExpression_1_Var
		);
		Assert.assertEquals("+", AdditiveExpression_1_Var
		.getOp());
		//1
		final PrimaryExpression PrimaryExpression_2_Var
		 = (PrimaryExpression)AdditiveExpression_1_Var
		.getLeft();
		Assert.assertNotNull(PrimaryExpression_2_Var
		);
		Assert.assertEquals("1", PrimaryExpression_2_Var
		.getConst());
		//2
		final PrimaryExpression PrimaryExpression_3_Var
		 = (PrimaryExpression)AdditiveExpression_1_Var
		.getRight();
		Assert.assertNotNull(PrimaryExpression_3_Var
		);
		Assert.assertEquals("2", PrimaryExpression_3_Var
		.getConst());
	}
	
	
}


