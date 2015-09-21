package org.xtext.example.mydsl1;

public final class TestScope {

	private static int i = 0;

	public static void inc() {
		TestScope.i++;
		System.out.println("inc: Test scope is now ='" + TestScope.i + "'");
	}

	public static boolean isValid() {
		System.out.println("isValid: Test scope is now ='" + TestScope.i + "'");
		return TestScope.i > 2;
	}

	public static void reset() {
		System.out.println("resetting!");
		TestScope.i = 0;
	}
}
