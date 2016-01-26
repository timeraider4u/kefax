package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;
import org.junit.Assert;

public class TestUtils {

	public static void assertEqualsList(final List<Token> expected,
			final List<Token> actual) {
		if ((expected == null) || (actual == null)) {
			Assert.assertNull(expected);
			Assert.assertNull(actual);
			return;
		}
		Assert.assertNotNull(expected);
		Assert.assertNotNull(actual);
		// Assert.assertEquals(expected.size(), actual.size());
		final StringBuffer bufferExpected = TokenUtils.getStringBufferFor(
				expected, true);
		final StringBuffer bufferActual = TokenUtils.getStringBufferFor(actual,
				true);
		final String textExpected = bufferExpected.toString();
		final String textActual = bufferActual.toString();
		Assert.assertEquals(textExpected, textActual);
	}

	public static MacroRanges getMacroRange(final int startIndex,
			final int stopIndex) {
		final MacroRanges result = new MacroRanges(startIndex, stopIndex);
		return result;
	}

}
