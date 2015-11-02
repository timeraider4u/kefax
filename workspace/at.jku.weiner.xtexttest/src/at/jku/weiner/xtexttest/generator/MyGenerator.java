package at.jku.weiner.xtexttest.generator;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Generator;
import at.jku.weiner.xtexttest.xtextTest.Inner;
import at.jku.weiner.xtexttest.xtextTest.Input;
import at.jku.weiner.xtexttest.xtextTest.Tokens;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;

public class MyGenerator {
	private static final String PKG_PREFIX = "xtexttests";

	private final URI uri;
	private final StringBuilder builder;
	private final XtextTest xtext;
	private final String pkgName;
	private final String langName;
	private final String sourceFile;
	private final Input input;
	private final Element rootElement;
	private final String myDsl;
	private int elementCount;
	private final Generator output;

	public MyGenerator(final URI uri, final XtextTest xtext) throws IOException {
		this.uri = uri;
		this.xtext = xtext;
		// System.out.println("uri='" + this.uri + "'");
		// System.out.println("uri-path='" + this.uri.path() + "'");
		// System.out.println("uri-device='" + uri.devicePath() + "'");
		// System.out.println("uri-segment='" + uri.lastSegment() + "'");
		this.builder = new StringBuilder();
		this.pkgName = this.xtext.getPackage();
		this.langName = this.xtext.getLang();
		this.input = this.xtext.getInput();
		this.sourceFile = this.getSourceFile();
		this.rootElement = this.xtext.getRoot();
		this.output = xtext.getOutput();
		this.myDsl = MyGenerator.firstCharToUpperCase(this.langName);
	}

	private static String firstCharToUpperCase(final String text) {
		final String first = text.substring(0, 1).toUpperCase();
		final String tail = text.substring(1);
		return first + tail;
	}

	private String getSourceFile() {
		if (this.shouldGenerateTextSourceDataFile()) {
			return this.pkgName.replace(".", "/") + "/"
					+ MyGenerator.PKG_PREFIX + "/"
					+ this.uri.lastSegment().replace(".xtexttest", "") + ".dat";
		}
		return this.input.getFile();
	}

	/*
	 * private String getSourceText() throws IOException { String content = new
	 * String(Files.readAllBytes(Paths.get("sample.txt"))); return content; }
	 */

	public boolean shouldGenerateTextSourceDataFile() {
		final String text = this.input.getText();
		return text != null;
	}

	public String getFileNameForTextSource() {
		return this.sourceFile;
	}

	public String generateForDataFile() {
		return this.input.getText();
	}

	public String getFileNameForJava() {
		return this.pkgName.replace(".", "/") + "/" + MyGenerator.PKG_PREFIX
				+ "/" + this.getJavaClassFileName() + ".java";
	}

	private String getJavaClassFileName() {
		return this.uri.lastSegment().replace(".xtexttest", "");
	}

	public String generateForJava() {
		this.elementCount = 0;
		this.header();
		this.prefixClass();
		this.tokensTest();
		this.prefixParserResult();
		this.generateForElement(this.rootElement);
		this.postfix();
		this.testGenerator();
		this.postfixClass();
		return this.builder.toString();
	}

	private void header() {
		this.builder.append("package ");
		this.builder.append(this.pkgName);
		this.builder.append(".");
		this.builder.append(MyGenerator.PKG_PREFIX);
		this.builder.append(";\n\n");
		this.builder.append("import com.google.inject.Inject;\n");
		this.builder.append("import com.google.inject.Provider;\n");
		this.builder.append("import java.nio.file.Files;\n");
		this.builder.append("import java.nio.file.Path;\n");
		this.builder.append("import java.nio.file.Paths;\n");
		this.builder.append("import java.util.List;\n");
		this.builder.append("import org.antlr.runtime.Token;\n");
		this.builder.append("import org.eclipse.emf.common.util.EList;\n");
		this.builder.append("import org.eclipse.emf.common.util.URI;\n");
		this.builder
		.append("import org.eclipse.emf.ecore.resource.Resource;\n");
		this.builder
		.append("import org.eclipse.emf.ecore.resource.ResourceSet;\n");
		this.builder
		.append("import org.eclipse.emf.ecore.util.EDataTypeEList;\n");
		this.builder.append("import org.eclipse.emf.ecore.EObject;\n");
		this.builder
		.append("import org.eclipse.xtext.generator.IFileSystemAccess;\n");
		this.builder.append("import org.eclipse.xtext.generator.IGenerator;\n");
		this.builder
		.append("import org.eclipse.xtext.generator.JavaIoFileSystemAccess;\n");
		this.builder.append("import org.eclipse.xtext.junit4.");
		this.builder.append("InjectWith;\n");
		this.builder.append("import org.eclipse.xtext.junit4.");
		this.builder.append("util.ParseHelper;\n");
		this.builder.append("import org.eclipse.xtext.junit4.");
		this.builder.append("validation.ValidationTestHelper;\n");
		this.builder.append("import org.eclipse.xtext.junit4.");
		this.builder.append("XtextRunner;\n");
		this.builder.append("import org.eclipse.xtext.util.CancelIndicator;\n");
		this.builder.append("import org.eclipse.xtext.validation.CheckMode;\n");
		this.builder
		.append("import org.eclipse.xtext.validation.IResourceValidator;\n");
		this.builder.append("import org.eclipse.xtext.validation.Issue;\n");
		this.builder
				.append("import org.eclipse.xtext.parser.antlr.ITokenDefProvider;\n");
		this.builder.append("import org.junit.Assert;\n");
		this.builder.append("import org.junit.After;\n");
		this.builder.append("import org.junit.Before;\n");
		this.builder.append("import org.junit.Test;\n");
		this.builder.append("import org.junit.runner.RunWith;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".tests.");
		this.builder.append(this.myDsl);
		this.builder.append("InjectorProvider;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".parser.antlr.");
		this.builder.append(this.myDsl);
		this.builder.append("Parser;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".parser.antlr.internal.Internal");
		this.builder.append(this.myDsl);
		this.builder.append("Lexer;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".");
		this.builder.append(MyGenerator.PKG_PREFIX);
		this.builder.append(".LexerAndParserTest;\n");
		this.builder.append("\n");
		this.iterateImports(this.rootElement);
		this.builder.append("\n");
		this.builder.append("@SuppressWarnings(\"unused\")\n");
		this.builder.append("@RunWith(XtextRunner.class)\n");
		this.builder.append("@InjectWith(");
		this.builder.append(this.myDsl);
		this.builder.append("InjectorProvider.class)\n");
	}

	private void iterateImports(final Element elem) {
		if (elem == null) {
			return;
		}
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".");
		this.builder.append(this.langName);
		this.builder.append(".");
		final String name = this.getName(elem);
		this.builder.append(name);
		this.builder.append(";\n");
		final EList<Inner> inners = elem.getInner();
		for (final Inner inner : inners) {
			final Element assignElem = inner.getAssign();
			this.iterateImports(assignElem);
			this.iterateList(inner.getAssignList());
		}
	}

	private void iterateList(final EList<Element> list) {
		if (list == null) {
			return;
		}
		for (final Element elem : list) {
			this.iterateImports(elem);
		}
	}

	private void prefixClass() {
		this.builder.append("public class ");
		this.builder.append(this.getJavaClassFileName());
		this.builder.append(" {\n\n");
		this.builder.append("\t@Inject\n");
		this.builder.append("\tprivate ParseHelper<");
		this.builder.append(this.getName(this.rootElement));
		this.builder.append("> parseHelper;\n");
		this.builder.append("\t@Inject\n");
		this.builder.append("\tprivate ValidationTestHelper valHelper;\n");
		this.builder.append("\t@Inject\n\tprivate Internal");
		this.builder.append(this.myDsl);
		this.builder.append("Lexer lexer;\n");
		this.builder.append("\t@Inject\n\tprivate ");
		this.builder.append(this.myDsl);
		this.builder.append("Parser parser;\n");
		this.builder.append("\t@Inject\n");
		this.builder.append("\tprivate ITokenDefProvider tokenDefProvider;\n");
		this.builder.append("\t\n");
		// this.builder.append("\t@Inject\n\tLexerAndParserTest testHelper;\n");
		this.builder.append("\tprivate LexerAndParserTest testHelper;\n");
		this.builder.append("\t\n");
		this.builder.append("\t@Inject\n");
		this.builder.append("\tprivate IGenerator generator;\n");
		this.builder.append("\t@Inject\n");
		this.builder
		.append("\tprivate Provider<ResourceSet> resourceSetProvider;\n");
		this.builder.append("\t@Inject\n");
		this.builder.append("\tprivate IResourceValidator validator;\n");
		this.builder.append("\t@Inject\n");
		this.builder
		.append("\tprivate JavaIoFileSystemAccess fileAccessSystem;\n");

		this.builder.append("\t\n");
		this.builder.append("\t@Before\n\tpublic void initialize(){\n");
		this.builder.append("\t\tthis.testHelper = ");
		this.builder.append("new LexerAndParserTest(");
		this.builder.append("lexer, parser, tokenDefProvider);\n");
		this.builder.append("\t}\n");
		this.builder.append("\t\n");
		this.builder.append("\tprivate String getTextFromFile(");
		this.builder.append("final String fileName)\n");
		this.builder.append("\tthrows Exception{\n");
		this.builder.append("\t\tfinal Path path = Paths.get(fileName);\n");
		this.builder.append("\t\tfinal String content = new String(");
		this.builder.append("Files.readAllBytes(path));\n");
		this.builder.append("\t\treturn content;\n");
		this.builder.append("\t}\n");
		this.builder.append("\t\n");
	}

	private void tokensTest() {
		final Tokens tokens = this.xtext.getTokens();
		if (tokens == null) {
			return;
		}
		this.builder.append("\t@Test\n");
		this.builder.append("\tpublic void checkLexerTokens()\n");
		this.builder.append("\tthrows Exception{\n");
		this.builder.append("\t\tfinal String text = this.getTextFromFile(\"");
		if (this.shouldGenerateTextSourceDataFile()) {
			this.builder.append("src-gen/");
		}
		this.builder.append(this.getFileNameForTextSource());
		this.builder.append("\");\n");
		this.builder.append("\t\t//System.out.println(text);\n");
		this.builder.append("\t\tfinal String[] expected = new String[] {\n");
		final EList<String> tokenList = tokens.getTokens();
		for (int i = 0; i < tokenList.size(); i++) {
			final String token = tokenList.get(i);
			this.builder.append("\t\t\t\"RULE_");
			this.builder.append(token);
			this.builder.append("\",\n");
		}
		this.builder.append("\t\t};\n");
		this.builder.append("\t\t//final List<Token> actual = ");
		this.builder.append("testHelper.getTokens(text);\n");
		this.builder.append("\t\t//testHelper.outputTokens(text);\n");
		this.builder
		.append("\t\ttestHelper.checkTokenisation(text, expected);\n");

		// end of method
		this.builder.append("\t}\n");
		this.builder.append("\t\n");
	}

	private void prefixParserResult() {
		this.builder.append("\t@Test\n");
		this.builder.append("\tpublic void checkParserResult()\n");
		this.builder.append("\tthrows Exception{\n");
		this.builder.append("\n");
		this.builder.append("\t\tfinal String text = this.getTextFromFile(\"");
		if (this.shouldGenerateTextSourceDataFile()) {
			this.builder.append("src-gen/");
		}
		this.builder.append(this.getFileNameForTextSource());
		this.builder.append("\");\n");
		this.builder.append("\t\tfinal ");
		this.builder.append(this.getName(this.rootElement));
		this.builder.append(" ");
		this.builder.append(this.getVarName(this.rootElement));
		this.builder.append(" = this.parseHelper.parse(text);\n");
		this.builder.append("\t\n");
		this.builder.append("\t\tthis.valHelper.assertNoErrors(");
		this.builder.append(this.getVarName(this.rootElement));
		this.builder.append(");\n");
	}

	private void postfix() {
		this.builder.append("\t}\n");
		this.builder.append("\t\n");
	}

	private void postfixClass() {
		this.builder.append("\n\n}\n");
	}

	private void testGenerator() {
		if (this.output == null) {
			return;
		}
		this.builder.append("\t@Test\n");
		this.builder.append("\tpublic void testGenerator()");
		this.builder.append(" throws Exception {\n");
		this.builder.append("\t\t// load the resource\n");
		this.builder
		.append("\t\tResourceSet set = this.resourceSetProvider.get();\n");
		this.builder.append("\t\tResource resource = set\n");
		this.builder.append("\t\t\t.getResource(\n");
		this.builder.append("\t\t\tURI.createURI(\"");
		if (this.shouldGenerateTextSourceDataFile()) {
			this.builder.append("src-gen/");
		}
		this.builder.append(this.getFileNameForTextSource());
		this.builder.append("\"), true);\n");
		this.builder.append("\t\t// validate the resource\n");
		this.builder
				.append("\t\tList<Issue> list = this.validator.validate(resource, CheckMode.ALL,\n");
		this.builder.append("\t\tCancelIndicator.NullImpl);\n");
		this.builder.append("\t\tAssert.assertTrue(list.isEmpty());\n");
		this.builder.append("\t\t\n");
		this.builder.append("\t\t// configure and start the generator\n");
		this.builder.append("\t\tthis.fileAccessSystem.setOutputPath(\"");
		String outPath = "";
		final String outFName = this.output.getOutput();
		final int lastIndex = this.output.getOutput().lastIndexOf("/");
		if (lastIndex >= 0) {
			outPath = this.output.getOutput().substring(0, lastIndex);
		}
		this.builder.append(outPath);
		this.builder.append("\");\n");
		this.builder
				.append("\t\tthis.generator.doGenerate(resource, this.fileAccessSystem);\n");
		this.builder.append("\t\t\n");
		this.builder
		.append("\t\tfinal String actual = this.getTextFromFile(\"");
		this.builder.append(outFName);
		this.builder.append("\");\n");
		this.builder
		.append("\t\tfinal String expected = this.getTextFromFile(\"");
		this.builder.append(this.output.getExpected());
		this.builder.append("\");\n");
		this.builder.append("\t\tAssert.assertEquals(expected, actual);\n");
		this.builder
				.append("\t\t// System.out.println(\"Code generation finished.\");\n");
		this.builder.append("\t}\n");
	}

	private String getName(final Element element) {
		final String name = element.getName();
		return name;
	}

	private String getVarName(final Element element) {
		final String name = this.getName(element);
		final String varName = name + "_" + this.elementCount + "_Var";
		return varName;
	}

	private void generateForElement(final Element element) {
		final String varName = this.getVarName(element);
		this.builder.append("\t\tAssert.assertNotNull(");
		this.builder.append(varName);
		this.builder.append(");\n");

		final EList<Inner> innerList = element.getInner();
		if (innerList == null) {
			return;
		}
		for (int i = 0; i < innerList.size(); i++) {
			final Inner inner = innerList.get(i);
			final String paramName = this.getParamName(inner);

			if (inner.getAssign() != null) {
				this.handleSingleAssign(varName, paramName, inner.getAssign());
			} else if ((inner.getAssignList() != null)
					&& (!inner.getAssignList().isEmpty())) {
				this.handleListAssign(varName, paramName, inner.getAssignList());
			} else if ((inner.getAssignAsData() != null)
					&& (!inner.getAssignAsData().isEmpty())) {
				this.handleDataListAssign(varName, paramName,
						inner.getAssignAsData());
			} else {
				this.handleValueAssign(varName, paramName, inner.getValue());
			}
		}
	}

	private String getParamName(final Inner inner) {
		final String paramName = inner.getParameter();
		return MyGenerator.firstCharToUpperCase(paramName);
	}

	private void handleSingleAssign(final String varName,
			final String paramName, final Element element) {
		this.elementCount = this.elementCount + 1;
		final String type = MyGenerator.firstCharToUpperCase(element.getName());
		final String tmpName = this.getVarName(element);
		this.builder.append("\t\tfinal ");
		this.builder.append(type);
		this.builder.append(" ");
		this.builder.append(tmpName);
		this.builder.append(" = (");
		this.builder.append(type);
		this.builder.append(")");
		this.builder.append(varName);
		this.builder.append(".get");
		this.builder.append(paramName);
		this.builder.append("();\n");
		this.generateForElement(element);
	}

	private void handleListAssign(final String varName, final String paramName,
			final EList<Element> assignList) {
		final String listName = this.getListName(paramName);
		this.builder.append("\t\tfinal EList<? extends EObject> ");
		this.builder.append(listName);
		this.builder.append(" = ");
		this.builder.append(varName);
		this.builder.append(".get");
		this.builder.append(paramName);
		this.builder.append("();\n");
		this.builder.append("\t\tAssert.assertNotNull(");
		this.builder.append(listName);
		this.builder.append(");\n");
		this.builder.append("\t\tAssert.assertEquals(");
		this.builder.append(assignList.size());
		this.builder.append(", ");
		this.builder.append(listName);
		this.builder.append(".size());\n");
		for (int i = 0; i < assignList.size(); i++) {
			final Element element = assignList.get(i);
			final String type = element.getName();
			this.elementCount = this.elementCount + 1;
			final String tmpName = this.getVarName(element);
			this.builder.append("\t\tfinal ");
			this.builder.append(type);
			this.builder.append(" ");
			this.builder.append(tmpName);
			this.builder.append(" = (");
			this.builder.append(type);
			this.builder.append(")");
			this.builder.append(listName);
			this.builder.append(".get(");
			this.builder.append(i);
			this.builder.append(");\n");
			this.generateForElement(element);
		}
	}

	private String getListName(final String paramName) {
		return paramName + "_" + this.elementCount + "_list";
	}

	private void handleValueAssign(final String varName,
			final String paramName, final String value) {
		this.builder.append("\t\tAssert.assertEquals(\"");
		this.builder.append(value);
		this.builder.append("\", ");
		this.builder.append(varName);
		this.builder.append(".get");
		this.builder.append(paramName);
		this.builder.append("());\n");
	}

	private void handleDataListAssign(final String varName,
			final String paramName, final String assignAsData) {
		this.builder.append("\t\tAssert.assertEquals(\"");
		this.builder.append(assignAsData);
		this.builder.append("\", ");
		this.builder.append(varName);
		this.builder.append(".get");
		this.builder.append(paramName);
		this.builder.append("().toString());\n");
	}
}
