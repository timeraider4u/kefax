package at.jku.weiner.c.common.utils;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class MyValueConverterCommon extends
AbstractDeclarativeValueConverterService {

	@ValueConverter(rule = "CHAR")
	public IValueConverter<String> CHAR() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				System.out.println("CHAR_LITERAL.toValue()");

				if (Strings.isEmpty(string)) {
					throw new ValueConverterException(
							"Couldn't convert empty CHAR_LITERAL to String",
							node, null);
				}
				System.out.println("CHAR_LITERAL.toValue()");
				if (string.startsWith("L")) {
					return string.substring(1);
				}
				return string;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				System.out.println("CHAR_LITERAL.toString()");

				return value;
			}

		};
	}

	@ValueConverter(rule = "ID")
	public IValueConverter<String> ID() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				System.out.println("ID.toValue()");

				if (Strings.isEmpty(string)) {
					throw new ValueConverterException(
							"Couldn't convert empty ID to String", node, null);
				}
				return string;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				System.out.println("ID.toString()");

				return value;
			}

		};
	}
}
