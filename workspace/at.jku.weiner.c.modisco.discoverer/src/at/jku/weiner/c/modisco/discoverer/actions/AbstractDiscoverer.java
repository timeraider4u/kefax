package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.annotations.Parameter;

import at.jku.weiner.c.modisco.discoverer.backend.IDiscoverer;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public abstract class AbstractDiscoverer<T> extends AbstractModelDiscoverer<T>
		implements IDiscoverer {

	private final MySettings settings = new MySettings();

	public AbstractDiscoverer() {
		super();
		super.setSerializeTarget(true);
	}

	protected final MySettings getSettings() {
		return this.settings;
	}

	public final boolean isSetStdInclude() {
		return this.settings.isSetStdInclude();
	}

	@Parameter(name = "STD_INCLUDE", requiresInputValue = false, description = "Use default standard include directories (e.g. /usr/include/). Set to false for -nostdinc behaviour.")
	public final void setSetStdInclude(final boolean setStdInclude) {
		this.settings.setSetStdInclude(setStdInclude);
	}

	public final String getIncludeDirs() {
		return this.settings.getIncludeDirs();
	}

	@Parameter(name = "INCLUDE_DIRS", requiresInputValue = false, description = "Add additional directories to search path. Use File.pathSeparator to add multiple directories.")
	public final void setIncludeDirs(final String includeDirs) {
		this.settings.setIncludeDirs(includeDirs);
	}

	public final String getAdditionalDirectives() {
		return this.settings.getAdditionalDirectives();
	}

	@Parameter(name = "ADDITIONAL_PREPROCESSOR_DIRECTIVES", requiresInputValue = false, description = "Add additional preprocessor directives and macros"
			+ "(e.g., <br/>#define FOO BAR<br/>#define BAR(x) #x<br/>#include &quot;include/myinclude.h&quot;")
	public final void setAdditionalDirectives(final String defines) {
		this.settings.setAdditionalDirectives(defines);
	}

	public final boolean isTrimPreprocessModel() {
		return this.settings.isTrimPreprocessModel();
	}

	@Parameter(name = "TRIM_PREPROCESS_MODEL", requiresInputValue = false, description = "Remove code and empty lines from preprocessor model"
			+ "(" + MySettings.EXCLUSIVE_MSG + ")")
	public final void setTrimPreprocessModel(final boolean trimPreprocessModel) {
		this.settings.setTrimPreprocessModel(trimPreprocessModel);
	}

	public final boolean isBatchMode() {
		return this.settings.isBatchMode();
	}

	@Parameter(name = "BATCH_MODE", requiresInputValue = false, description = "Re-use model and clean-up any temporarily saved serializations"
			+ " (" + MySettings.EXCLUSIVE_MSG + ")")
	public final void setBatchMode(final boolean batchMode) {
		this.settings.setBatchMode(batchMode);
	}

	@Parameter(name = "USENEOEMF", requiresInputValue = false, description = "Use NeoEMF persistence layer instead of default one (XMI serialization)")
	public final void setUseNeoEMF(final boolean setUseNeoEMF) {
		this.settings.setUseNeoEMF(setUseNeoEMF);
	}

	public final boolean isUseNeoEMF() {
		return this.settings.isUseNeoEMF();
	}

	@Override
	public Resource createTargetModel() {
		final Resource res = super.createTargetModel();
		return res;
	}

}
