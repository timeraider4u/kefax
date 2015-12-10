package org.eclipse.modisco.cdt.discoverer.actions;

import java.io.File;

import org.eclipse.cdt.core.CCorePlugin;
import org.eclipse.cdt.core.CProjectNature;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.core.model.CoreModel;
import org.eclipse.cdt.core.model.ITranslationUnit;
import org.eclipse.cdt.core.settings.model.ICProjectDescription;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.modisco.cdt.discoverer.utils.MyStore;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;

public final class ParserUtils {

	private static final String NATURE_ID = "org.eclipse.cdt.core.nature";

	private final IProgressMonitor monitor;
	private final CoreModel coreModel;

	private IProject project = null;
	private boolean hasCNature = true;

	public ParserUtils(final IProgressMonitor monitor)
			throws DiscoveryException {
		this.monitor = monitor;
		this.coreModel = DiscovererUtils.getCoreModel();
	}

	public IASTTranslationUnit getTranslationUnitFor(final File file,
			final MyStore store) throws DiscoveryException {
		final ITranslationUnit tu = this.getTranslationUnitFor(file);
		IASTTranslationUnit unit = null;
		try {
			unit = tu.getAST();
		} catch (final CoreException ex) {
			throw new DiscoveryException(ex);
		}
		return unit;
	}

	private ITranslationUnit getTranslationUnitFor(final File file)
			throws DiscoveryException {
		final IFile myfile = DiscovererUtils.getFileFor(file);
		this.project = myfile.getProject();
		final ICProjectDescription cDesc = this.coreModel
				.getProjectDescription(this.project);
		if (cDesc == null) {
			this.addCNature();
		}
		final ITranslationUnit tu = (ITranslationUnit) this.coreModel
				.create(myfile);
		if (tu == null) {
			throw new DiscoveryException("translation unit is null!");
		}
		return tu;
	}

	private ICProjectDescription addCNature() throws DiscoveryException {
		try {
			this.hasCNature = false;
			System.out.println("creating a project description!");
			final CCorePlugin cdtCorePlugin = CCorePlugin.getDefault();

			cdtCorePlugin.convertProjectToCC(this.project, this.monitor,
					ParserUtils.NATURE_ID);

			final ICProjectDescription cDesc = this.coreModel
					.createProjectDescription(this.project, true, true);
			return cDesc;
		} catch (final CoreException ex) {
			throw new DiscoveryException(ex);
		}
	}

	public void cleanUp() {
		if (this.hasCNature) {
			return;
		}
		try {
			// TODO: does not work yet!
			this.removeCNatureFromProject();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private void removeCNatureFromProject() throws Exception {
		CProjectNature.removeNature(this.project, ParserUtils.NATURE_ID,
				this.monitor);
		this.project.refreshLocal(0, this.monitor);
		final IResource res = this.project.findMember(".cproject");
		if (res != null) {
			res.delete(true, this.monitor);
		}
		System.out.println("C-nature removed from this project!");
	}
}
