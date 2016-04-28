package at.jku.weiner.c.modisco.discoverer.actions;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.modisco.infra.discovery.core.AbstractModelDiscoverer;
import org.eclipse.modisco.infra.discovery.core.annotations.Parameter;

import at.jku.weiner.c.modisco.discoverer.backend.IDiscoverer;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationBackend;
import at.jku.weiner.c.modisco.discoverer.backend.SerializationFactory;
import at.jku.weiner.c.modisco.discoverer.utils.MySettings;

public abstract class AbstractDiscoverer<T> extends AbstractModelDiscoverer<T>
		implements IDiscoverer {

	protected static boolean closeCalled = true;

	private final MySettings settings = new MySettings();
	protected SerializationBackend backend = null;

	public AbstractDiscoverer() {
		super();
		super.setSerializeTarget(true);
		this.backend = SerializationFactory.getBackend(this, this.settings);
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
		// this.checkClosed("BATCH_MODE", batchMode,
		// this.settings.isBatchMode());
		this.settings.setBatchMode(batchMode);
	}

	@Parameter(name = "USENEOEMF", requiresInputValue = false, description = "Use NeoEMF persistence layer instead of default one (XMI serialization)")
	public final void setUseNeoEMF(final boolean setUseNeoEMF) {
		if (setUseNeoEMF == this.settings.isUseNeoEMF()) {
			return;
		}
		// this.checkClosed("USENEOEMF", setUseNeoEMF,
		// this.settings.isUseNeoEMF());
		this.settings.setUseNeoEMF(setUseNeoEMF);
		this.backend = SerializationFactory.getBackend(this, this.settings);
	}

	public final boolean isUseNeoEMF() {
		return this.settings.isUseNeoEMF();
	}

	@SuppressWarnings("unused")
	private void checkClosed(final String reason, final boolean val1,
			final boolean val2) {
		if (val1 == val2) {
			return;
		}
		if (!AbstractDiscoverer.closeCalled) {
			throw new IllegalStateException("could not change state of '"
					+ reason + "' because discoverer has not been closed yet!!");
		}
	}

	@Override
	public final ResourceSet getResourceSet() {
		return super.getResourceSet();
	}

	@Override
	public final void setResourceSet(final ResourceSet resourceSet) {
		super.setResourceSet(resourceSet);
	}

	@Override
	public final Resource getTargetResource() {
		return super.getTargetModel();
	}

	@Override
	public final void setTargetResource(final Resource resource) {
		super.setTargetModel(resource);
	}

}
