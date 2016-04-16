package at.jku.weiner.kefax.shared;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.core.runtime.OperationCanceledException;

public class MyStreamReader extends MyActionHandler {

	private final InputStream inputStream;
	private BufferedReader in;

	public MyStreamReader(final InputStream inputStream) {
		super("at.jku.weiner.kefax.shared.StreamReader");
		this.inputStream = inputStream;
		this.in = null;
	}
	
	@Override
	protected void myRun() throws Exception {
		final Reader reader = new InputStreamReader(this.inputStream);
		this.in = new BufferedReader(reader);
		String line;
		while ((line = this.in.readLine()) != null) {
			System.out.println(line);
			if (this.getMonitor().isCanceled()) {
				throw new OperationCanceledException(
						"Operation canceled by user!");
			}
		}
	}
	
	public void close() throws Exception {
		this.in.close();
		this.in = null;
	}
}
