package org.eclipse.modisco.kconfig.discoverer.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.modisco.kconfig.KconfigFactory;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.discoverer.parser.my.Parser;
import org.eclipse.modisco.kconfig.discoverer.parser.my.Scanner;

public class MyKConfigParser {

	private final IFile file;
	private final Model model;
	private final KconfigFactory factory;
	private final String content;

	public MyKConfigParser(final IFile file, final Model model,
			final KconfigFactory factory, final String content) {
		this.file = file;
		this.model = model;
		this.factory = factory;
		this.content = this.replaceWithTabs(content);
	}

	private String replaceWithTabs(String string) {
		string = string.replaceAll("#.*\n", "");
		string = string.replace("  ", "\t");
		string = string.replace("\t\n", "\n");
		string = string.replace("\t ", "\t");
		string = string.replace("\t\t", "\t");
		string = string.replace("\t\t", "\t");
		string = string.replace("\n\n\t", "\n\t");
		System.out.println(string);
		return string;
	}

	public void parse() throws IOException {
		final String fileName = this.file.getLocation().toString();
		// final String fileName = this.file.getName();
		final TranslationUnit unit = UnitHelper.lookUpTranslationUnit(
				this.factory, this.model, fileName, true);
		// UnitHelper.insertUnit(this.model, unit);
		final InputStream stream = new ByteArrayInputStream(
				this.content.getBytes("UTF-8"));
		final Scanner scanner = new Scanner(stream);
		final Parser parser = new Parser(scanner, this.factory, this.model,
				unit);
		parser.Parse();

	}
}
