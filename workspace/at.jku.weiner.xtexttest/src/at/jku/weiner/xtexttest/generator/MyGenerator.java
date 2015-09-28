package at.jku.weiner.xtexttest.generator;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Inner;
import at.jku.weiner.xtexttest.xtextTest.Input;
import at.jku.weiner.xtexttest.xtextTest.Tokens;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;

public class MyGenerator {

	private final URI uri;
	private final StringBuilder builder;
	private final XtextTest xtext;
	private final String pkgName;
	private final String langName;
	private final String sourceFile;
	private final Input input;
	private final Element rootElement;

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
	}

	private String getSourceFile() {
		if (this.shouldGenerateTextSourceDataFile()) {
			return this.pkgName.replace(".", "/") + "/tests/"
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
		return this.pkgName.replace(".", "/") + "/tests/"
				+ this.getJavaClassFileName() + ".java";
	}

	private String getJavaClassFileName() {
		return this.uri.lastSegment().replace(".xtexttest", "");
	}

	public String generateForJava() {
		this.header();
		this.prefixClass();
		this.tokensTest();
		this.prefixParserResult();
		this.generateForElement(this.rootElement);
		this.postfix();
		return this.builder.toString();
	}

	private void header() {
		final String first = this.langName.substring(0, 1).toUpperCase();
		final String tail = this.langName.substring(1);
		this.builder.append("package ");
		this.builder.append(this.pkgName);
		this.builder.append(".tests;\n\n");
		this.builder.append("import com.google.inject.Inject;\n");
		this.builder.append("import java.nio.file.Files;\n");
		this.builder.append("import java.nio.file.Path;\n");
		this.builder.append("import java.nio.file.Paths;\n");
		this.builder.append("import java.util.List;\n");
		this.builder.append("import org.antlr.runtime.Token;\n");
		this.builder.append("import org.eclipse.emf.common.util.EList;\n");
		this.builder.append("import org.eclipse.xtext.junit4.InjectWith;\n");
		this.builder
		.append("import org.eclipse.xtext.junit4.util.ParseHelper;\n");
		this.builder
				.append("import org.eclipse.xtext.junit4.validation.ValidationTestHelper;\n");
		this.builder.append("import org.eclipse.xtext.junit4.XtextRunner;\n");
		this.builder.append("import org.junit.Assert;\n");
		this.builder.append("import org.junit.Test;\n");
		this.builder.append("import org.junit.runner.RunWith;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".tests.");
		this.builder.append(first);
		this.builder.append(tail);
		this.builder.append("InjectorProvider;\n");
		this.builder.append("import ");
		this.builder.append(this.pkgName);
		this.builder.append(".tests.LexerAndParserTest;\n");
		this.builder.append("\n");
		this.iterateImports(this.rootElement);
		this.builder.append("\n");
		this.builder.append("@SuppressWarnings(\"unused\")\n");
		this.builder.append("@RunWith(XtextRunner.class)\n");
		this.builder.append("@InjectWith(");
		this.builder.append(first);
		this.builder.append(tail);
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
			this.iterateList(inner.getAssign2());
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
		this.builder.append("\t@Inject\n\tprivate ParseHelper<");
		this.builder.append(this.getName(this.rootElement));
		this.builder.append("> parseHelper;\n");
		this.builder
				.append("\t@Inject\n\tprivate ValidationTestHelper valHelper;\n");
		this.builder.append("\t@Inject\n\tLexerAndParserTest testHelper;\n");
		this.builder.append("\t\n");
		this.builder.append("\tprivate String getSourceText()\n");
		this.builder.append("\tthrows Exception{\n");
		this.builder.append("\tfinal Path path = Paths.get(\"src-gen/");
		this.builder.append(this.getFileNameForTextSource());
		this.builder.append("\");\n");
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
		this.builder.append("\t\tfinal String text = this.getSourceText();\n");
		this.builder.append("\t\tSystem.out.println(text);\n");
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
		this.builder.append("\t\ttestHelper.outputTokens(text);\n");
		this.builder
				.append("\t\t//testHelper.checkTokenisation(text, expected);\n");

		// end of method
		this.builder.append("\t}\n");
		this.builder.append("\t\n");
	}

	private void prefixParserResult() {
		this.builder.append("\t@Test\n");
		this.builder.append("\tpublic void checkParserResult()\n");
		this.builder.append("\tthrows Exception{\n");
		this.builder.append("\n");
		this.builder.append("\t\tfinal String text = this.getSourceText();\n");
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
		this.builder.append("\n\n}\n");
	}

	private String getName(final Element element) {
		final String name = element.getName();
		return name;
	}

	private String getVarName(final Element element) {
		final String name = this.getName(element);
		final String varName = name + "Var";
		return varName;
	}

	private void generateForElement(final Element element) {
		final String varName = this.getVarName(element);
		this.builder.append("\t\tAssert.assertNotNull(");
		this.builder.append(varName);
		this.builder.append(");\n");
	}

}
