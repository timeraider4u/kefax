package at.jku.weiner.c.preprocess.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import at.jku.weiner.c.common.common.TranslationUnit;
import at.jku.weiner.c.preprocess.preprocess.Code;
import at.jku.weiner.c.preprocess.preprocess.ConditionalDirective;
import at.jku.weiner.c.preprocess.preprocess.ElIfConditional;
import at.jku.weiner.c.preprocess.preprocess.GroupOpt;
import at.jku.weiner.c.preprocess.preprocess.IfAbstractConditional;
import at.jku.weiner.c.preprocess.preprocess.IncludeDirective;
import at.jku.weiner.c.preprocess.preprocess.NewLineLine;
import at.jku.weiner.c.preprocess.preprocess.Preprocess;
import at.jku.weiner.c.preprocess.preprocess.PreprocessorDirectives;
import at.jku.weiner.c.preprocess.preprocess.SourceCodeLine;

public class Trimmer {
	
	public static void trimPreprocess(final Preprocess preprocess) {
		if (preprocess == null) {
			return;
		}
		MyLog.log("trimPreprocess");
		final GroupOpt group = preprocess.getGroup();
		Trimmer.trimGroup(group);
	}
	
	private static void trimGroup(final GroupOpt group) {
		if (group == null) {
			return;
		}
		final EList<SourceCodeLine> list = group.getLines();
		for (int i = 0; i < list.size(); i++) {
			final SourceCodeLine line = list.get(i);
			if ((line instanceof Code) || (line instanceof NewLineLine)) {
				list.remove(line);
				i--;
			} else if (line instanceof PreprocessorDirectives) {
				Trimmer.trimPreprocessorDirectives((PreprocessorDirectives) line);
			}
		}
	}
	
	private static void trimPreprocessorDirectives(
			final PreprocessorDirectives line) {
		final EObject obj = line.getDirective();
		if (obj == null) {
			return;
		} else if (obj instanceof IncludeDirective) {
			Trimmer.trimInclude((IncludeDirective) obj);
		} else if (obj instanceof ConditionalDirective) {
			Trimmer.trimConditional((ConditionalDirective) obj);
		}
	}
	
	private static void trimInclude(final IncludeDirective line) {
		final TranslationUnit unit = line.getUnit();
		if (unit == null) {
			return;
		}
		MyLog.log("TrimInclude='" + unit.getPath() + "'");
		final Preprocess preprocess = (Preprocess) unit.getPreprocess();
		Trimmer.trimPreprocess(preprocess);
	}

	private static void trimConditional(final ConditionalDirective conditional) {
		Trimmer.trimIfConditional(conditional.getConditional());
		final EList<ElIfConditional> elifs = conditional.getElifs();
		if (elifs != null) {
			for (int i = 0; i < elifs.size(); i++) {
				final ElIfConditional cond = elifs.get(i);
				Trimmer.trimIfConditional(cond);
			}
		}
		Trimmer.trimIfConditional(conditional.getElse());
	}
	
	private static void trimIfConditional(
			final IfAbstractConditional conditional) {
		if (conditional == null) {
			return;
		}
		final GroupOpt group = conditional.getGroup();
		Trimmer.trimGroup(group);
	}

}
