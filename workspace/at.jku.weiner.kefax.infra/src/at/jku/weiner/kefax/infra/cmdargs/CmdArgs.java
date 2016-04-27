package at.jku.weiner.kefax.infra.cmdargs;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.Assignment;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Macro;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.StringMacro;
import at.jku.weiner.kefax.shared.KefaxUtils;
import at.jku.weiner.kefax.shared.MySettings;
import at.jku.weiner.log.MyLog;

public class CmdArgs {
	private final StringBuffer cmdArgsAsStringBuffer;
	private final String id;
	private final CmdLine line;

	private final List<IPath> includeDirectoriesPaths;
	private final StringBuffer additionalDirectives;
	private final List<String> useIncludeDirs;

	private boolean noStdInclude = false;

	private final List<IPath> inFilePaths;
	private final IFile file;

	public CmdArgs(final IFile file, final CmdLine line) throws Exception {
		this.file = file;
		this.line = line;
		this.id = line.getStart();
		this.inFilePaths = new ArrayList<IPath>();
		this.cmdArgsAsStringBuffer = new StringBuffer(this.id);
		this.cmdArgsAsStringBuffer.append(" := ");
		this.additionalDirectives = new StringBuffer("");
		this.useIncludeDirs = new ArrayList<String>();
		this.includeDirectoriesPaths = new ArrayList<IPath>();
		this.addUseIncDir("");
		if ((line == null) || (!(line instanceof Assignment))) {
			final ParseException ex = new ParseException(
					"cannot parse target - not supported - cmdFile='" + file
							+ "'", 0);
			MyLog.error(CmdArgs.class, ex);
		}
		this.visit(this.line.getArguments());
		this.cmdArgsAsStringBuffer.append(System.lineSeparator());
	}

	private final void visit(final EList<Argument> list) throws Exception {
		if ((list == null) || list.isEmpty()) {
			final ParseException ex = new ParseException(
					"list of arguments should contain entries, cmdPath='"
							+ this.file + "'", 0);
			MyLog.error(CmdArgs.class, ex);
		}
		for (int i = 0; i < list.size(); i++) {
			final Argument arg = list.get(i);
			MyLog.trace(CmdArgs.class, "argument='" + arg + "'");
			this.visit(arg);
		}
	}

	private final void visit(final Argument arg) {
		final Macro macro = arg.getMacro();
		final boolean incDir = arg.isIncDir();
		final boolean incSys = arg.isIncSys();
		final boolean isNoStdInc = arg.isNostdinc();
		final PathCmd include = arg.getInclude();
		final String in = arg.getIn();

		if (macro != null) {
			this.visit(macro);
		}
		if (incDir) {
			this.visitForUseIncDir(arg.getUseIncDir(), incDir);
		}
		if (incSys) {
			this.visitForUseIncDir(arg.getUseIncDir(), incDir);
		}
		if (isNoStdInc) {
			this.cmdArgsAsStringBuffer.append(" -nostdinc");
			this.noStdInclude = isNoStdInc;
		}
		if (include != null) {
			this.visitForInclude(include);
		}
		if ((in != null) && !in.isEmpty()) {
			this.visitForInFile(in);
		}
	}

	private final void visit(final Macro macro) {
		MyLog.trace(CmdArgs.class, "visitMacro='" + macro + "'");
		if (macro instanceof SimpleMacro) {
			this.visitFor((SimpleMacro) macro);
		} else if (macro instanceof ObjectMacro) {
			this.visitFor((ObjectMacro) macro);
		} else if (macro instanceof FunctionMacro) {
			this.visitFor((FunctionMacro) macro);
		} else if (macro instanceof StringMacro) {
			this.visitFor((StringMacro) macro);
		}
	}

	private final void visitFor(final SimpleMacro macro) {
		this.cmdArgsAsStringBuffer.append(" -D");
		this.cmdArgsAsStringBuffer.append(macro.getName());

		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append(" 1");
		this.additionalDirectives.append(System.lineSeparator());
	}

	private final void visitFor(final ObjectMacro macro) {
		this.cmdArgsAsStringBuffer.append(" -D");
		this.cmdArgsAsStringBuffer.append("\"");
		this.cmdArgsAsStringBuffer.append(macro.getName());
		this.cmdArgsAsStringBuffer.append("=");
		this.cmdArgsAsStringBuffer.append(macro.getValue());
		this.cmdArgsAsStringBuffer.append("\"");

		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append(" ");
		this.additionalDirectives.append(macro.getValue());
		this.additionalDirectives.append(System.lineSeparator());
	}

	private final void visitFor(final FunctionMacro macro) {
		this.cmdArgsAsStringBuffer.append(" -D");
		this.cmdArgsAsStringBuffer.append("\"");
		this.cmdArgsAsStringBuffer.append(macro.getName());
		this.cmdArgsAsStringBuffer.append("(");

		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append("(");
		final EList<String> params = macro.getParams();
		boolean isFirst = true;
		for (int i = 0; i < params.size(); i++) {
			if (!isFirst) {
				this.cmdArgsAsStringBuffer.append(",");
				this.additionalDirectives.append(",");
			}
			final String param = params.get(i);
			this.additionalDirectives.append(param);
			this.cmdArgsAsStringBuffer.append(param);
			isFirst = false;
		}
		this.cmdArgsAsStringBuffer.append(")");
		this.cmdArgsAsStringBuffer.append("=");
		this.cmdArgsAsStringBuffer.append(macro.getValue());
		this.cmdArgsAsStringBuffer.append("\"");

		this.additionalDirectives.append(")");
		this.additionalDirectives.append(" ");
		final String value = macro.getValue();
		final String content = value.replace("\\#", "#");
		this.additionalDirectives.append(content);
		this.additionalDirectives.append(System.lineSeparator());
	}

	private void visitFor(final StringMacro macro) {
		final Macro inner = macro.getMacro();
		this.visit(inner);
	}

	private final void visitForUseIncDir(final PathCmd pathCmd,
			final boolean incDir) {
		if (incDir) {
			this.cmdArgsAsStringBuffer.append(" -I");
		} else {
			this.cmdArgsAsStringBuffer.append(" -isystem ");
		}

		final String str = pathCmd.getPath();
		this.cmdArgsAsStringBuffer.append(str);
		this.addUseIncDir(str);
	}

	private final void addUseIncDir(final String str) {
		MyLog.trace(CmdArgs.class, "addUseIncDir for str='" + str + "'");
		final URI uri = URI.createFileURI(str);
		if (uri.isRelative() && (!(str.isEmpty()))) {
			MyLog.trace(CmdArgs.class, "addUseIncDir for str(isRelative)='"
					+ str + "'");
			final IPath path = new Path(str);
			this.includeDirectoriesPaths.add(path);
			// this.useIncludeDirs.append(this.path);
			final IFolder dstSrcFolder = KefaxUtils.getLinuxDiscoverSrcFolder();
			final IFolder res = dstSrcFolder.getFolder(path);
			final String location = res.getLocation().toOSString();
			this.appendToUseIncDirs(location);
		} else if (str.isEmpty()) {
			final IFolder dstSrcFolder = KefaxUtils.getLinuxDiscoverSrcFolder();
			final String location = dstSrcFolder.getLocation().toOSString();
			this.appendToUseIncDirs(location);
		} else {
			this.appendToUseIncDirs(str);
		}
	}

	private void appendToUseIncDirs(final String string) {
		final int index = this.useIncludeDirs.lastIndexOf(string);
		if (index < 0) {
			this.useIncludeDirs.add(string);
		}
	}

	// private final String getPathFor(final String str, final boolean
	// useAbsPath) {
	// if (useAbsPath) {
	// final String absPath = this.getAbsolutePath(str);
	// return absPath;
	// }
	// return this.getLinuxAbsolutePath();
	// }

	private final void visitForInclude(final PathCmd pathCmd) {
		String str = pathCmd.getPath();
		this.cmdArgsAsStringBuffer.append(" -include ");
		this.cmdArgsAsStringBuffer.append(str);

		if (str.startsWith("./")) {
			str = str.substring(2);
		}
		this.additionalDirectives.append("#include <");
		this.additionalDirectives.append(str);
		this.additionalDirectives.append(">");
		this.additionalDirectives.append(System.lineSeparator());
	}

	private final void visitForInFile(final String inFileParam) {
		final IPath inPath = new Path(inFileParam);
		this.inFilePaths.add(inPath);
		this.cmdArgsAsStringBuffer.append(" ");
		this.cmdArgsAsStringBuffer.append(inFileParam);
	}

	// private final String getAbsolutePath(String result) {
	// final URI uri = URI.createFileURI(result);
	// if (uri.isRelative()) {
	// final IResource res = this.src.findMember(result);
	// final String newStr = res.getLocationURI().toString();
	// result = newStr.replace("file:", "");
	// }
	// return result;
	// }
	//
	// private final String getLinuxAbsolutePath() {
	// final IResource res = this.src;
	// final String newStr = res.getLocationURI().toString();
	// final String result = newStr.replace("file:", "");
	//
	// return result;
	// }

	public String getAdditionalDirectivesAsString() {
		return this.additionalDirectives.toString();
	}

	public String getIncludeDirectoriesAsString() {
		final StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < this.useIncludeDirs.size(); i++) {
			final String useIncDir = this.useIncludeDirs.get(i);
			buffer.append(useIncDir);
			buffer.append(File.pathSeparator);
		}
		return buffer.toString();
	}

	public List<IPath> getIncludeDirectoriesPathsAsList() {
		final List<IPath> list = Collections
				.unmodifiableList(this.includeDirectoriesPaths);
		return list;
	}

	public boolean isNoStandardInclude() {
		return this.noStdInclude;
	}

	public List<IPath> getInRealCFilePath() {
		final List<IPath> result = new ArrayList<IPath>();
		for (int i = 0; i < this.inFilePaths.size(); i++) {
			final IPath inFile = this.inFilePaths.get(i);
			final String inFileStr = inFile.toString();
			if (inFileStr.endsWith(MySettings.C_FILE_SUFFIX)
					|| inFileStr.endsWith(MySettings.HEADER_FILE_SUFFIX)) {
				result.add(inFile);
			}
		}
		return result;
	}

	public String getCmdLineAsString() {
		final String result = this.cmdArgsAsStringBuffer.toString();
		return result;
	}

}
