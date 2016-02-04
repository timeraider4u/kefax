package at.jku.weiner.kefax.main.work;

import org.junit.Assert;
import org.junit.Test;

public class UnitTests {
	private final String pattern = Settings.STR_UP_DIR_PATTERN;
	private final String replace = Settings.STR_UP_DIR_REPLACE;
	private final String pattern2 = Settings.STR_UP_DIR_PATTERN_2;
	private final String replace2 = Settings.STR_UP_DIR_REPLACE_2;

	@Test
	public void testPattern1() {
		final String source = "arch/x86/kernel/../include/asm/trace";
		final String expected = "arch/x86/include/asm/trace";
		final String actual = source.replaceAll(this.pattern, this.replace);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPattern2() {
		final String source = "arch/x86/kernel/acpi/../../realmode/rm/wakeup.h";
		final String expected = "arch/x86/realmode/rm/wakeup.h";
		String actual = source.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern, this.replace);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPattern3() {
		final String source = "/home/harry/Private/out/arch/x86/kernel/../../../drivers/lguest/lg.h";
		final String expected = "/home/harry/Private/out/drivers/lguest/lg.h";
		String actual = source.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern2, this.replace2);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testPattern4() {
		final String source = "arch/x86/kernel/../../../drivers/lguest/lg.h";
		final String expected = "drivers/lguest/lg.h";
		String actual = source.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern, this.replace);
		actual = actual.replaceAll(this.pattern2, this.replace2);
		actual = actual.replaceAll(this.pattern2, this.replace2);
		Assert.assertEquals(expected, actual);
	}
}
