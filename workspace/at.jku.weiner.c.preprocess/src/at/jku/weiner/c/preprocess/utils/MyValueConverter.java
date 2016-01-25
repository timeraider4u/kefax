package at.jku.weiner.c.preprocess.utils;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class MyValueConverter extends DefaultTerminalConverters {

	@ValueConverter(rule = "MyCodeLine")
	public IValueConverter<String> MyCodeLine() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string)) {
					throw new ValueConverterException(
							"Couldn't convert empty MyCodeLine to String",
							node, null);
				}
				final String result = MyValueConverter.replaceNewline(string);
				return result.trim();
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLineObject")
	public IValueConverter<String> MyDefineLine() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				return MyValueConverter.replaceAll(string);
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLineFunction")
	public IValueConverter<String> MyDefineLine2() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				return MyValueConverter.replaceAll(string);
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}
		};
	}

	private static String replaceAll(final String input) {
		if (Strings.isEmpty(input)) {
			return "";
		}
		final String replace1 = MyValueConverter.replaceNewline(input);
		final String replace2 = MyValueConverter.replaceTabs(replace1);
		final String replace3 = MyValueConverter.replaceDoubleWS(replace2);
		final String replace4 = replace3.trim();
		return replace4;
	}

	private static String replaceDoubleWS(final String input) {
		final String string = input.replaceAll("\\s+", " ");
		return string;
	}

	private static String replaceTabs(final String input) {
		final String string = input.replaceAll("\t", " ");
		return string;
	}

	private static String replaceNewline(final String input) {
		final String string = input.replace("\\\n", " ");
		return string;
	}
}
