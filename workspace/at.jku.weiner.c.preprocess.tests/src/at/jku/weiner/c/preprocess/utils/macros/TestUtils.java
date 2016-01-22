package at.jku.weiner.c.preprocess.utils.macros;

import java.util.List;

import org.antlr.runtime.Token;
import org.junit.Assert;

public class TestUtils {

	public static void assertEqualsList(final List<Token> expected,
			final List<Token> actual) {
		final StringBuffer bufferExpected = TokenUtils
				.getStringBufferFor(expected);
		final StringBuffer bufferActual = TokenUtils.getStringBufferFor(actual);
		final String textExpected = bufferExpected.toString();
		final String textActual = bufferActual.toString();
		Assert.assertEquals(textExpected, textActual);
	}

	public static MacroRanges getMacroRange(final int startIndex,
			final int stopIndex) {
		MacroRanges result = new MacroRanges(startIndex, stopIndex, 0);
		return result;
	}

}
