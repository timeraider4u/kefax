package at.jku.weiner.kefax.shared;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class MyFileWriter {
	
	public static boolean appendStringToFile(final String fileName,
			final String string) {
		try {
			MyFileWriter.appendStringToFileInternal(fileName, string);
			return true;
		} catch (final Exception ex) {
			ex.printStackTrace();
			final String msg = "Appending string '" + string + "' to file='"
					+ fileName + "' has failed!";
			System.out.println(msg);
			MyNotification.run("File operation has failed", msg);
		}
		return false;
	}
	
	private static void appendStringToFileInternal(final String fileName,
			final String string) throws Exception {
		final Writer writer = new FileWriter(fileName, true);
		final BufferedWriter out = new BufferedWriter(writer);
		out.write(string);
		out.write(System.lineSeparator());
		out.close();
	}

}
