package at.jku.weiner.c.preprocess.mytests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import at.jku.weiner.c.preprocess.utils.MyPath;
import at.jku.weiner.log.MyLog;

public class TestMyPath {
	private static final String INCLUDE0 = "/home/workstation/include";
	private static final String INCLUDE1 = TestMyPath.INCLUDE0 + "/";
	private static final String INCLUDE2 = "/";
	
	private static final String FILE0 = "abc.h";
	private static final String FILE1 = "include/abc.h";
	
	@Before
	public void setUp() {
		MyLog.setLog_level(MyLog.LOG_NONE);
	}
	
	@Test(timeout = 1000)
	public void testMyPath00() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE0);
		Assert.assertEquals(TestMyPath.INCLUDE0,
				path.getPathWithoutTrailingSlash());
	}
	
	@Test(timeout = 1000)
	public void testMyPath01() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE1);
		Assert.assertEquals(TestMyPath.INCLUDE0,
				path.getPathWithoutTrailingSlash());
	}
	
	@Test(timeout = 1000)
	public void testMyPath02() {
		final MyPath path = new MyPath(TestMyPath.INCLUDE2);
		Assert.assertEquals("", path.getPathWithoutTrailingSlash());
	}
	
	@Test(timeout = 1000)
	public void testCombine00() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE0);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE0,
				path1.combine(path2));
	}
	
	@Test(timeout = 1000)
	public void testCombine01() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE1);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE0,
				path1.combine(path2));
	}
	
	@Test(timeout = 1000)
	public void testCombine02() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE0);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE1,
				path1.combine(path2));
	}
	
	@Test(timeout = 1000)
	public void testCombine03() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE1);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE1 + TestMyPath.FILE1,
				path1.combine(path2));
	}
	
	@Test(timeout = 1000)
	public void testCombine04() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE2);
		final MyPath path2 = new MyPath(TestMyPath.FILE0);
		Assert.assertEquals(TestMyPath.INCLUDE2 + TestMyPath.FILE0,
				path1.combine(path2));
	}
	
	@Test(timeout = 1000)
	public void testCombine05() {
		final MyPath path1 = new MyPath(TestMyPath.INCLUDE2);
		final MyPath path2 = new MyPath(TestMyPath.FILE1);
		Assert.assertEquals(TestMyPath.INCLUDE2 + TestMyPath.FILE1,
				path1.combine(path2));
	}
	
}
