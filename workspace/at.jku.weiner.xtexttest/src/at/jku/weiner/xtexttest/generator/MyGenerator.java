package at.jku.weiner.xtexttest.generator;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.xtexttest.xtextTest.Element;
import at.jku.weiner.xtexttest.xtextTest.Inner;
import at.jku.weiner.xtexttest.xtextTest.XtextTest;
import org.eclipse.emf.common.util.URI;

public class MyGenerator {

	private final URI uri;
	private final StringBuilder builder;
	private XtextTest xtext;
	private String pkgName;
	private String langName;

	public MyGenerator(final URI uri) {
		this.uri = uri;
		// System.out.println("uri='" + this.uri + "'");
		// System.out.println("uri-path='" + this.uri.path() + "'");
		// System.out.println("uri-device='" + uri.devicePath() + "'");
		// System.out.println("uri-segment='" + uri.lastSegment() + "'");
		this.builder = new StringBuilder();
	}

	public String generate(final XtextTest xtext) {
		this.xtext = xtext;
		this.prefix();
		final Element rootElem = xtext.getRoot();
		this.generateForElement(rootElem);
		this.postfix();
		return this.builder.toString();
	}

	private void prefix() {
		this.pkgName = this.xtext.getPackage();
		this.langName = this.xtext.getLang();
		final Element rootElem = this.xtext.getRoot();
		this.builder.append("package ");
		this.builder.append(this.pkgName);
		this.builder.append(".tests;\n\n");
		this.builder.append("import org.junit.Assert;\n\n");
		this.iterateImports(rootElem);
		this.builder.append("\n");
		this.builder.append("public class XtextTest {\n\n");
		this.builder.append("\tpublic static void check(");
		final String name = this.getName(rootElem);
		final String varName = this.getVarName(rootElem);
		this.builder.append(name);
		this.builder.append(" ");
		this.builder.append(varName);
		this.builder.append("){\n");
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

	private void postfix() {
		this.builder.append("\n\t}\n\n}\n");
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
		this.builder.append(");");
	}

	public String getFileName() {
		// System.out.println("pkgName='" + this.pkgName + "'");
		return this.pkgName.replace(".", "/") + "/" + this.uri.lastSegment()
				+ ".java";
	}

}
