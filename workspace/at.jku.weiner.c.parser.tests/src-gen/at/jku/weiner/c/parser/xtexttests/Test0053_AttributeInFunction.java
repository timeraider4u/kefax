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
import at.jku.weiner.c.parser.parser.StorageClassSpecifier;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.FunctionSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeSpecifier;
import at.jku.weiner.c.parser.parser.GccAttributeList;
import at.jku.weiner.c.parser.parser.GccAttribute;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.DeclaratorSuffix;
import at.jku.weiner.c.parser.parser.DirectDeclaratorLastSuffix;
import at.jku.weiner.c.parser.parser.ParameterTypeList;
import at.jku.weiner.c.parser.parser.ParameterList;
import at.jku.weiner.c.parser.parser.ParameterDeclaration;
import at.jku.weiner.c.parser.parser.DeclarationSpecifiers;
import at.jku.weiner.c.parser.parser.TypeSpecifier;
import at.jku.weiner.c.parser.parser.Declarator;
import at.jku.weiner.c.parser.parser.DirectDeclarator;
import at.jku.weiner.c.parser.parser.FunctionDefinition;
import at.jku.weiner.c.parser.parser.BodyStatement;
@SuppressWarnings("unused")
@RunWith(XtextRunner.class)
@InjectWith(ParserInjectorProvider.class)
public class Test0053_AttributeInFunction {
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
			"res/Test0053_AttributeInFunction.c");
			final String[] expected = new String[] {
				"RULE_KW_STATIC",
				"RULE_WHITESPACE",
				"RULE_KW_INLINE1",
				"RULE_WHITESPACE",
				"RULE_KW_ATTRIBUTE3",
				"RULE_SKW_LEFTPAREN",
				"RULE_SKW_LEFTPAREN",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_SKW_RIGHTPAREN",
				"RULE_WHITESPACE",
				"RULE_KW_VOID",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_LEFTPAREN",
				"RULE_KW_INT",
				"RULE_WHITESPACE",
				"RULE_ID",
				"RULE_SKW_RIGHTPAREN",
				"RULE_NEWLINE",
				"RULE_SKW_LEFTBRACE",
				"RULE_NEWLINE",
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
			"res/Test0053_AttributeInFunction.c");
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
		Assert.assertEquals(1, External_0_list.size());
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
		Assert.assertEquals(4, DeclarationSpecifier_3_list.size());
		//3
		final StorageClassSpecifier StorageClassSpecifier_4_Var
		 = (StorageClassSpecifier)DeclarationSpecifier_3_list.get(0);
		Assert.assertNotNull(StorageClassSpecifier_4_Var
		);
		Assert.assertEquals("static", StorageClassSpecifier_4_Var
		.getName());
		//4
		final FunctionSpecifier FunctionSpecifier_5_Var
		 = (FunctionSpecifier)DeclarationSpecifier_3_list.get(1);
		Assert.assertNotNull(FunctionSpecifier_5_Var
		);
		Assert.assertEquals("inline", FunctionSpecifier_5_Var
		.getName());
		//5
		final FunctionSpecifier FunctionSpecifier_6_Var
		 = (FunctionSpecifier)DeclarationSpecifier_3_list.get(2);
		Assert.assertNotNull(FunctionSpecifier_6_Var
		);
		//6
		final GccAttributeSpecifier GccAttributeSpecifier_7_Var
		 = (GccAttributeSpecifier)FunctionSpecifier_6_Var
		.getGccAttributeSpecifier();
		Assert.assertNotNull(GccAttributeSpecifier_7_Var
		);
		//7
		final GccAttributeList GccAttributeList_8_Var
		 = (GccAttributeList)GccAttributeSpecifier_7_Var
		.getList();
		Assert.assertNotNull(GccAttributeList_8_Var
		);
		final EList<? extends EObject> GccAttribute_8_list = GccAttributeList_8_Var
		.getGccAttribute();
		Assert.assertNotNull(GccAttribute_8_list);
		Assert.assertEquals(1, GccAttribute_8_list.size());
		//8
		final GccAttribute GccAttribute_9_Var
		 = (GccAttribute)GccAttribute_8_list.get(0);
		Assert.assertNotNull(GccAttribute_9_Var
		);
		Assert.assertEquals("no_instrument_function", GccAttribute_9_Var
		.getId());
		//9
		final TypeSpecifier TypeSpecifier_10_Var
		 = (TypeSpecifier)DeclarationSpecifier_3_list.get(3);
		Assert.assertNotNull(TypeSpecifier_10_Var
		);
		Assert.assertEquals("void", TypeSpecifier_10_Var
		.getName());
		//10
		final Declarator Declarator_11_Var
		 = (Declarator)FunctionDefHead_2_Var
		.getFunDeclarator();
		Assert.assertNotNull(Declarator_11_Var
		);
		//11
		final DirectDeclarator DirectDeclarator_12_Var
		 = (DirectDeclarator)Declarator_11_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_12_Var
		);
		Assert.assertEquals("foo", DirectDeclarator_12_Var
		.getId());
		final EList<? extends EObject> DeclaratorSuffix_12_list = DirectDeclarator_12_Var
		.getDeclaratorSuffix();
		Assert.assertNotNull(DeclaratorSuffix_12_list);
		Assert.assertEquals(1, DeclaratorSuffix_12_list.size());
		//12
		final DeclaratorSuffix DeclaratorSuffix_13_Var
		 = (DeclaratorSuffix)DeclaratorSuffix_12_list.get(0);
		Assert.assertNotNull(DeclaratorSuffix_13_Var
		);
		//13
		final DirectDeclaratorLastSuffix DirectDeclaratorLastSuffix_14_Var
		 = (DirectDeclaratorLastSuffix)DeclaratorSuffix_13_Var
		.getLastSuffix();
		Assert.assertNotNull(DirectDeclaratorLastSuffix_14_Var
		);
		final EList<? extends EObject> ParameterTypeList_14_list = DirectDeclaratorLastSuffix_14_Var
		.getParameterTypeList();
		Assert.assertNotNull(ParameterTypeList_14_list);
		Assert.assertEquals(1, ParameterTypeList_14_list.size());
		//14
		final ParameterTypeList ParameterTypeList_15_Var
		 = (ParameterTypeList)ParameterTypeList_14_list.get(0);
		Assert.assertNotNull(ParameterTypeList_15_Var
		);
		//15
		final ParameterList ParameterList_16_Var
		 = (ParameterList)ParameterTypeList_15_Var
		.getList();
		Assert.assertNotNull(ParameterList_16_Var
		);
		final EList<? extends EObject> ParameterDeclaration_16_list = ParameterList_16_Var
		.getParameterDeclaration();
		Assert.assertNotNull(ParameterDeclaration_16_list);
		Assert.assertEquals(1, ParameterDeclaration_16_list.size());
		//16
		final ParameterDeclaration ParameterDeclaration_17_Var
		 = (ParameterDeclaration)ParameterDeclaration_16_list.get(0);
		Assert.assertNotNull(ParameterDeclaration_17_Var
		);
		//17
		final DeclarationSpecifiers DeclarationSpecifiers_18_Var
		 = (DeclarationSpecifiers)ParameterDeclaration_17_Var
		.getDeclSpecifiers();
		Assert.assertNotNull(DeclarationSpecifiers_18_Var
		);
		final EList<? extends EObject> DeclarationSpecifier_18_list = DeclarationSpecifiers_18_Var
		.getDeclarationSpecifier();
		Assert.assertNotNull(DeclarationSpecifier_18_list);
		Assert.assertEquals(1, DeclarationSpecifier_18_list.size());
		//18
		final TypeSpecifier TypeSpecifier_19_Var
		 = (TypeSpecifier)DeclarationSpecifier_18_list.get(0);
		Assert.assertNotNull(TypeSpecifier_19_Var
		);
		Assert.assertEquals("int", TypeSpecifier_19_Var
		.getName());
		//19
		final Declarator Declarator_20_Var
		 = (Declarator)ParameterDeclaration_17_Var
		.getDeclarator();
		Assert.assertNotNull(Declarator_20_Var
		);
		//20
		final DirectDeclarator DirectDeclarator_21_Var
		 = (DirectDeclarator)Declarator_20_Var
		.getDeclarator();
		Assert.assertNotNull(DirectDeclarator_21_Var
		);
		Assert.assertEquals("bar", DirectDeclarator_21_Var
		.getId());
		//21
		final FunctionDefinition FunctionDefinition_22_Var
		 = (FunctionDefinition)ExternalDeclaration_1_Var
		.getFunctionDefinition();
		Assert.assertNotNull(FunctionDefinition_22_Var
		);
		//22
		final BodyStatement BodyStatement_23_Var
		 = (BodyStatement)FunctionDefinition_22_Var
		.getBody();
		Assert.assertNotNull(BodyStatement_23_Var
		);
	}
	
	@Test
	(timeout=1000
	)
	public void testGenerator() throws Exception {
		// load the resource
		ResourceSet set = this.resourceSetProvider.get();
		URI uri = URI.createURI(
			"res/Test0053_AttributeInFunction.c");
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
				method.invoke(this.generator, "Test0053_AttributeInFunction.c");
			}
		} catch (NoSuchMethodException | SecurityException
			| IllegalAccessException | IllegalArgumentException
			| InvocationTargetException e) {
			// do nothing
		}
		this.generator.doGenerate(resource, this.fileAccessSystem);
		final String actual = this.getTextFromFile("bin/Test0053_AttributeInFunction.c");
		final String expected = this.getTextFromFile(
			"res/Test0053_AttributeInFunction.c"
			);
		Assert.assertEquals(preprocess(expected), preprocess(actual));
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


