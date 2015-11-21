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
					put(grammarAccess.getGroupOptAccess().getAlternatives_1(), "rule__GroupOpt__Alternatives_1");
					put(grammarAccess.getPreprocessorDirectivesAccess().getAlternatives_4(), "rule__PreprocessorDirectives__Alternatives_4");
					put(grammarAccess.getDefineDirectiveAccess().getAlternatives(), "rule__DefineDirective__Alternatives");
					put(grammarAccess.getMyCodeAccess().getAlternatives(), "rule__MyCode__Alternatives");
					put(grammarAccess.getMyDefineLineAccess().getAlternatives(), "rule__MyDefineLine__Alternatives");
					put(grammarAccess.getMyCodeLineAccess().getAlternatives(), "rule__MyCodeLine__Alternatives");
					put(grammarAccess.getMyCodeLineExtendedAccess().getAlternatives_1_1(), "rule__MyCodeLineExtended__Alternatives_1_1");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getTranslationUnitAccess().getGroup(), "rule__TranslationUnit__Group__0");
					put(grammarAccess.getGroupOptAccess().getGroup(), "rule__GroupOpt__Group__0");
					put(grammarAccess.getPreprocessorDirectivesAccess().getGroup(), "rule__PreprocessorDirectives__Group__0");
					put(grammarAccess.getIncludeDirectiveAccess().getGroup(), "rule__IncludeDirective__Group__0");
					put(grammarAccess.getDefineObjectMacroAccess().getGroup(), "rule__DefineObjectMacro__Group__0");
					put(grammarAccess.getDefineObjectMacroAccess().getGroup_4(), "rule__DefineObjectMacro__Group_4__0");
					put(grammarAccess.getDefineFunctionLikeMacroAccess().getGroup(), "rule__DefineFunctionLikeMacro__Group__0");
					put(grammarAccess.getIdentifierListAccess().getGroup(), "rule__IdentifierList__Group__0");
					put(grammarAccess.getIdentifierListAccess().getGroup_2(), "rule__IdentifierList__Group_2__0");
					put(grammarAccess.getErrorDirectiveAccess().getGroup(), "rule__ErrorDirective__Group__0");
					put(grammarAccess.getUnDefineDirectiveAccess().getGroup(), "rule__UnDefineDirective__Group__0");
					put(grammarAccess.getPragmaDirectiveAccess().getGroup(), "rule__PragmaDirective__Group__0");
					put(grammarAccess.getNewLineLineAccess().getGroup(), "rule__NewLineLine__Group__0");
					put(grammarAccess.getCodeAccess().getGroup(), "rule__Code__Group__0");
					put(grammarAccess.getMyCodeLineExtendedAccess().getGroup(), "rule__MyCodeLineExtended__Group__0");
					put(grammarAccess.getMyCodeLineExtendedAccess().getGroup_1(), "rule__MyCodeLineExtended__Group_1__0");
					put(grammarAccess.getModelAccess().getUnitsAssignment_1(), "rule__Model__UnitsAssignment_1");
					put(grammarAccess.getTranslationUnitAccess().getGroupAssignment_1(), "rule__TranslationUnit__GroupAssignment_1");
					put(grammarAccess.getGroupOptAccess().getLinesAssignment_1_0(), "rule__GroupOpt__LinesAssignment_1_0");
					put(grammarAccess.getGroupOptAccess().getLinesAssignment_1_1(), "rule__GroupOpt__LinesAssignment_1_1");
					put(grammarAccess.getGroupOptAccess().getLinesAssignment_1_2(), "rule__GroupOpt__LinesAssignment_1_2");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_0(), "rule__PreprocessorDirectives__DirectiveAssignment_4_0");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_1(), "rule__PreprocessorDirectives__DirectiveAssignment_4_1");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_2(), "rule__PreprocessorDirectives__DirectiveAssignment_4_2");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_3(), "rule__PreprocessorDirectives__DirectiveAssignment_4_3");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_4(), "rule__PreprocessorDirectives__DirectiveAssignment_4_4");
					put(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveAssignment_4_5(), "rule__PreprocessorDirectives__DirectiveAssignment_4_5");
					put(grammarAccess.getIncludeDirectiveAccess().getStringAssignment_3(), "rule__IncludeDirective__StringAssignment_3");
					put(grammarAccess.getDefineObjectMacroAccess().getIdAssignment_3(), "rule__DefineObjectMacro__IdAssignment_3");
					put(grammarAccess.getDefineObjectMacroAccess().getStringAssignment_4_1(), "rule__DefineObjectMacro__StringAssignment_4_1");
					put(grammarAccess.getDefineFunctionLikeMacroAccess().getIdAssignment_3(), "rule__DefineFunctionLikeMacro__IdAssignment_3");
					put(grammarAccess.getDefineFunctionLikeMacroAccess().getListAssignment_5(), "rule__DefineFunctionLikeMacro__ListAssignment_5");
					put(grammarAccess.getDefineFunctionLikeMacroAccess().getStringAssignment_8(), "rule__DefineFunctionLikeMacro__StringAssignment_8");
					put(grammarAccess.getIdentifierListAccess().getIdAssignment_1(), "rule__IdentifierList__IdAssignment_1");
					put(grammarAccess.getIdentifierListAccess().getIdAssignment_2_2(), "rule__IdentifierList__IdAssignment_2_2");
					put(grammarAccess.getErrorDirectiveAccess().getMsgAssignment_3(), "rule__ErrorDirective__MsgAssignment_3");
					put(grammarAccess.getUnDefineDirectiveAccess().getIdAssignment_3(), "rule__UnDefineDirective__IdAssignment_3");
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
		return new String[] {  };
	}
	
	public CPreprocessGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CPreprocessGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
