package at.jku.weiner.c.tests;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import at.jku.weiner.c.c.AdditiveExpression;
import at.jku.weiner.c.c.AndExpression;
import at.jku.weiner.c.c.AssignmentExpression;
import at.jku.weiner.c.c.CastExpression;
import at.jku.weiner.c.c.ConditionalExpression;
import at.jku.weiner.c.c.Declaration;
import at.jku.weiner.c.c.DeclarationSpecifiers;
import at.jku.weiner.c.c.Declarator;
import at.jku.weiner.c.c.DirectDeclarator;
import at.jku.weiner.c.c.EqualityExpression;
import at.jku.weiner.c.c.ExclusiveOrExpression;
import at.jku.weiner.c.c.ExternalDeclaration;
import at.jku.weiner.c.c.InclusiveOrExpression;
import at.jku.weiner.c.c.InitDeclarator;
import at.jku.weiner.c.c.InitDeclaratorList;
import at.jku.weiner.c.c.Initializer;
import at.jku.weiner.c.c.LogicalAndExpression;
import at.jku.weiner.c.c.LogicalOrExpression;
import at.jku.weiner.c.c.Model;
import at.jku.weiner.c.c.MultiplicativeExpression;
import at.jku.weiner.c.c.PostfixExpression;
import at.jku.weiner.c.c.PrimaryExpression;
import at.jku.weiner.c.c.RelationalExpression;
import at.jku.weiner.c.c.ShiftExpression;
import at.jku.weiner.c.c.TranslationUnit;
import at.jku.weiner.c.c.TypeSpecifier;
import at.jku.weiner.c.c.UnaryExpression;
import at.jku.weiner.c.parser.antlr.CParser;
import at.jku.weiner.c.parser.antlr.internal.InternalCLexer;
import at.jku.weiner.c.xtexttests.LexerAndParserTest;

import com.google.inject.Inject;
import com.google.inject.Provider;

@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(CInjectorProvider.class)
public class Test0041_MultipleLinesPreprocessorDirective {

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

	private LexerAndParserTest testHelper;

	/*** new ***/
	@Inject
	private IGenerator generator;
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	@Inject
	private IResourceValidator validator;
	@Inject
	private JavaIoFileSystemAccess fileAccessSystem;

	@Before
	public void initialize() {
		this.testHelper = new LexerAndParserTest(this.lexer, this.parser,
				this.tokenDefProvider);
	}

	private String getTextFromFile(final String fileName) throws Exception {
		final Path path = Paths.get(fileName);
		final String content = new String(Files.readAllBytes(path));
		return content;
	}

	@Test
	public void checkLexerTokens() throws Exception {
		final String text = this
				.getTextFromFile("res/Test0041_MultipleLinesPreprocessorDirective.c");
		// System.out.println(text);
		final String[] expected = new String[] { "RULE_LINEDIRECTIVE",
				"RULE_NEWLINE", "RULE_NEWLINE", "RULE_KW_INT",
				"RULE_WHITESPACE", "RULE_ID", "RULE_WHITESPACE", "RULE_ASSIGN",
				"RULE_WHITESPACE", "RULE_ID", "RULE_SEMI", "RULE_NEWLINE", };
		// final List<Token> actual = testHelper.getTokens(text);
		// testHelper.outputTokens(text);
		this.testHelper.checkTokenisation(text, expected);
	}

	@Test
	public void checkParserResult() throws Exception {

		final String text = this
				.getTextFromFile("res/Test0041_MultipleLinesPreprocessorDirective.c");
		final Model Model_0_Var = this.parseHelper.parse(text);

		this.valHelper.assertNoErrors(Model_0_Var);
		Assert.assertNotNull(Model_0_Var);
		final EList<? extends EObject> Unit_0_list = Model_0_Var.getUnit();
		Assert.assertNotNull(Unit_0_list);
		Assert.assertEquals(1, Unit_0_list.size());
		final TranslationUnit TranslationUnit_1_Var = (TranslationUnit) Unit_0_list
				.get(0);
		Assert.assertNotNull(TranslationUnit_1_Var);
		final EList<? extends EObject> External_1_list = TranslationUnit_1_Var
				.getExternal();
		Assert.assertNotNull(External_1_list);
		Assert.assertEquals(1, External_1_list.size());
		final ExternalDeclaration ExternalDeclaration_2_Var = (ExternalDeclaration) External_1_list
				.get(0);
		Assert.assertNotNull(ExternalDeclaration_2_Var);
		final Declaration Declaration_3_Var = (Declaration) ExternalDeclaration_2_Var
				.getDeclaration();
		Assert.assertNotNull(Declaration_3_Var);
		final DeclarationSpecifiers DeclarationSpecifiers_4_Var = (DeclarationSpecifiers) Declaration_3_Var
				.getSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_4_Var);
		final EList<? extends EObject> DeclarationSpecifier_4_list = DeclarationSpecifiers_4_Var
				.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_4_list);
		Assert.assertEquals(1, DeclarationSpecifier_4_list.size());
		final TypeSpecifier TypeSpecifier_5_Var = (TypeSpecifier) DeclarationSpecifier_4_list
				.get(0);
		Assert.assertNotNull(TypeSpecifier_5_Var);
		Assert.assertEquals("int", TypeSpecifier_5_Var.getName());
		final EList<? extends EObject> InitDeclaratorList_5_list = Declaration_3_Var
				.getInitDeclaratorList();
		Assert.assertNotNull(InitDeclaratorList_5_list);
		Assert.assertEquals(1, InitDeclaratorList_5_list.size());
		final InitDeclaratorList InitDeclaratorList_6_Var = (InitDeclaratorList) InitDeclaratorList_5_list
				.get(0);
		Assert.assertNotNull(InitDeclaratorList_6_Var);
		final EList<? extends EObject> InitDeclarator_6_list = InitDeclaratorList_6_Var
				.getInitDeclarator();
		Assert.assertNotNull(InitDeclarator_6_list);
		Assert.assertEquals(1, InitDeclarator_6_list.size());
		final InitDeclarator InitDeclarator_7_Var = (InitDeclarator) InitDeclarator_6_list
				.get(0);
		Assert.assertNotNull(InitDeclarator_7_Var);
		final Declarator Declarator_8_Var = (Declarator) InitDeclarator_7_Var
				.getDeclarator();
		Assert.assertNotNull(Declarator_8_Var);
		final DirectDeclarator DirectDeclarator_9_Var = (DirectDeclarator) Declarator_8_Var
				.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_9_Var);
		Assert.assertEquals("i", DirectDeclarator_9_Var.getId());
		final Initializer Initializer_10_Var = (Initializer) InitDeclarator_7_Var
				.getInitializer();
		Assert.assertNotNull(Initializer_10_Var);
		final AssignmentExpression AssignmentExpression_11_Var = (AssignmentExpression) Initializer_10_Var
				.getExpr();
		Assert.assertNotNull(AssignmentExpression_11_Var);
		final ConditionalExpression ConditionalExpression_12_Var = (ConditionalExpression) AssignmentExpression_11_Var
				.getExpr();
		Assert.assertNotNull(ConditionalExpression_12_Var);
		final LogicalOrExpression LogicalOrExpression_13_Var = (LogicalOrExpression) ConditionalExpression_12_Var
				.getExpr();
		Assert.assertNotNull(LogicalOrExpression_13_Var);
		final EList<? extends EObject> Expr_13_list = LogicalOrExpression_13_Var
				.getExpr();
		Assert.assertNotNull(Expr_13_list);
		Assert.assertEquals(1, Expr_13_list.size());
		final LogicalAndExpression LogicalAndExpression_14_Var = (LogicalAndExpression) Expr_13_list
				.get(0);
		Assert.assertNotNull(LogicalAndExpression_14_Var);
		final EList<? extends EObject> Expr_14_list = LogicalAndExpression_14_Var
				.getExpr();
		Assert.assertNotNull(Expr_14_list);
		Assert.assertEquals(1, Expr_14_list.size());
		final InclusiveOrExpression InclusiveOrExpression_15_Var = (InclusiveOrExpression) Expr_14_list
				.get(0);
		Assert.assertNotNull(InclusiveOrExpression_15_Var);
		final EList<? extends EObject> Expr_15_list = InclusiveOrExpression_15_Var
				.getExpr();
		Assert.assertNotNull(Expr_15_list);
		Assert.assertEquals(1, Expr_15_list.size());
		final ExclusiveOrExpression ExclusiveOrExpression_16_Var = (ExclusiveOrExpression) Expr_15_list
				.get(0);
		Assert.assertNotNull(ExclusiveOrExpression_16_Var);
		final EList<? extends EObject> Expr_16_list = ExclusiveOrExpression_16_Var
				.getExpr();
		Assert.assertNotNull(Expr_16_list);
		Assert.assertEquals(1, Expr_16_list.size());
		final AndExpression AndExpression_17_Var = (AndExpression) Expr_16_list
				.get(0);
		Assert.assertNotNull(AndExpression_17_Var);
		final EList<? extends EObject> Expr_17_list = AndExpression_17_Var
				.getExpr();
		Assert.assertNotNull(Expr_17_list);
		Assert.assertEquals(1, Expr_17_list.size());
		final EqualityExpression EqualityExpression_18_Var = (EqualityExpression) Expr_17_list
				.get(0);
		Assert.assertNotNull(EqualityExpression_18_Var);
		final EList<? extends EObject> Expr_18_list = EqualityExpression_18_Var
				.getExpr();
		Assert.assertNotNull(Expr_18_list);
		Assert.assertEquals(1, Expr_18_list.size());
		final RelationalExpression RelationalExpression_19_Var = (RelationalExpression) Expr_18_list
				.get(0);
		Assert.assertNotNull(RelationalExpression_19_Var);
		final EList<? extends EObject> Expr_19_list = RelationalExpression_19_Var
				.getExpr();
		Assert.assertNotNull(Expr_19_list);
		Assert.assertEquals(1, Expr_19_list.size());
		final ShiftExpression ShiftExpression_20_Var = (ShiftExpression) Expr_19_list
				.get(0);
		Assert.assertNotNull(ShiftExpression_20_Var);
		final EList<? extends EObject> Expr_20_list = ShiftExpression_20_Var
				.getExpr();
		Assert.assertNotNull(Expr_20_list);
		Assert.assertEquals(1, Expr_20_list.size());
		final AdditiveExpression AdditiveExpression_21_Var = (AdditiveExpression) Expr_20_list
				.get(0);
		Assert.assertNotNull(AdditiveExpression_21_Var);
		final EList<? extends EObject> Expr_21_list = AdditiveExpression_21_Var
				.getExpr();
		Assert.assertNotNull(Expr_21_list);
		Assert.assertEquals(1, Expr_21_list.size());
		final MultiplicativeExpression MultiplicativeExpression_22_Var = (MultiplicativeExpression) Expr_21_list
				.get(0);
		Assert.assertNotNull(MultiplicativeExpression_22_Var);
		final EList<? extends EObject> Expr_22_list = MultiplicativeExpression_22_Var
				.getExpr();
		Assert.assertNotNull(Expr_22_list);
		Assert.assertEquals(1, Expr_22_list.size());
		final CastExpression CastExpression_23_Var = (CastExpression) Expr_22_list
				.get(0);
		Assert.assertNotNull(CastExpression_23_Var);
		final UnaryExpression UnaryExpression_24_Var = (UnaryExpression) CastExpression_23_Var
				.getExpr();
		Assert.assertNotNull(UnaryExpression_24_Var);
		final PostfixExpression PostfixExpression_25_Var = (PostfixExpression) UnaryExpression_24_Var
				.getExpr();
		Assert.assertNotNull(PostfixExpression_25_Var);
		final EList<? extends EObject> Expr_25_list = PostfixExpression_25_Var
				.getExpr();
		Assert.assertNotNull(Expr_25_list);
		Assert.assertEquals(1, Expr_25_list.size());
		final PrimaryExpression PrimaryExpression_26_Var = (PrimaryExpression) Expr_25_list
				.get(0);
		Assert.assertNotNull(PrimaryExpression_26_Var);
		Assert.assertEquals("MYDEF", PrimaryExpression_26_Var.getId());
		Assert.assertEquals(";", Declaration_3_Var.getSemi());
	}

	@Test
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		Resource resource = set
				.getResource(
						URI.createURI("res/Test0041_MultipleLinesPreprocessorDirective.c"),
						true);
		// validate the resource
		List<Issue> list = this.validator.validate(resource, CheckMode.ALL,
				CancelIndicator.NullImpl);
		Assert.assertTrue(list.isEmpty());

		// configure and start the generator
		this.fileAccessSystem.setOutputPath("bin");
		this.generator.doGenerate(resource, this.fileAccessSystem);

		final String actual = this.getTextFromFile("bin/greetings.txt");
		final String expected = this.getTextFromFile("out/exp.txt");
		Assert.assertEquals(expected, actual);
		// System.out.println("Code generation finished.");
	}
}
