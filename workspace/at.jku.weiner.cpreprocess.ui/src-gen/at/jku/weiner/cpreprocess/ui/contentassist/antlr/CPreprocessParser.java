/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.cpreprocess.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import at.jku.weiner.cpreprocess.services.CPreprocessGrammarAccess;

public class CPreprocessParser extends AbstractContentAssistParser {
	
	@Inject
	private CPreprocessGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal.InternalCPreprocessParser createParser() {
		at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal.InternalCPreprocessParser result = new at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal.InternalCPreprocessParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTranslationUnitAccess().getAlternatives_1(), "rule__TranslationUnit__Alternatives_1");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getTranslationUnitAccess().getGroup(), "rule__TranslationUnit__Group__0");
					put(grammarAccess.getPreprocessorDirectivesAccess().getGroup(), "rule__PreprocessorDirectives__Group__0");
					put(grammarAccess.getIncludeDirectiveAccess().getGroup(), "rule__IncludeDirective__Group__0");
					put(grammarAccess.getNewLineLineAccess().getGroup(), "rule__NewLineLine__Group__0");
					put(grammarAccess.getCodeAccess().getGroup(), "rule__Code__Group__0");
					put(grammarAccess.getModelAccess().getUnitsAssignment_1(), "rule__Model__UnitsAssignment_1");
					put(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_0(), "rule__TranslationUnit__LinesAssignment_1_0");
					put(grammarAccess.getTranslationUnitAccess().getLinesAssignment_1_1(), "rule__TranslationUnit__LinesAssignment_1_1");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_2(), "rule__PreprocessorDirectives__DirectiveAssignment_2");
					put(grammarAccess.getIncludeDirectiveAccess().getStringAssignment_2(), "rule__IncludeDirective__StringAssignment_2");
					put(grammarAccess.getCodeAccess().getCodeAssignment_1(), "rule__Code__CodeAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal.InternalCPreprocessParser typedParser = (at.jku.weiner.cpreprocess.ui.contentassist.antlr.internal.InternalCPreprocessParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WHITESPACE" };
	}
	
	public CPreprocessGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CPreprocessGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
