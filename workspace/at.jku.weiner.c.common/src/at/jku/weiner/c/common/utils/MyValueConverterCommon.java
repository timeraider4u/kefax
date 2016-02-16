package at.jku.weiner.c.common.utils;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class MyValueConverterCommon extends
		AbstractDeclarativeValueConverterService {

	@ValueConverter(rule = "CharLiteral")
	public IValueConverter<String> CharLiteral() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String result = MyValueConverterCommon.cutChar(string,
						node);
				return result;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	@ValueConverter(rule = "Constant1")
	public IValueConverter<String> Constant1() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String result = MyValueConverterCommon.cutChar(string,
						node);
				return result;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	protected static String cutChar(final String string, final INode node) {
		if (Strings.isEmpty(string)) {
			// throw new ValueConverterException(
			// "Couldn't convert empty Constant1 to String", node, null);
			return "";
		}
		if (string.startsWith("L'") && string.endsWith("'")) {
			return string.substring(1);
		}
		return string;
	}

}
