package at.jku.weiner.c.preprocess.mytests;

import org.junit.Assert;
import org.junit.Test;

import at.jku.weiner.c.preprocess.utils.MyPath;

public class TestMyPath {
	private static final String INCLUDE0 = "/home/workstation/include";
	private static final String INCLUDE1 = TestMyPath.INCLUDE0 + "/";
	private static final String INCLUDE2 = "/";

	private static final String FILE0 = "abc.h";
	private static final String FILE1 = "include/abc.h";

	@Test
	public void testMyPath00() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE0);
		Assert.assertEquals(TestMyPath.INCLUDE0,
				path.getPathWithoutTrailingSlash());
	}

	@Test
	public void testMyPath01() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE1);
		Assert.assertEquals(TestMyPath.INCLUDE0,
				path.getPathWithoutTrailingSlash());
	}

	@Test
	public void testMyPath02() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE2);
		Assert.assertEquals("", path.getPathWithoutTrailingSlash());
	}

	@Test
	public void testCombine00() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE0);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE0,
				path1.combine(path2));
	}

	@Test
	public void testCombine01() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE1);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE0,
				path1.combine(path2));
	}

	@Test
	public void testCombine02() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE0);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE1,
				path1.combine(path2));
	}

	@Test
	public void testCombine03() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE1);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE1,
				path1.combine(path2));
	}

	@Test
	public void testCombine04() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE2);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE2 + TestMyPath.FILE0,
				path1.combine(path2));
	}

	@Test
	public void testCombine05() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE2);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE2 + TestMyPath.FILE1,
				path1.combine(path2));
	}

}
