package at.jku.weiner.cpreprocess.mytests;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.cpreprocess.utils.MyCodeLineValueConverter;

public class TestMyCodeLine {

	@Test
	public void testToValue() {
		final MyCodeLineValueConverter c = new MyCodeLineValueConverter();
		final IValueConverter<String> converter = c.MyCodeLine();
		Assert.assertNotNull(converter);
		Assert.assertEquals("", converter.toValue(" 	", null));
		Assert.assertEquals("abc", converter.toValue(" 	abc	\n", null));
		Assert.assertEquals("abc", converter.toValue("abc", null));
	}

	@Test(expected = ValueConverterException.class)
	public void testToValueNullPointer() {
		final MyCodeLineValueConverter c = new MyCodeLineValueConverter();
		final IValueConverter<String> converter = c.MyCodeLine();
		Assert.assertNotNull(converter);
		converter.toValue(null, null);
	}

	@Test(expected = ValueConverterException.class)
	public void testToValueException() {
		final MyCodeLineValueConverter c = new MyCodeLineValueConverter();
		final IValueConverter<String> converter = c.MyCodeLine();
		Assert.assertNotNull(converter);
		converter.toValue("", null);
	}

}
