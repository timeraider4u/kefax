package at.jku.weiner.c.preprocess.utils;

public class OSUtils {

	public static OSEnum getOS() {
		final String os = System.getProperty("os.name");
		if (os.indexOf("win") >= 0) {
			return OSEnum.MSWindows;
		}
		return OSEnum.Linux;
	}

}
