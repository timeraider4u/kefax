package at.jku.weiner.c.cmdarguments.services;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.nodemodel.INode;

public class CmdArgumentsValueConverter extends
AbstractDeclarativeValueConverterService {

	@ValueConverter(rule = "STRING2")
	public IValueConverter<String> STRING2() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				return CmdArgumentsValueConverter.this.removeQuotes(string);
			}

			@Override
			public String toString(final String string) {
				return string;
			}

		};
	}

	private String removeQuotes(final String string) {
		if (string == null) {
			return "";
		}
		if (string.startsWith("\"") && string.endsWith("\"")) {
			return string.substring(1, string.length() - 1);
		} else if (string.startsWith("'") && string.endsWith("'")) {
			return string.substring(1, string.length() - 1);
		}
		return string;
	}

}
