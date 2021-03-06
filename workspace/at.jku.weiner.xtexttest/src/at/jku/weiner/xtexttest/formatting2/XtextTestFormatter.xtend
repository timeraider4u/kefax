/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.xtexttest.formatting2

import at.jku.weiner.xtexttest.services.XtextTestGrammarAccess
import at.jku.weiner.xtexttest.xtextTest.Element
import at.jku.weiner.xtexttest.xtextTest.Inner
import at.jku.weiner.xtexttest.xtextTest.XtextTest
import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

class XtextTestFormatter extends AbstractFormatter2 {
	
	@Inject extension XtextTestGrammarAccess

	def dispatch void format(XtextTest xtextTest, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		format(xtextTest.getInput(), document);
		format(xtextTest.getTokens(), document);
		format(xtextTest.getRoot(), document);
	}

	def dispatch void format(Element element, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Inner inner : element.getInner()) {
			format(inner, document);
		}
	}

	def dispatch void format(Inner inner, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		format(inner.getAssign(), document);
		for (Element assignList : inner.getAssignList()) {
			format(assignList, document);
		}
	}
}
