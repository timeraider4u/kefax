package at.jku.weiner.c.parser.xtexttests;

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
import at.jku.weiner.c.parser.tests.ParserInjectorProvider;
import at.jku.weiner.c.parser.parser.antlr.ParserParser;
import at.jku.weiner.c.parser.parser.antlr.internal.InternalParserLexer;
import at.jku.weiner.c.parser.xtexttests.LexerAndParserTest;

import at.jku.weiner.c.parser.parser.Parser;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.ExternalDeclaration;
import at.jku.weiner.c.parser.parser.FunctionDefHead;
import at.jku.weiner.c.parser.parser.FunctionDeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
import at.jku.weiner.c.parser.parser.BlockList;
import at.jku.weiner.c.parser.parser.Statement;
import at.jku.weiner.c.parser.parser.JumpStatement;
import at.jku.weiner.c.parser.parser.CastExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.UnaryExpression;
import at.jku.weiner.c.parser.parser.TypeName;
import at.jku.weiner.c.parser.parser.SpecifierQualifierList;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0032_Sizeof {
	@Inject
	private ParseHelper<Parser> parseHelper;
	@Inject
	private ValidationTestHelper valHelper;
	@Inject
	private InternalParserLexer lexer;
	@Inject
	private ParserParser parser;
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
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("c",
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
			"res/Test0032_SizeOf.c");
			//System.out.println(text);
			final String[] expected = new String[] {
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				"RULE_NEWLINE",
				"RULE_KW_LONG",
				"RULE_WHITESPACE",
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
				"RULE_WHITESPACE",
				"RULE_KW_RETURN",
				"RULE_WHITESPACE",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_UNSIGNED",
				"RULE_WHITESPACE",
				"RULE_KW_LONG",
				"RULE_SKW_RIGHTPAREN",
				"RULE_KW_SIZEOF",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_SEMI",
				"RULE_NEWLINE",
				"RULE_SKW_RIGHTBRACE",
				"RULE_NEWLINE",
				};
			//final List<Token> actual = testHelper.getTokens(text);
			//testHelper.outputTokens(text);
			testHelper.checkTokenisation(text, expected);
	}
	
	@Test (timeout=1000)
	public void checkParserResult() throws Exception {
		final String text = this.getTextFromFile(
			"res/Test0032_SizeOf.c");
		final Parser Parser_0_Var
		  = 
			this.parseHelper.parse(text);
		this.valHelper.assertNoErrors(Parser_0_Var
		);
		
		Assert.assertNotNull(Parser_0_Var
		);
		final EList<? extends EObject> External_0_list = Parser_0_Var
		.getExternal();
		Assert.assertNotNull(External_0_list);
		Assert.assertEquals(2, External_0_list.size());
		//0
		final ExternalDeclaration ExternalDeclaration_1_Var
		 = (ExternalDeclaration)External_0_list.get(0);
		Assert.assertNotNull(ExternalDeclaration_1_Var
		);
		//1
		final FunctionDefHead FunctionDefHead_2_Var
		 = (FunctionDefHead)ExternalDeclaration_1_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_2_Var
		);
		//2
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_3_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_2_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_3_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_3_list = FunctionDeclarationSpecifiers_3_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_3_list);
		Assert.assertEquals(1, DeclarationSpecifier_3_list.size());
		//3
		final TypeSpecifier TypeSpecifier_4_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(TypeSpecifier_4_Var
		);
		Assert.assertEquals("int", TypeSpecifier_4_Var
		.getName());
		//4
		final Declarator Declarator_5_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_5_Var
		);
		//5
		final DirectDeclarator DirectDeclarator_6_Var
		 = (DirectDeclarator)Declarator_5_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_6_Var
		);
		Assert.assertEquals("sizeOfInt", DirectDeclarator_6_Var
		.getId());
		//6
		final FunctionDefinition FunctionDefinition_7_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_7_Var
		);
		//7
		final BodyStatement BodyStatement_8_Var
		 = (BodyStatement)FunctionDefinition_7_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_8_Var
		);
		final EList<? extends EObject> BlockList_8_list = BodyStatement_8_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_8_list);
		Assert.assertEquals(1, BlockList_8_list.size());
		//8
		final BlockList BlockList_9_Var
		 = (BlockList)BlockList_8_list.get(0);
		Assert.assertNotNull(BlockList_9_Var
		);
		final EList<? extends EObject> Statement_9_list = BlockList_9_Var
		.getStatement();
		Assert.assertNotNull(Statement_9_list);
		Assert.assertEquals(1, Statement_9_list.size());
		//9
		final Statement Statement_10_Var
		 = (Statement)Statement_9_list.get(0);
		Assert.assertNotNull(Statement_10_Var
		);
		//10
		final JumpStatement JumpStatement_11_Var
		 = (JumpStatement)Statement_10_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_11_Var
		);
		//11
		final UnaryExpression UnaryExpression_12_Var
		 = (UnaryExpression)JumpStatement_11_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_12_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_12_Var
		.getSizeOf());
		//12
		final TypeName TypeName_13_Var
		 = (TypeName)UnaryExpression_12_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_13_Var
		);
		//13
		final SpecifierQualifierList SpecifierQualifierList_14_Var
		 = (SpecifierQualifierList)TypeName_13_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_14_Var
		);
		final EList<? extends EObject> TypeSpecifier_14_list = SpecifierQualifierList_14_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_14_list);
		Assert.assertEquals(1, TypeSpecifier_14_list.size());
		//14
		final TypeSpecifier TypeSpecifier_15_Var
		 = (TypeSpecifier)TypeSpecifier_14_list.get(0);
		Assert.assertNotNull(TypeSpecifier_15_Var
		);
		Assert.assertEquals("int", TypeSpecifier_15_Var
		.getName());
		Assert.assertEquals("return", JumpStatement_11_Var
		.getReturn());
		//15
		final ExternalDeclaration ExternalDeclaration_16_Var
		 = (ExternalDeclaration)External_0_list.get(1);
		Assert.assertNotNull(ExternalDeclaration_16_Var
		);
		//16
		final FunctionDefHead FunctionDefHead_17_Var
		 = (FunctionDefHead)ExternalDeclaration_16_Var
		.getFunctiondefHead();
		Assert.assertNotNull(FunctionDefHead_17_Var
		);
		//17
		final FunctionDeclarationSpecifiers FunctionDeclarationSpecifiers_18_Var
		 = (FunctionDeclarationSpecifiers)FunctionDefHead_17_Var
		.getFunDeclSpecifiers();
		Assert.assertNotNull(FunctionDeclarationSpecifiers_18_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_18_list = FunctionDeclarationSpecifiers_18_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_18_list);
		Assert.assertEquals(2, DeclarationSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)DeclarationSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("long", TypeSpecifier_19_Var
		.getName());
		//19
		final TypeSpecifier TypeSpecifier_20_Var
		 = (TypeSpecifier)DeclarationSpecifier_18_list.get(1);
		Assert.assertNotNull(TypeSpecifier_20_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_20_Var
		.getName());
		//20
		final Declarator Declarator_21_Var
		 = (Declarator)FunctionDefHead_17_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_21_Var
		);
		//21
		final DirectDeclarator DirectDeclarator_22_Var
		 = (DirectDeclarator)Declarator_21_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_22_Var
		);
		Assert.assertEquals("sizeOfInt2", DirectDeclarator_22_Var
		.getId());
		//22
		final FunctionDefinition FunctionDefinition_23_Var
		 = (FunctionDefinition)ExternalDeclaration_16_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_23_Var
		);
		//23
		final BodyStatement BodyStatement_24_Var
		 = (BodyStatement)FunctionDefinition_23_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_24_Var
		);
		final EList<? extends EObject> BlockList_24_list = BodyStatement_24_Var
		.getBlockList();
		Assert.assertNotNull(BlockList_24_list);
		Assert.assertEquals(1, BlockList_24_list.size());
		//24
		final BlockList BlockList_25_Var
		 = (BlockList)BlockList_24_list.get(0);
		Assert.assertNotNull(BlockList_25_Var
		);
		final EList<? extends EObject> Statement_25_list = BlockList_25_Var
		.getStatement();
		Assert.assertNotNull(Statement_25_list);
		Assert.assertEquals(1, Statement_25_list.size());
		//25
		final Statement Statement_26_Var
		 = (Statement)Statement_25_list.get(0);
		Assert.assertNotNull(Statement_26_Var
		);
		//26
		final JumpStatement JumpStatement_27_Var
		 = (JumpStatement)Statement_26_Var
		.getStmt();
		Assert.assertNotNull(JumpStatement_27_Var
		);
		//27
		final CastExpression CastExpression_28_Var
		 = (CastExpression)JumpStatement_27_Var
		.getExpr();
		Assert.assertNotNull(CastExpression_28_Var
		);
		//28
		final TypeName TypeName_29_Var
		 = (TypeName)CastExpression_28_Var
		.getType();
		Assert.assertNotNull(TypeName_29_Var
		);
		//29
		final SpecifierQualifierList SpecifierQualifierList_30_Var
		 = (SpecifierQualifierList)TypeName_29_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_30_Var
		);
		final EList<? extends EObject> TypeSpecifier_30_list = SpecifierQualifierList_30_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_30_list);
		Assert.assertEquals(2, TypeSpecifier_30_list.size());
		//30
		final TypeSpecifier TypeSpecifier_31_Var
		 = (TypeSpecifier)TypeSpecifier_30_list.get(0);
		Assert.assertNotNull(TypeSpecifier_31_Var
		);
		Assert.assertEquals("unsigned", TypeSpecifier_31_Var
		.getName());
		//31
		final TypeSpecifier TypeSpecifier_32_Var
		 = (TypeSpecifier)TypeSpecifier_30_list.get(1);
		Assert.assertNotNull(TypeSpecifier_32_Var
		);
		Assert.assertEquals("long", TypeSpecifier_32_Var
		.getName());
		//32
		final UnaryExpression UnaryExpression_33_Var
		 = (UnaryExpression)CastExpression_28_Var
		.getExpr();
		Assert.assertNotNull(UnaryExpression_33_Var
		);
		Assert.assertEquals("sizeof", UnaryExpression_33_Var
		.getSizeOf());
		//33
		final TypeName TypeName_34_Var
		 = (TypeName)UnaryExpression_33_Var
		.getTypeName();
		Assert.assertNotNull(TypeName_34_Var
		);
		//34
		final SpecifierQualifierList SpecifierQualifierList_35_Var
		 = (SpecifierQualifierList)TypeName_34_Var
		.getList();
		Assert.assertNotNull(SpecifierQualifierList_35_Var
		);
		final EList<? extends EObject> TypeSpecifier_35_list = SpecifierQualifierList_35_Var
		.getTypeSpecifier();
		Assert.assertNotNull(TypeSpecifier_35_list);
		Assert.assertEquals(1, TypeSpecifier_35_list.size());
		//35
		final TypeSpecifier TypeSpecifier_36_Var
		 = (TypeSpecifier)TypeSpecifier_35_list.get(0);
		Assert.assertNotNull(TypeSpecifier_36_Var
		);
		Assert.assertEquals("int", TypeSpecifier_36_Var
		.getName());
		Assert.assertEquals("return", JumpStatement_27_Var
		.getReturn());
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0032_SizeOf.c");
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
				method.invoke(this.generator, "Test0032_Sizeof.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
			// System.out.println("do nothing!");
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0032_Sizeof.c");
		final String expected = this.getTextFromFile(
			"res/Test0032_SizeOf.c"
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


