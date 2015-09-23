package at.jku.weiner.c;

import java.net.URL;
import java.net.URLClassLoader;

public class Main {

	public static void main(final String[] args) {

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();

		for (URL url : urls) {
			System.out.println(url.getFile());
		}

	}

}
