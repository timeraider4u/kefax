/*
 * generated by Xtext 2.9.0-SNAPSHOT
 */
package at.jku.weiner.c.common.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import at.jku.weiner.c.common.services.CommonGrammarAccess;

public class CommonParser extends AbstractContentAssistParser {
	
	@Inject
	private CommonGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected at.jku.weiner.c.common.ui.contentassist.antlr.internal.InternalCommonParser createParser() {
		at.jku.weiner.c.common.ui.contentassist.antlr.internal.InternalCommonParser result = new at.jku.weiner.c.common.ui.contentassist.antlr.internal.InternalCommonParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getEqualityExpressionAccess().getAlternatives_2_0(), "rule__EqualityExpression__Alternatives_2_0");
					put(grammarAccess.getRelationalExpressionAccess().getAlternatives_2_0(), "rule__RelationalExpression__Alternatives_2_0");
					put(grammarAccess.getShiftExpressionAccess().getAlternatives_2_0(), "rule__ShiftExpression__Alternatives_2_0");
					put(grammarAccess.getAdditiveExpressionAccess().getAlternatives_2_0(), "rule__AdditiveExpression__Alternatives_2_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getAlternatives_2_0(), "rule__MultiplicativeExpression__Alternatives_2_0");
					put(grammarAccess.getUnaryExpressionAccess().getAlternatives_1(), "rule__UnaryExpression__Alternatives_1");
					put(grammarAccess.getUnaryOperatorAccess().getAlternatives(), "rule__UnaryOperator__Alternatives");
					put(grammarAccess.getPrimaryExpressionAccess().getAlternatives_1(), "rule__PrimaryExpression__Alternatives_1");
					put(grammarAccess.getConstant1Access().getAlternatives(), "rule__Constant1__Alternatives");
					put(grammarAccess.getConstant2Access().getAlternatives_1(), "rule__Constant2__Alternatives_1");
					put(grammarAccess.getSpecialKeywordsAccess().getAlternatives(), "rule__SpecialKeywords__Alternatives");
					put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
					put(grammarAccess.getConstantExpressionAccess().getGroup(), "rule__ConstantExpression__Group__0");
					put(grammarAccess.getConditionalExpressionAccess().getGroup(), "rule__ConditionalExpression__Group__0");
					put(grammarAccess.getConditionalExpressionAccess().getGroup_2(), "rule__ConditionalExpression__Group_2__0");
					put(grammarAccess.getLogicalOrExpressionAccess().getGroup(), "rule__LogicalOrExpression__Group__0");
					put(grammarAccess.getLogicalOrExpressionAccess().getGroup_2(), "rule__LogicalOrExpression__Group_2__0");
					put(grammarAccess.getLogicalAndExpressionAccess().getGroup(), "rule__LogicalAndExpression__Group__0");
					put(grammarAccess.getLogicalAndExpressionAccess().getGroup_2(), "rule__LogicalAndExpression__Group_2__0");
					put(grammarAccess.getInclusiveOrExpressionAccess().getGroup(), "rule__InclusiveOrExpression__Group__0");
					put(grammarAccess.getInclusiveOrExpressionAccess().getGroup_2(), "rule__InclusiveOrExpression__Group_2__0");
					put(grammarAccess.getExclusiveOrExpressionAccess().getGroup(), "rule__ExclusiveOrExpression__Group__0");
					put(grammarAccess.getExclusiveOrExpressionAccess().getGroup_2(), "rule__ExclusiveOrExpression__Group_2__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_2(), "rule__AndExpression__Group_2__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup(), "rule__EqualityExpression__Group__0");
					put(grammarAccess.getEqualityExpressionAccess().getGroup_2(), "rule__EqualityExpression__Group_2__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup(), "rule__RelationalExpression__Group__0");
					put(grammarAccess.getRelationalExpressionAccess().getGroup_2(), "rule__RelationalExpression__Group_2__0");
					put(grammarAccess.getShiftExpressionAccess().getGroup(), "rule__ShiftExpression__Group__0");
					put(grammarAccess.getShiftExpressionAccess().getGroup_2(), "rule__ShiftExpression__Group_2__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup(), "rule__AdditiveExpression__Group__0");
					put(grammarAccess.getAdditiveExpressionAccess().getGroup_2(), "rule__AdditiveExpression__Group_2__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup(), "rule__MultiplicativeExpression__Group__0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getGroup_2(), "rule__MultiplicativeExpression__Group_2__0");
					put(grammarAccess.getCastExpressionAccess().getGroup(), "rule__CastExpression__Group__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup(), "rule__UnaryExpression__Group__0");
					put(grammarAccess.getUnaryExpressionAccess().getGroup_1_1(), "rule__UnaryExpression__Group_1_1__0");
					put(grammarAccess.getUnaryOperatorAccess().getGroup_0(), "rule__UnaryOperator__Group_0__0");
					put(grammarAccess.getPostfixExpressionAccess().getGroup(), "rule__PostfixExpression__Group__0");
					put(grammarAccess.getPostfixExpressionAccess().getGroup_1(), "rule__PostfixExpression__Group_1__0");
					put(grammarAccess.getPostfixExpressionSuffixArgumentAccess().getGroup(), "rule__PostfixExpressionSuffixArgument__Group__0");
					put(grammarAccess.getArgumentExpressionListAccess().getGroup(), "rule__ArgumentExpressionList__Group__0");
					put(grammarAccess.getArgumentExpressionListAccess().getGroup_1(), "rule__ArgumentExpressionList__Group_1__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup(), "rule__PrimaryExpression__Group__0");
					put(grammarAccess.getPrimaryExpressionAccess().getGroup_1_2(), "rule__PrimaryExpression__Group_1_2__0");
					put(grammarAccess.getConstant2Access().getGroup(), "rule__Constant2__Group__0");
					put(grammarAccess.getExpressionAccess().getExpressionAssignment_1(), "rule__Expression__ExpressionAssignment_1");
					put(grammarAccess.getConstantExpressionAccess().getExprAssignment_1(), "rule__ConstantExpression__ExprAssignment_1");
					put(grammarAccess.getConditionalExpressionAccess().getExprAssignment_1(), "rule__ConditionalExpression__ExprAssignment_1");
					put(grammarAccess.getConditionalExpressionAccess().getQExprAssignment_2_1(), "rule__ConditionalExpression__QExprAssignment_2_1");
					put(grammarAccess.getConditionalExpressionAccess().getCExprAssignment_2_3(), "rule__ConditionalExpression__CExprAssignment_2_3");
					put(grammarAccess.getLogicalOrExpressionAccess().getExprAssignment_1(), "rule__LogicalOrExpression__ExprAssignment_1");
					put(grammarAccess.getLogicalOrExpressionAccess().getExprAssignment_2_1(), "rule__LogicalOrExpression__ExprAssignment_2_1");
					put(grammarAccess.getLogicalAndExpressionAccess().getExprAssignment_1(), "rule__LogicalAndExpression__ExprAssignment_1");
					put(grammarAccess.getLogicalAndExpressionAccess().getExprAssignment_2_1(), "rule__LogicalAndExpression__ExprAssignment_2_1");
					put(grammarAccess.getInclusiveOrExpressionAccess().getExprAssignment_1(), "rule__InclusiveOrExpression__ExprAssignment_1");
					put(grammarAccess.getInclusiveOrExpressionAccess().getExprAssignment_2_1(), "rule__InclusiveOrExpression__ExprAssignment_2_1");
					put(grammarAccess.getExclusiveOrExpressionAccess().getExprAssignment_1(), "rule__ExclusiveOrExpression__ExprAssignment_1");
					put(grammarAccess.getExclusiveOrExpressionAccess().getExprAssignment_2_1(), "rule__ExclusiveOrExpression__ExprAssignment_2_1");
					put(grammarAccess.getAndExpressionAccess().getExprAssignment_1(), "rule__AndExpression__ExprAssignment_1");
					put(grammarAccess.getAndExpressionAccess().getExprAssignment_2_1(), "rule__AndExpression__ExprAssignment_2_1");
					put(grammarAccess.getEqualityExpressionAccess().getExprAssignment_1(), "rule__EqualityExpression__ExprAssignment_1");
					put(grammarAccess.getEqualityExpressionAccess().getOpAssignment_2_0_0(), "rule__EqualityExpression__OpAssignment_2_0_0");
					put(grammarAccess.getEqualityExpressionAccess().getOpAssignment_2_0_1(), "rule__EqualityExpression__OpAssignment_2_0_1");
					put(grammarAccess.getEqualityExpressionAccess().getExprAssignment_2_1(), "rule__EqualityExpression__ExprAssignment_2_1");
					put(grammarAccess.getRelationalExpressionAccess().getExprAssignment_1(), "rule__RelationalExpression__ExprAssignment_1");
					put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_2_0_0(), "rule__RelationalExpression__OpAssignment_2_0_0");
					put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_2_0_1(), "rule__RelationalExpression__OpAssignment_2_0_1");
					put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_2_0_2(), "rule__RelationalExpression__OpAssignment_2_0_2");
					put(grammarAccess.getRelationalExpressionAccess().getOpAssignment_2_0_3(), "rule__RelationalExpression__OpAssignment_2_0_3");
					put(grammarAccess.getRelationalExpressionAccess().getExprAssignment_2_1(), "rule__RelationalExpression__ExprAssignment_2_1");
					put(grammarAccess.getShiftExpressionAccess().getExprAssignment_1(), "rule__ShiftExpression__ExprAssignment_1");
					put(grammarAccess.getShiftExpressionAccess().getOpAssignment_2_0_0(), "rule__ShiftExpression__OpAssignment_2_0_0");
					put(grammarAccess.getShiftExpressionAccess().getOpAssignment_2_0_1(), "rule__ShiftExpression__OpAssignment_2_0_1");
					put(grammarAccess.getShiftExpressionAccess().getExprAssignment_2_1(), "rule__ShiftExpression__ExprAssignment_2_1");
					put(grammarAccess.getAdditiveExpressionAccess().getExprAssignment_1(), "rule__AdditiveExpression__ExprAssignment_1");
					put(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_2_0_0(), "rule__AdditiveExpression__OpAssignment_2_0_0");
					put(grammarAccess.getAdditiveExpressionAccess().getOpAssignment_2_0_1(), "rule__AdditiveExpression__OpAssignment_2_0_1");
					put(grammarAccess.getAdditiveExpressionAccess().getExprAssignment_2_1(), "rule__AdditiveExpression__ExprAssignment_2_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getExprAssignment_1(), "rule__MultiplicativeExpression__ExprAssignment_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_2_0_0(), "rule__MultiplicativeExpression__OpAssignment_2_0_0");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_2_0_1(), "rule__MultiplicativeExpression__OpAssignment_2_0_1");
					put(grammarAccess.getMultiplicativeExpressionAccess().getOpAssignment_2_0_2(), "rule__MultiplicativeExpression__OpAssignment_2_0_2");
					put(grammarAccess.getMultiplicativeExpressionAccess().getExprAssignment_2_1(), "rule__MultiplicativeExpression__ExprAssignment_2_1");
					put(grammarAccess.getCastExpressionAccess().getExprAssignment_1(), "rule__CastExpression__ExprAssignment_1");
					put(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1_0(), "rule__UnaryExpression__ExprAssignment_1_0");
					put(grammarAccess.getUnaryExpressionAccess().getOpAssignment_1_1_0(), "rule__UnaryExpression__OpAssignment_1_1_0");
					put(grammarAccess.getUnaryExpressionAccess().getExprAssignment_1_1_1(), "rule__UnaryExpression__ExprAssignment_1_1_1");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_0_1(), "rule__UnaryOperator__OpAssignment_0_1");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_1(), "rule__UnaryOperator__OpAssignment_1");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_2(), "rule__UnaryOperator__OpAssignment_2");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_3(), "rule__UnaryOperator__OpAssignment_3");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_4(), "rule__UnaryOperator__OpAssignment_4");
					put(grammarAccess.getUnaryOperatorAccess().getOpAssignment_5(), "rule__UnaryOperator__OpAssignment_5");
					put(grammarAccess.getPostfixExpressionAccess().getExprAssignment_1_0(), "rule__PostfixExpression__ExprAssignment_1_0");
					put(grammarAccess.getPostfixExpressionAccess().getSuffixAssignment_1_1(), "rule__PostfixExpression__SuffixAssignment_1_1");
					put(grammarAccess.getPostfixExpressionSuffixArgumentAccess().getArgumentExpressionListAssignment_2(), "rule__PostfixExpressionSuffixArgument__ArgumentExpressionListAssignment_2");
					put(grammarAccess.getArgumentExpressionListAccess().getExprAssignment_0(), "rule__ArgumentExpressionList__ExprAssignment_0");
					put(grammarAccess.getArgumentExpressionListAccess().getExprAssignment_1_1(), "rule__ArgumentExpressionList__ExprAssignment_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getConstAssignment_1_0(), "rule__PrimaryExpression__ConstAssignment_1_0");
					put(grammarAccess.getPrimaryExpressionAccess().getIdAssignment_1_1(), "rule__PrimaryExpression__IdAssignment_1_1");
					put(grammarAccess.getPrimaryExpressionAccess().getExprAssignment_1_2_1(), "rule__PrimaryExpression__ExprAssignment_1_2_1");
					put(grammarAccess.getConstant2Access().getHexAssignment_1_0(), "rule__Constant2__HexAssignment_1_0");
					put(grammarAccess.getConstant2Access().getOctAssignment_1_1(), "rule__Constant2__OctAssignment_1_1");
					put(grammarAccess.getConstant2Access().getDecAssignment_1_2(), "rule__Constant2__DecAssignment_1_2");
					put(grammarAccess.getConstant2Access().getChAssignment_1_3(), "rule__Constant2__ChAssignment_1_3");
					put(grammarAccess.getConstant2Access().getStrAssignment_1_4(), "rule__Constant2__StrAssignment_1_4");
					put(grammarAccess.getConstant2Access().getFloatAssignment_1_5(), "rule__Constant2__FloatAssignment_1_5");
					put(grammarAccess.getConstant2Access().getBinAssignment_1_6(), "rule__Constant2__BinAssignment_1_6");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			at.jku.weiner.c.common.ui.contentassist.antlr.internal.InternalCommonParser typedParser = (at.jku.weiner.c.common.ui.contentassist.antlr.internal.InternalCommonParser) parser;
			typedParser.entryRuleExpression();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] {  };
	}
	
	public CommonGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CommonGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
