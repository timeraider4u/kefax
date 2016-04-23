package at.jku.weiner.kefax.main.work;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Macro;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;
import at.jku.weiner.log.MyLog;

public class CmdArgs {
	
	private final String path;
	private final CmdLine line;
	
	private final StringBuffer additionalDirectives;
	private final StringBuffer useIncludeDirs;
	
	private boolean noStdInclude = false;
	
	private String inFile = null;
	private final IProject linux;
	
	public CmdArgs(final String path, final CmdLine line, final IProject linux) {
		this.path = path;
		this.line = line;
		this.linux = linux;
		this.additionalDirectives = new StringBuffer("");
		this.useIncludeDirs = new StringBuffer("");
		this.addUseIncDir(null, false);
		this.visit(this.line.getArguments());
	}
	
	private final void visit(final EList<Argument> list) {
		if ((list == null) || list.isEmpty()) {
			this.error("list of arguments should contain entries, cmdPath='"
					+ this.path + "'");
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
			this.visitForUseIncDir(arg.getUseIncDir());
		}
		if (incSys) {
			this.visitForUseIncDir(arg.getUseIncDir());
		}
		if (isNoStdInc) {
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
		} else {
			this.visitFor((FunctionMacro) macro);
		}
	}
	
	private final void visitFor(final SimpleMacro macro) {
		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append(" 1");
		this.additionalDirectives.append(System.lineSeparator());
	}
	
	private final void visitFor(final ObjectMacro macro) {
		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append(" ");
		this.additionalDirectives.append(macro.getValue());
		this.additionalDirectives.append(System.lineSeparator());
	}
	
	private final void visitFor(final FunctionMacro macro) {
		this.additionalDirectives.append("#define ");
		this.additionalDirectives.append(macro.getName());
		this.additionalDirectives.append("(");
		final EList<String> params = macro.getParams();
		boolean isFirst = true;
		for (int i = 0; i < params.size(); i++) {
			if (!isFirst) {
				this.additionalDirectives.append(",");
			}
			final String param = params.get(i);
			this.additionalDirectives.append(param);
			isFirst = false;
		}
		this.additionalDirectives.append(")");
		this.additionalDirectives.append(" ");
		this.additionalDirectives.append(macro.getValue());
		this.additionalDirectives.append(System.lineSeparator());
	}
	
	private final void visitForUseIncDir(final PathCmd pathCmd) {
		final String str = pathCmd.getPath();
		this.addUseIncDir(str, true);
	}
	
	private final void addUseIncDir(final String str, final boolean useAbsPath) {
		final String absPath = this.getPathFor(str, useAbsPath);
		this.useIncludeDirs.append(absPath);
		this.useIncludeDirs.append(File.pathSeparator);
	}
	
	private final String getPathFor(final String str, final boolean useAbsPath) {
		if (useAbsPath) {
			final String absPath = this.getAbsolutePath(str);
			return absPath;
		}
		return this.getLinuxAbsolutePath();
	}
	
	private final void visitForInclude(final PathCmd pathCmd) {
		String str = pathCmd.getPath();
		if (str.startsWith("./")) {
			str = str.substring(2);
		}
		// final String absPath = this.getAbsolutePath(str);
		this.additionalDirectives.append("#include <");
		this.additionalDirectives.append(str);
		this.additionalDirectives.append(">");
		this.additionalDirectives.append(System.lineSeparator());
	}
	
	private final void visitForInFile(final String inFile) {
		this.inFile = inFile;
	}
	
	private final void error(final String text) {
		System.err.println("at.jku.weiner.kefax.main: text='" + text + "'");
		throw new RuntimeException(text);
	}
	
	private final String getAbsolutePath(String result) {
		final URI uri = URI.createFileURI(result);
		if (uri.isRelative()) {
			final IResource res = this.linux.findMember(result);
			final String newStr = res.getLocationURI().toString();
			result = newStr.replace("file:", "");
		}
		return result;
	}
	
	private final String getLinuxAbsolutePath() {
		final IResource res = this.linux;
		final String newStr = res.getLocationURI().toString();
		final String result = newStr.replace("file:", "");
		
		return result;
	}
	
	public String getAdditionalDirectivesAsString() {
		return this.additionalDirectives.toString();
	}
	
	public String getIncludeDirectoriesAsString() {
		return this.useIncludeDirs.toString();
	}
	
	public boolean isNoStandardInclude() {
		return this.noStdInclude;
	}
	
	public String getInFile() {
		return this.inFile;
	}
	
}
