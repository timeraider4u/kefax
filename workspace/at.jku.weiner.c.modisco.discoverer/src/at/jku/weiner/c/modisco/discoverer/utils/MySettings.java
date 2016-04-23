package at.jku.weiner.c.modisco.discoverer.utils;

import at.jku.weiner.log.MyLog;

public final class MySettings {
	public static final String EXCLUSIVE_MSG = "TRIM_PREPROCESS_MODEL and BATCH_MODE "
			+ "can not be used at the same time"
			+ " (they are exclusive to each other)";

	private boolean setStdInclude = true;
	private String includeDirs = "";
	private String additionalDirectives = "";
	private boolean trimPreprocessModel = false;
	private boolean batchMode = false;
	private boolean useNeoEMF = false;

	public boolean isSetStdInclude() {
		return this.setStdInclude;
	}

	public void setSetStdInclude(final boolean setStdInclude) {
		this.setStdInclude = setStdInclude;
	}

	public String getIncludeDirs() {
		return this.includeDirs;
	}

	public void setIncludeDirs(final String includeDirs) {
		this.includeDirs = includeDirs;
	}

	public String getAdditionalDirectives() {
		return this.additionalDirectives;
	}

	public void setAdditionalDirectives(final String additionalDirectives) {
		this.additionalDirectives = additionalDirectives;
	}

	public boolean isTrimPreprocessModel() {
		return this.trimPreprocessModel;
	}

	public void setTrimPreprocessModel(final boolean trimPreprocessModel) {
		if (this.batchMode && trimPreprocessModel) {
			this.exclusiveBatchModeAndTrimError();
		}
		this.trimPreprocessModel = trimPreprocessModel;
	}

	public boolean isBatchMode() {
		return this.batchMode;
	}

	public void setBatchMode(final boolean batchMode) {
		if (this.trimPreprocessModel && batchMode) {
			this.exclusiveBatchModeAndTrimError();
		}
		this.batchMode = batchMode;
	}

	public boolean isUseNeoEMF() {
		return this.useNeoEMF;
	}

	public void setUseNeoEMF(final boolean useNeoEMF) {
		this.useNeoEMF = useNeoEMF;
	}

	private void exclusiveBatchModeAndTrimError() {
		final RuntimeException ex = new IllegalArgumentException(
				MySettings.EXCLUSIVE_MSG);
		MyLog.error(MySettings.class, ex);
		throw ex;
	}
}
