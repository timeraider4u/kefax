package at.jku.isse.ecco.kefax.main.startup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import at.jku.weiner.c.cmdarguments.cmdArgs.Argument;
import at.jku.weiner.c.cmdarguments.cmdArgs.CmdLine;
import at.jku.weiner.c.cmdarguments.cmdArgs.FunctionMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.Macro;
import at.jku.weiner.c.cmdarguments.cmdArgs.ObjectMacro;
import at.jku.weiner.c.cmdarguments.cmdArgs.PathCmd;
import at.jku.weiner.c.cmdarguments.cmdArgs.SimpleMacro;

public class CmdArgs {

	private final String path;
	private final CmdLine line;

	private final StringBuffer additionalDirectives;
	private final List<String> useIncludeDirs;

	// private String outputFile = null;
	
	public CmdArgs(final String path, final CmdLine line) {
		this.path = path;
		this.line = line;
		this.additionalDirectives = new StringBuffer("");
		this.useIncludeDirs = new ArrayList<String>();
		this.visit(this.line.getArguments());
	}
	
	private final void visit(final EList<Argument> list) {
		if ((list == null) || list.isEmpty()) {
			this.error("list of arguments should contain entries, cmdPath='"
					+ this.path + "'");
		}
		for (int i = 0; i < list.size(); i++) {
			final Argument arg = list.get(i);
			// System.out.println("argument='" + arg + "'");
			this.visit(arg);
		}
	}
	
	private final void visit(final Argument arg) {
		final Macro macro = arg.getMacro();
		final boolean incDir = arg.isIncDir();
		final boolean incSys = arg.isIncSys();
		if (macro != null) {
			this.visit(macro);
		}
		if (incDir) {
			this.visitForUseIncDir(arg.getUseIncDir());
		}
		if (incSys) {
			this.visitForUseIncDir(arg.getUseIncDir());
		}
	}

	private final void visit(final Macro macro) {
		// System.out.println("visitMacro='" + macro + "'");
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
		this.useIncludeDirs.add(str);
	}

	private final void error(final String text) {
		System.err.println("at.jku.weiner.kefax.main: text='" + text + "'");
		throw new RuntimeException(text);
	}
	
	public String getAdditionalDirectivesAsString() {
		return this.additionalDirectives.toString();
	}

	public String getIncludeDirectoriesAsString() {
		final StringBuffer result = new StringBuffer("");
		for (final String str : this.useIncludeDirs) {
			result.append(str);
			result.append(File.pathSeparator);
		}
		return result.toString();
	}
	
	// private boolean isStandardInclude(final Model model) {
	// // TODO Auto-generated method stub
	// return false;
	// }
}
