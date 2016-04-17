package at.jku.weiner.log;

class MyLogDefaultLogger implements MyLogService {
	
	@Override
	public void log(final String message) {
		System.out.println(message);
	}
	
	@Override
	public void error(final String message) {
		System.err.println(message);
	}

}
