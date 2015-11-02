package at.jku.weiner.xtexttest.generator;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;

import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Generator;
import at.jku.weiner.xtexttest.xtextTest.Input;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;

final class MyHelper {
	protected final String PKG_PREFIX = "xtexttests";

	protected final URI uri;
	protected final XtextTest xtext;
	protected final String pkgName;
	protected final String langName;
	protected final String sourceFile;
	protected final Input input;
	protected final Element rootElement;
	protected final String myDsl;
	protected int elementCount;
	protected final Generator output;

	public MyHelper(final URI uri, final XtextTest xtext) throws IOException {
		this.uri = uri;
		this.xtext = xtext;
		// System.out.println("uri='" + this.uri + "'");
		// System.out.println("uri-path='" + this.uri.path() + "'");
		// System.out.println("uri-device='" + uri.devicePath() + "'");
		// System.out.println("uri-segment='" + uri.lastSegment() + "'");
		this.pkgName = this.xtext.getPackage();
		this.langName = this.xtext.getLang();
		this.input = this.xtext.getInput();
		this.sourceFile = this.getSourceFile();
		this.rootElement = this.xtext.getRoot();
		this.output = xtext.getOutput();
		this.myDsl = this.firstCharToUpperCase(this.langName);
	}

	private String firstCharToUpperCase(final String text) {
		final String first = text.substring(0, 1).toUpperCase();
		final String tail = text.substring(1);
		return first + tail;
	}

	private String getSourceFile() {
		if (this.shouldGenerateTextSourceDataFile()) {
			return this.pkgName.replace(".", "/") + "/" + this.PKG_PREFIX + "/"
					+ this.uri.lastSegment().replace(".xtexttest", "") + ".dat";
		}
		return this.input.getFile();
	}

	protected boolean shouldGenerateTextSourceDataFile() {
		final String text = this.input.getText();
		return text != null;
	}

	public String generateForDataFile() {
		return this.input.getText();
	}

	public String getFileNameForJava() {
		return this.pkgName.replace(".", "/") + "/" + this.PKG_PREFIX + "/"
				+ this.getJavaClassFileName() + ".java";
	}

	private String getJavaClassFileName() {
		return this.uri.lastSegment().replace(".xtexttest", "");
	}

}
