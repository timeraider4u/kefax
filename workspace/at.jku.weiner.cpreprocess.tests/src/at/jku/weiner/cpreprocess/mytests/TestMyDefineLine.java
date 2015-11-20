package at.jku.weiner.cpreprocess.mytests;

import org.eclipse.xtext.conversion.IValueConverter;
import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.cpreprocess.utils.MyValueConverter;

public class TestMyDefineLine {

	@Test
	public void testToValue() {
		final MyValueConverter c = new MyValueConverter();
		final IValueConverter<String> converter = c.MyDefineLine();
		Assert.assertNotNull(converter);
		Assert.assertEquals("", converter.toValue(" 	", null));
		Assert.assertEquals("abc", converter.toValue(" 	abc	\n", null));
		Assert.assertEquals("abc", converter.toValue("abc", null));
	}

	public void testToValueNullPointer() {
		final MyValueConverter c = new MyValueConverter();
		final IValueConverter<String> converter = c.MyDefineLine();
		Assert.assertNotNull(converter);
		Assert.assertEquals("", converter.toValue(null, null));
	}

	public void testToValueException() {
		final MyValueConverter c = new MyValueConverter();
		final IValueConverter<String> converter = c.MyDefineLine();
		Assert.assertNotNull(converter);
		Assert.assertEquals("", converter.toValue("", null));
	}

}
