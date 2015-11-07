/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.xtexttest.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import at.jku.weiner.xtexttest.services.XtextTestGrammarAccess;

public class XtextTestParser extends AbstractContentAssistParser {
	
	@Inject
	private XtextTestGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestParser createParser() {
		at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestParser result = new at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getInputAccess().getAlternatives_2(), "rule__Input__Alternatives_2");
					put(grammarAccess.getInnerAccess().getAlternatives_2(), "rule__Inner__Alternatives_2");
					put(grammarAccess.getGeneratorAccess().getAlternatives_2_2(), "rule__Generator__Alternatives_2_2");
					put(grammarAccess.getXtextTestAccess().getGroup(), "rule__XtextTest__Group__0");
					put(grammarAccess.getPackageIDAccess().getGroup(), "rule__PackageID__Group__0");
					put(grammarAccess.getPackageIDAccess().getGroup_1(), "rule__PackageID__Group_1__0");
					put(grammarAccess.getInputAccess().getGroup(), "rule__Input__Group__0");
					put(grammarAccess.getInputAccess().getGroup_2_0(), "rule__Input__Group_2_0__0");
					put(grammarAccess.getInputAccess().getGroup_2_1(), "rule__Input__Group_2_1__0");
					put(grammarAccess.getTokensAccess().getGroup(), "rule__Tokens__Group__0");
					put(grammarAccess.getElementAccess().getGroup(), "rule__Element__Group__0");
					put(grammarAccess.getElementAccess().getGroup_3(), "rule__Element__Group_3__0");
					put(grammarAccess.getElementAccess().getGroup_3_1(), "rule__Element__Group_3_1__0");
					put(grammarAccess.getInnerAccess().getGroup(), "rule__Inner__Group__0");
					put(grammarAccess.getInnerAccess().getGroup_2_0(), "rule__Inner__Group_2_0__0");
					put(grammarAccess.getInnerAccess().getGroup_2_1(), "rule__Inner__Group_2_1__0");
					put(grammarAccess.getInnerAccess().getGroup_2_1_2(), "rule__Inner__Group_2_1_2__0");
					put(grammarAccess.getInnerAccess().getGroup_2_2(), "rule__Inner__Group_2_2__0");
					put(grammarAccess.getInnerAccess().getGroup_2_3(), "rule__Inner__Group_2_3__0");
					put(grammarAccess.getGeneratorAccess().getGroup(), "rule__Generator__Group__0");
					put(grammarAccess.getGeneratorAccess().getGroup_1(), "rule__Generator__Group_1__0");
					put(grammarAccess.getGeneratorAccess().getGroup_2(), "rule__Generator__Group_2__0");
					put(grammarAccess.getGeneratorAccess().getGroup_2_2_0(), "rule__Generator__Group_2_2_0__0");
					put(grammarAccess.getXtextTestAccess().getPackageAssignment_2(), "rule__XtextTest__PackageAssignment_2");
					put(grammarAccess.getXtextTestAccess().getLangAssignment_4(), "rule__XtextTest__LangAssignment_4");
					put(grammarAccess.getXtextTestAccess().getInputAssignment_5(), "rule__XtextTest__InputAssignment_5");
					put(grammarAccess.getXtextTestAccess().getTokensAssignment_6(), "rule__XtextTest__TokensAssignment_6");
					put(grammarAccess.getXtextTestAccess().getRootAssignment_7(), "rule__XtextTest__RootAssignment_7");
					put(grammarAccess.getXtextTestAccess().getOutputAssignment_8(), "rule__XtextTest__OutputAssignment_8");
					put(grammarAccess.getInputAccess().getTextAssignment_2_0_2(), "rule__Input__TextAssignment_2_0_2");
					put(grammarAccess.getInputAccess().getFileAssignment_2_1_2(), "rule__Input__FileAssignment_2_1_2");
					put(grammarAccess.getTokensAccess().getTokensAssignment_2(), "rule__Tokens__TokensAssignment_2");
					put(grammarAccess.getElementAccess().getNameAssignment_2(), "rule__Element__NameAssignment_2");
					put(grammarAccess.getElementAccess().getInnerAssignment_3_0(), "rule__Element__InnerAssignment_3_0");
					put(grammarAccess.getElementAccess().getInnerAssignment_3_1_1(), "rule__Element__InnerAssignment_3_1_1");
					put(grammarAccess.getInnerAccess().getParameterAssignment_1(), "rule__Inner__ParameterAssignment_1");
					put(grammarAccess.getInnerAccess().getAssignAssignment_2_0_1(), "rule__Inner__AssignAssignment_2_0_1");
					put(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_1(), "rule__Inner__AssignListAssignment_2_1_1");
					put(grammarAccess.getInnerAccess().getAssignListAssignment_2_1_2_1(), "rule__Inner__AssignListAssignment_2_1_2_1");
					put(grammarAccess.getInnerAccess().getValueAssignment_2_2_1(), "rule__Inner__ValueAssignment_2_2_1");
					put(grammarAccess.getInnerAccess().getAssignAsDataAssignment_2_3_1(), "rule__Inner__AssignAsDataAssignment_2_3_1");
					put(grammarAccess.getGeneratorAccess().getOutputAssignment_1_3(), "rule__Generator__OutputAssignment_1_3");
					put(grammarAccess.getGeneratorAccess().getExpectedAssignment_2_2_0_1(), "rule__Generator__ExpectedAssignment_2_2_0_1");
					put(grammarAccess.getGeneratorAccess().getIsSameAsInputFileAssignment_2_2_1(), "rule__Generator__IsSameAsInputFileAssignment_2_2_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestParser typedParser = (at.jku.weiner.xtexttest.ui.contentassist.antlr.internal.InternalXtextTestParser) parser;
			typedParser.entryRuleXtextTest();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public XtextTestGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XtextTestGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
