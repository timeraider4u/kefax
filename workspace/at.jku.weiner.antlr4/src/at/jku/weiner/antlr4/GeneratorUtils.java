package at.jku.weiner.antlr4;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;

import at.jku.weiner.log.MyLog;

public final class GeneratorUtils {

	private GeneratorUtils() {

	}

	public static IFolder createSrcGenFolder(final IProject project,
			final String srcGenFileName, final String packageName,
			final IProgressMonitor monitor) throws Exception {
		final IFolder srcGenFolder = project.getFolder(srcGenFileName);
		if (!srcGenFolder.exists()) {
			srcGenFolder.create(true, true, monitor);
		}
		IFolder folder = srcGenFolder;
		final String[] segments = packageName.split("[\\.]");
		for (int i = 0; i < segments.length; i++) {
			final String segment = segments[i];
			folder = folder.getFolder(segment);
			MyLog.log(Antlr4Action.class, "create folder='" + folder + "'");
			if (!folder.exists()) {
				folder.create(true, true, monitor);
			}
		}
		return folder;
	}

}
