package at.jku.weiner.c.preprocess.utils;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

import at.jku.weiner.c.common.utils.MyValueConverterCommon;

/***
 * thanks to the issue with not calling the value converter on terminal rules
 * when called from data rules when called from data rules, we have to duplicate
 * code!
 *
 */
public class MyValueConverter extends MyValueConverterCommon {

	// @Override
	// public Object toValue(final String string, final String lexerRule,
	// final INode node) throws ValueConverterException {
	// System.out.println("toValue='" + string + "', lexerRule='" + lexerRule
	// + "'");
	// return super.toValue(string, lexerRule, node);
	// }

	@ValueConverter(rule = "MyCode")
	public IValueConverter<String> MyCode() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String temp = MyValueConverterCommon
						.updateCharSequence(string);
				return temp;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	@ValueConverter(rule = "MyCodeLine")
	public IValueConverter<String> MyCodeLine() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string)) {
					throw new ValueConverterException(
							"Could not convert empty MyCodeLine to String!",
							node, null);
				}
				final String temp = MyValueConverterCommon
						.updateCharSequence(string);
				final String result = MyValueConverter.replaceNewline(temp);
				return result.trim();
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

	@ValueConverter(rule = "MyCodeLineExtended")
	public IValueConverter<String> MyCodeLineExtended() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string)) {
					return "";
				}
				final String result = MyValueConverterCommon
						.updateCharSequence(string);
				return result;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

	@ValueConverter(rule = "MyCodeLineExtendedNormal")
	public IValueConverter<String> MyCodeLineExtendedNormal() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				if (Strings.isEmpty(string)) {
					return "";
				}
				final String result = MyValueConverterCommon
						.updateCharSequence(string);
				return result;
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return " " + value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLineObject")
	public IValueConverter<String> MyDefineLineObject() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String temp = MyValueConverterCommon
						.updateCharSequence(string);
				return MyValueConverter.replaceAll(temp);
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLine")
	public IValueConverter<String> MyDefineLine() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String temp = MyValueConverterCommon
						.updateCharSequence(string);
				return MyValueConverter.replaceAll(temp);
			}

			@Override
			public String toString(final String value)
					throws ValueConverterException {
				return value;
			}

		};
	}

	@ValueConverter(rule = "MyDefineLineFunction")
	public IValueConverter<String> MyDefineLineFunction() {
		return new IValueConverter<String>() {

			@Override
			public String toValue(final String string, final INode node)
					throws ValueConverterException {
				final String temp = MyValueConverterCommon
						.updateCharSequence(string);
				return MyValueConverter.replaceAll(temp);
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
		final String replace0 = MyValueConverterCommon.removeLineBreak(input);
		final String replace1 = MyValueConverter.replaceNewline(replace0);
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
