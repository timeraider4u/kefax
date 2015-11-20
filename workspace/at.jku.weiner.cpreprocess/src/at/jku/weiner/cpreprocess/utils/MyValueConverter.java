package at.jku.weiner.cpreprocess.utils;

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
				return string.trim();
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLine")
	public IValueConverter<String> MyDefineLine() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string)) {
					return "";
				}
				return string.trim();
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

}
