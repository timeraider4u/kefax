package org.eclipse.modisco.kconfig.discoverer.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gmt.modisco.infra.common.core.logging.MoDiscoLogger;
import org.eclipse.modisco.infra.discovery.core.exception.DiscoveryException;
import org.eclipse.modisco.kconfig.KconfigFactory;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.discoverer.Activator;
import org.eclipse.modisco.kconfig.discoverer.parser.MyKConfigParser;

public class DiscovererUtils {

	/**
	 * get the Factory
	 *
	 * @return the Factory
	 */
	protected static KconfigFactory getEFactory() {
		return KconfigFactory.eINSTANCE;
	}

	protected static String getFileContent(final FileInputStream stream)
			throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				stream, "UTF-8"))) {
			final StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append('\n');
			}
			return sb.toString();
		}
	}

	protected static void discoverElement(final IResource resource,
			final Model model) throws DiscoveryException, CoreException {
		if (!AccessibilityUtils.isAccessible(resource)) {
			return;
		}
		if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			DiscovererUtils.discoverFile(file, model);
		} else if (resource instanceof IContainer) {
			final IContainer container = (IContainer) resource;
			DiscovererUtils.discoverDirectory(container, model);
		} else {
			// should never get here!
			throw new IllegalArgumentException(resource.getClass().getName()
					+ " not handled");
		}
	}

	/**
	 * Recursively discover all files contained in the given directory into the
	 * given model
	 *
	 * @throws DiscoveryException
	 * @throws CoreException
	 */
	private static void discoverDirectory(final IContainer container,
			final Model model) throws DiscoveryException, CoreException {
		final File directory = container.getLocation().toFile();
		System.out.println("discover dir=" + directory.getAbsolutePath());
		if (!directory.isDirectory()) {
			throw new IllegalArgumentException("not a directory"); //$NON-NLS-1$
		}
		final IResource[] resources = container.members();
		for (final IResource res : resources) {
			DiscovererUtils.discoverElement(res, model);
		}
	}

	private static void discoverFile(final IFile file, final Model model)
			throws DiscoveryException {

		final File myFile = file.getLocation().toFile();
		try {
			System.out.println("discover file=" + myFile.getAbsolutePath());
			final FileInputStream inputStream = new FileInputStream(myFile);
			DiscovererUtils.inspectUnit(file, model, inputStream);
		} catch (final Exception e) {
			throw new DiscoveryException("Discovery encountered an error on \"" //$NON-NLS-1$
					+ myFile.getAbsolutePath() + "\".", e); //$NON-NLS-1$
		}
	}

	private static void inspectUnit(final IFile file, final Model model,
			final FileInputStream inputStream) {
		final File myFile = file.getLocation().toFile();
		try {
			final KconfigFactory factory = DiscovererUtils.getEFactory();
			if (factory == null) {
				System.out.println("factory is null!");
				return;
			}
			final String content = DiscovererUtils.getFileContent(inputStream);
			final MyKConfigParser parser = new MyKConfigParser(file, model,
					factory, content);
			parser.parse();
		} catch (final Exception e) {
			e.printStackTrace();
			MoDiscoLogger.logError(e,
					"Discovery encountered an parse error on \"" //$NON-NLS-1$
							+ myFile.getAbsolutePath() + "\".", //$NON-NLS-1$
					Activator.getDefault());
		}
	}

}
