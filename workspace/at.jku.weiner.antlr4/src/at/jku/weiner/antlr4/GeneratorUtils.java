package at.jku.weiner.antlr4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.Bundle;

import at.jku.weiner.log.MyLog;

public final class GeneratorUtils {
	private static final String JAVA_PARAM_VISITOR = "-visitor";
	private static final String JAVA_PARAM_LISTENER = "-listener";
	private static final String JAVA_PARAM_ENCODING = "-encoding";
	private static final String JAVA_PARAM_OUT = "-o";
	private static final String JAVA_PARAM_PKG = "-package";
	private static final String JAVA_PARAM_CP = "-cp";
	private static final String JAVA_EXE_NAME = "java";
	protected static final String ENCODING = "UTF-8";
	private static final String TOOL_NAME = "org.antlr.v4.Tool";
	public static final String LIB_DIR = "lib";
	public static final String LIB_FILE = "antlr-4.4-complete.jar";
	
	private GeneratorUtils() {

	}

	public static IResource getIResourceFor(final ExecutionEvent event)
			throws Exception {
		final IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		final ISelectionService service = window.getSelectionService();
		final ISelection selected = service.getSelection();
		final IResource result = GeneratorUtils.getIResourceFor(selected);
		return result;
	}

	public static IResource getIResourceFor(final ISelection selection)
			throws Exception {
		if ((selection == null) || !(selection instanceof IStructuredSelection)) {
			throw new IllegalArgumentException(
					"expected IStructuredSelection, but got='" + selection
							+ "'");
		}
		final IStructuredSelection structured = (IStructuredSelection) selection;
		// check if it is an IResource
		final Object selected = structured.getFirstElement();
		if ((selected == null) || !(selected instanceof IResource)) {
			throw new IllegalArgumentException(
					"expected IResource as selected, but got='" + selected
							+ "'");
		}
		// get the selected resource
		final IResource res = (IResource) selected;
		return res;
	}

	public static IProject reCreateProject(final String projectName,
			final IProgressMonitor monitor) throws Exception {
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final IProject project = root.getProject(projectName);
		if (project.exists()) {
			project.delete(true, monitor);
		}
		project.create(monitor);
		project.open(monitor);
		return project;
	}

	public static void reCreateFolder(final IFolder folder,
			final IProgressMonitor monitor) throws Exception {
		if (folder.exists()) {
			MyLog.debug(Antlr4Action.class, "delete folder='" + folder + "'");
			folder.delete(true, monitor);
		}
		MyLog.debug(Antlr4Action.class, "create folder='" + folder + "'");
		folder.create(true, true, monitor);
	}

	public static IFolder createSrcGenFolder(final IProject project,
			final String srcGenFileName, final String packageName,
			final IProgressMonitor monitor) throws Exception {
		final IFolder srcGenFolder = project.getFolder(srcGenFileName);
		GeneratorUtils.reCreateFolder(srcGenFolder, monitor);

		IFolder folder = srcGenFolder;
		final String[] segments = packageName.split("[\\.]");
		for (int i = 0; i < segments.length; i++) {
			final String segment = segments[i];
			folder = folder.getFolder(segment);
			GeneratorUtils.reCreateFolder(folder, monitor);
		}
		return folder;
	}
	
	public static InputStream convertStringToStream(final String content) {
		final byte[] bytes = content.getBytes();
		final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		return in;
	}
	
	public static String getAbsoluteFileNameFor(final Bundle bundle,
			final String fileName) throws Exception {
		final URL url = bundle.getEntry(fileName);
		final URL fileURL = FileLocator.toFileURL(url);
		final String result = fileURL.getFile();
		return result;
	}
	
	public static String getAbsoluteFileNameFor(final IResource res) {
		final IPath path = res.getLocation();
		final String result = path.toOSString();
		return result;
	}

	public static String getRelativePathFor(final IResource res) {
		final IPath path = res.getFullPath();
		final String result = path.toOSString();
		return result;
	}
	
	public static String getSrcLibFileName() throws Exception {
		final Bundle bundle = Activator.getContext().getBundle();
		final String result = GeneratorUtils.getAbsoluteFileNameFor(bundle,
				GeneratorUtils.LIB_DIR + "/" + GeneratorUtils.LIB_FILE);
		return result;
	}
	
	public static int runAntlr4Tool(final String packageName,
			final String antlrG4FileName, final String genFolderName)
			throws Exception {
		MyLog.log(GeneratorUtils.class, GeneratorUtils.class.getCanonicalName()
				+ ": execute on path='" + antlrG4FileName + "' with out='"
				+ genFolderName + "'");
		final String libFileName = GeneratorUtils.getSrcLibFileName();
		final ProcessBuilder builder = new ProcessBuilder(
				GeneratorUtils.JAVA_EXE_NAME, GeneratorUtils.JAVA_PARAM_CP,
				libFileName, GeneratorUtils.TOOL_NAME, antlrG4FileName,
				GeneratorUtils.JAVA_PARAM_LISTENER,
				GeneratorUtils.JAVA_PARAM_VISITOR,
				GeneratorUtils.JAVA_PARAM_ENCODING, GeneratorUtils.ENCODING,
				GeneratorUtils.JAVA_PARAM_PKG, packageName,
				GeneratorUtils.JAVA_PARAM_OUT, genFolderName);
		final Process process = builder.start();
		final InputStream stream = process.getErrorStream();
		final InputStreamReader reader = new InputStreamReader(stream);
		final BufferedReader in = new BufferedReader(reader);
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				MyLog.log(Antlr4Action.class, line);
			}
		} finally {
			in.close();
			reader.close();
			stream.close();
		}
		process.waitFor();
		final int retVal = process.exitValue();
		process.destroy();
		MyLog.log(Antlr4Action.class, "returnVal of org.antlr.v4.Tool='"
				+ retVal + "'");
		return retVal;
	}

	public static void addNature(final IProject project,
			final IProgressMonitor monitor, final String natureId)
			throws Exception {
		final IProjectDescription description = project.getDescription();
		final String[] naturesOrig = description.getNatureIds();
		final List<String> natures = new ArrayList<String>(
				Arrays.asList(naturesOrig));
		if (!natures.contains(natureId)) {
			natures.add(natureId);
		}
		description.setNatureIds(natures.toArray(new String[0]));
		project.setDescription(description, monitor);
	}

	public static IJavaProject addJavaNature(final IProject project,
			final IProgressMonitor monitor) throws Exception {
		GeneratorUtils.addNature(project, monitor, JavaCore.NATURE_ID);
		final IJavaProject javaProject = JavaCore.create(project);
		return javaProject;
	}

	public static IFile copyLibTo(final IProject project,
			final IProgressMonitor monitor) throws Exception {
		final String srcLibFileName = GeneratorUtils.getSrcLibFileName();
		final IFolder dstLibFolder = project.getFolder(GeneratorUtils.LIB_DIR);
		if (!dstLibFolder.exists()) {
			dstLibFolder.create(true, true, monitor);
		}
		final IFile dstLibFile = dstLibFolder.getFile(GeneratorUtils.LIB_FILE);
		if (dstLibFile.exists()) {
			dstLibFile.delete(true, monitor);
		}
		final String dstLibFileName = GeneratorUtils
				.getAbsoluteFileNameFor(dstLibFile);
		final File src = new File(srcLibFileName);
		final File dst = new File(dstLibFileName);
		FileUtils.copyFile(src, dst);
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		return dstLibFile;
	}
	
	public static void addClassPathEntry(final IJavaProject project,
			final IClasspathEntry entry, final IProgressMonitor monitor)
					throws Exception {
		final IClasspathEntry[] entries = project.getRawClasspath();
		final List<IClasspathEntry> list = Arrays.asList(entries);

		final ArrayList<IClasspathEntry> myList = new ArrayList<IClasspathEntry>();
		myList.addAll(list);
		if (!myList.contains(entry)) {
			myList.add(entry);
		}
		final IClasspathEntry[] temp = new IClasspathEntry[myList.size()];
		final IClasspathEntry[] result = myList.toArray(temp);
		project.setRawClasspath(result, monitor);
	}
	
	public static void addClassPathEntry(final IJavaProject project,
			final IResource res, final IProgressMonitor monitor)
					throws Exception {
		final IPath path = res.getFullPath();
		final IClasspathEntry entry = JavaCore.newSourceEntry(path);
		GeneratorUtils.addClassPathEntry(project, entry, monitor);
	}
	
	public static void removeClassPathEntry(final IJavaProject project,
			final IClasspathEntry entry, final IProgressMonitor monitor)
			throws Exception {
		final IClasspathEntry[] entries = project.getRawClasspath();
		final List<IClasspathEntry> list = Arrays.asList(entries);

		final ArrayList<IClasspathEntry> myList = new ArrayList<IClasspathEntry>();
		myList.addAll(list);
		if (myList.contains(entry)) {
			myList.remove(entry);
		}
		final IClasspathEntry[] temp = new IClasspathEntry[myList.size()];
		final IClasspathEntry[] result = myList.toArray(temp);
		project.setRawClasspath(result, monitor);
	}
	
	public static void removeClassPathEntry(final IJavaProject project,
			final IResource res, final IProgressMonitor monitor)
			throws Exception {
		final IPath path = res.getFullPath();
		final IClasspathEntry entry = JavaCore.newSourceEntry(path);
		GeneratorUtils.removeClassPathEntry(project, entry, monitor);
	}
	
}
