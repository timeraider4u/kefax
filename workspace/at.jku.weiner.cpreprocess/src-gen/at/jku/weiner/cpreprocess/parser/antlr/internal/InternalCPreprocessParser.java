// $ANTLR 3.x InternalCPreprocess.g 2015-11-10 21:32:20

package at.jku.weiner.cpreprocess.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.weiner.cpreprocess.services.CPreprocessGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCPreprocessParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_BACKSLASH", "RULE_CARRIAGERETURN", 
		"RULE_DEFINE", "RULE_ERROR", "RULE_HASH", "RULE_ID", "RULE_IDENTIFIER", 
		"RULE_INCLUDE", "RULE_LETTER", "RULE_LINEBREAK", "RULE_LINEFEED", "RULE_MYCODE", 
		"RULE_NEWLINE", "RULE_NO_CODE_START", "RULE_PRAGMA", "RULE_UNDEF", "RULE_WS"
	};
	public static final int EOF=-1;
	public static final int RULE_BACKSLASH=4;
	public static final int RULE_CARRIAGERETURN=5;
	public static final int RULE_DEFINE=6;
	public static final int RULE_ERROR=7;
	public static final int RULE_HASH=8;
	public static final int RULE_ID=9;
	public static final int RULE_IDENTIFIER=10;
	public static final int RULE_INCLUDE=11;
	public static final int RULE_LETTER=12;
	public static final int RULE_LINEBREAK=13;
	public static final int RULE_LINEFEED=14;
	public static final int RULE_MYCODE=15;
	public static final int RULE_NEWLINE=16;
	public static final int RULE_NO_CODE_START=17;
	public static final int RULE_PRAGMA=18;
	public static final int RULE_UNDEF=19;
	public static final int RULE_WS=20;

	// delegates
	public AbstractInternalAntlrParser[] getDelegates() {
		return new AbstractInternalAntlrParser[] {};
	}

	// delegators


	public InternalCPreprocessParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalCPreprocessParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InternalCPreprocessParser.tokenNames; }
	@Override public String getGrammarFileName() { return "InternalCPreprocess.g"; }



	 	private CPreprocessGrammarAccess grammarAccess;
	 	
	    public InternalCPreprocessParser(TokenStream input, CPreprocessGrammarAccess grammarAccess) {
	        this(input);
	        this.grammarAccess = grammarAccess;
	        registerRules(grammarAccess.getGrammar());
	    }
	    
	    @Override
	    protected String getFirstRuleName() {
	    	return "Model";	
	   	}
	   	
	   	@Override
	   	protected CPreprocessGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}



	// $ANTLR start "entryRuleModel"
	// InternalCPreprocess.g:68:1: entryRuleModel returns [EObject current=null] :iv_ruleModel= ruleModel EOF ;
	public final EObject entryRuleModel() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleModel =null;

		try {
			// InternalCPreprocess.g:69:2: (iv_ruleModel= ruleModel EOF )
			// InternalCPreprocess.g:70:2: iv_ruleModel= ruleModel EOF
			{
			 newCompositeNode(grammarAccess.getModelRule()); 
			pushFollow(FOLLOW_ruleModel_in_entryRuleModel77);
			iv_ruleModel=ruleModel();
			state._fsp--;

			 current =iv_ruleModel; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleModel87); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleModel"



	// $ANTLR start "ruleModel"
	// InternalCPreprocess.g:77:1: ruleModel returns [EObject current=null] : ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) ;
	public final EObject ruleModel() throws RecognitionException {
		EObject current = null;


		EObject lv_units_1_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:83:7: ( ( () ( (lv_units_1_0= ruleTranslationUnit ) ) ) )
			// InternalCPreprocess.g:85:5: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
			{
			// InternalCPreprocess.g:85:5: ( () ( (lv_units_1_0= ruleTranslationUnit ) ) )
			// InternalCPreprocess.g:86:5: () ( (lv_units_1_0= ruleTranslationUnit ) )
			{
			// InternalCPreprocess.g:86:5: ()
			// InternalCPreprocess.g:87:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getModelAccess().getModelAction_0(),
			            current);
			    
			}

			// InternalCPreprocess.g:95:3: ( (lv_units_1_0= ruleTranslationUnit ) )
			// InternalCPreprocess.g:96:3: (lv_units_1_0= ruleTranslationUnit )
			{
			// InternalCPreprocess.g:96:3: (lv_units_1_0= ruleTranslationUnit )
			// InternalCPreprocess.g:97:3: lv_units_1_0= ruleTranslationUnit
			{
			 
				        newCompositeNode(grammarAccess.getModelAccess().getUnitsTranslationUnitParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_ruleTranslationUnit_in_ruleModel147);
			lv_units_1_0=ruleTranslationUnit();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getModelRule());
				        }
			       		add(
			       			current, 
			       			"units",
			        		lv_units_1_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.TranslationUnit");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleModel"



	// $ANTLR start "entryRuleTranslationUnit"
	// InternalCPreprocess.g:125:1: entryRuleTranslationUnit returns [EObject current=null] :iv_ruleTranslationUnit= ruleTranslationUnit EOF ;
	public final EObject entryRuleTranslationUnit() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleTranslationUnit =null;

		try {
			// InternalCPreprocess.g:126:2: (iv_ruleTranslationUnit= ruleTranslationUnit EOF )
			// InternalCPreprocess.g:127:2: iv_ruleTranslationUnit= ruleTranslationUnit EOF
			{
			 newCompositeNode(grammarAccess.getTranslationUnitRule()); 
			pushFollow(FOLLOW_ruleTranslationUnit_in_entryRuleTranslationUnit187);
			iv_ruleTranslationUnit=ruleTranslationUnit();
			state._fsp--;

			 current =iv_ruleTranslationUnit; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleTranslationUnit197); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleTranslationUnit"



	// $ANTLR start "ruleTranslationUnit"
	// InternalCPreprocess.g:134:1: ruleTranslationUnit returns [EObject current=null] : ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) ;
	public final EObject ruleTranslationUnit() throws RecognitionException {
		EObject current = null;


		EObject lv_lines_1_0 =null;
		EObject lv_lines_2_0 =null;
		EObject lv_lines_3_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:140:7: ( ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* ) )
			// InternalCPreprocess.g:142:5: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
			{
			// InternalCPreprocess.g:142:5: ( () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )* )
			// InternalCPreprocess.g:143:5: () ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
			{
			// InternalCPreprocess.g:143:5: ()
			// InternalCPreprocess.g:144:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getTranslationUnitAccess().getTranslationUnitAction_0(),
			            current);
			    
			}

			// InternalCPreprocess.g:152:3: ( ( (lv_lines_1_0= rulePreprocessorDirectives ) ) | ( (lv_lines_2_0= ruleNewLineLine ) ) | ( (lv_lines_3_0= ruleCode ) ) )*
			loop1:
			while (true) {
				int alt1=4;
				switch ( input.LA(1) ) {
				case RULE_DEFINE:
				case RULE_ERROR:
				case RULE_INCLUDE:
				case RULE_PRAGMA:
				case RULE_UNDEF:
					{
					alt1=1;
					}
					break;
				case RULE_NEWLINE:
					{
					alt1=2;
					}
					break;
				case RULE_ID:
				case RULE_MYCODE:
					{
					alt1=3;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// InternalCPreprocess.g:153:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
					{
					// InternalCPreprocess.g:153:3: ( (lv_lines_1_0= rulePreprocessorDirectives ) )
					// InternalCPreprocess.g:154:3: (lv_lines_1_0= rulePreprocessorDirectives )
					{
					// InternalCPreprocess.g:154:3: (lv_lines_1_0= rulePreprocessorDirectives )
					// InternalCPreprocess.g:155:3: lv_lines_1_0= rulePreprocessorDirectives
					{
					 
						        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesPreprocessorDirectivesParserRuleCall_1_0_0()); 
						    
					pushFollow(FOLLOW_rulePreprocessorDirectives_in_ruleTranslationUnit259);
					lv_lines_1_0=rulePreprocessorDirectives();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
						        }
					       		add(
					       			current, 
					       			"lines",
					        		lv_lines_1_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.PreprocessorDirectives");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 2 :
					// InternalCPreprocess.g:175:3: ( (lv_lines_2_0= ruleNewLineLine ) )
					{
					// InternalCPreprocess.g:175:3: ( (lv_lines_2_0= ruleNewLineLine ) )
					// InternalCPreprocess.g:176:3: (lv_lines_2_0= ruleNewLineLine )
					{
					// InternalCPreprocess.g:176:3: (lv_lines_2_0= ruleNewLineLine )
					// InternalCPreprocess.g:177:3: lv_lines_2_0= ruleNewLineLine
					{
					 
						        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesNewLineLineParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_ruleNewLineLine_in_ruleTranslationUnit289);
					lv_lines_2_0=ruleNewLineLine();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
						        }
					       		add(
					       			current, 
					       			"lines",
					        		lv_lines_2_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.NewLineLine");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 3 :
					// InternalCPreprocess.g:197:3: ( (lv_lines_3_0= ruleCode ) )
					{
					// InternalCPreprocess.g:197:3: ( (lv_lines_3_0= ruleCode ) )
					// InternalCPreprocess.g:198:3: (lv_lines_3_0= ruleCode )
					{
					// InternalCPreprocess.g:198:3: (lv_lines_3_0= ruleCode )
					// InternalCPreprocess.g:199:3: lv_lines_3_0= ruleCode
					{
					 
						        newCompositeNode(grammarAccess.getTranslationUnitAccess().getLinesCodeParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_ruleCode_in_ruleTranslationUnit319);
					lv_lines_3_0=ruleCode();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getTranslationUnitRule());
						        }
					       		add(
					       			current, 
					       			"lines",
					        		lv_lines_3_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.Code");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

				default :
					break loop1;
				}
			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleTranslationUnit"



	// $ANTLR start "entryRulePreprocessorDirectives"
	// InternalCPreprocess.g:229:1: entryRulePreprocessorDirectives returns [EObject current=null] :iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF ;
	public final EObject entryRulePreprocessorDirectives() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePreprocessorDirectives =null;

		try {
			// InternalCPreprocess.g:230:2: (iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF )
			// InternalCPreprocess.g:231:2: iv_rulePreprocessorDirectives= rulePreprocessorDirectives EOF
			{
			 newCompositeNode(grammarAccess.getPreprocessorDirectivesRule()); 
			pushFollow(FOLLOW_rulePreprocessorDirectives_in_entryRulePreprocessorDirectives363);
			iv_rulePreprocessorDirectives=rulePreprocessorDirectives();
			state._fsp--;

			 current =iv_rulePreprocessorDirectives; 
			match(input,EOF,FOLLOW_EOF_in_entryRulePreprocessorDirectives373); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRulePreprocessorDirectives"



	// $ANTLR start "rulePreprocessorDirectives"
	// InternalCPreprocess.g:238:1: rulePreprocessorDirectives returns [EObject current=null] : ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE ) ;
	public final EObject rulePreprocessorDirectives() throws RecognitionException {
		EObject current = null;


		Token this_NEWLINE_6=null;
		EObject lv_directive_1_0 =null;
		EObject lv_directive_2_0 =null;
		EObject lv_directive_3_0 =null;
		EObject lv_directive_4_0 =null;
		EObject lv_directive_5_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:244:7: ( ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE ) )
			// InternalCPreprocess.g:246:5: ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE )
			{
			// InternalCPreprocess.g:246:5: ( () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE )
			// InternalCPreprocess.g:247:5: () ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) ) this_NEWLINE_6= RULE_NEWLINE
			{
			// InternalCPreprocess.g:247:5: ()
			// InternalCPreprocess.g:248:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPreprocessorDirectivesAccess().getPreprocessorDirectivesAction_0(),
			            current);
			    
			}

			// InternalCPreprocess.g:256:3: ( ( (lv_directive_1_0= ruleIncludeDirective ) ) | ( (lv_directive_2_0= ruleDefineDirective ) ) | ( (lv_directive_3_0= ruleUnDefineDirective ) ) | ( (lv_directive_4_0= ruleErrorDirective ) ) | ( (lv_directive_5_0= rulePragmaDirective ) ) )
			int alt2=5;
			switch ( input.LA(1) ) {
			case RULE_INCLUDE:
				{
				alt2=1;
				}
				break;
			case RULE_DEFINE:
				{
				alt2=2;
				}
				break;
			case RULE_UNDEF:
				{
				alt2=3;
				}
				break;
			case RULE_ERROR:
				{
				alt2=4;
				}
				break;
			case RULE_PRAGMA:
				{
				alt2=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// InternalCPreprocess.g:257:3: ( (lv_directive_1_0= ruleIncludeDirective ) )
					{
					// InternalCPreprocess.g:257:3: ( (lv_directive_1_0= ruleIncludeDirective ) )
					// InternalCPreprocess.g:258:3: (lv_directive_1_0= ruleIncludeDirective )
					{
					// InternalCPreprocess.g:258:3: (lv_directive_1_0= ruleIncludeDirective )
					// InternalCPreprocess.g:259:3: lv_directive_1_0= ruleIncludeDirective
					{
					 
						        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveIncludeDirectiveParserRuleCall_1_0_0()); 
						    
					pushFollow(FOLLOW_ruleIncludeDirective_in_rulePreprocessorDirectives435);
					lv_directive_1_0=ruleIncludeDirective();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
						        }
					       		set(
					       			current, 
					       			"directive",
					        		lv_directive_1_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.IncludeDirective");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 2 :
					// InternalCPreprocess.g:279:3: ( (lv_directive_2_0= ruleDefineDirective ) )
					{
					// InternalCPreprocess.g:279:3: ( (lv_directive_2_0= ruleDefineDirective ) )
					// InternalCPreprocess.g:280:3: (lv_directive_2_0= ruleDefineDirective )
					{
					// InternalCPreprocess.g:280:3: (lv_directive_2_0= ruleDefineDirective )
					// InternalCPreprocess.g:281:3: lv_directive_2_0= ruleDefineDirective
					{
					 
						        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveDefineDirectiveParserRuleCall_1_1_0()); 
						    
					pushFollow(FOLLOW_ruleDefineDirective_in_rulePreprocessorDirectives465);
					lv_directive_2_0=ruleDefineDirective();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
						        }
					       		set(
					       			current, 
					       			"directive",
					        		lv_directive_2_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.DefineDirective");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 3 :
					// InternalCPreprocess.g:301:3: ( (lv_directive_3_0= ruleUnDefineDirective ) )
					{
					// InternalCPreprocess.g:301:3: ( (lv_directive_3_0= ruleUnDefineDirective ) )
					// InternalCPreprocess.g:302:3: (lv_directive_3_0= ruleUnDefineDirective )
					{
					// InternalCPreprocess.g:302:3: (lv_directive_3_0= ruleUnDefineDirective )
					// InternalCPreprocess.g:303:3: lv_directive_3_0= ruleUnDefineDirective
					{
					 
						        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveUnDefineDirectiveParserRuleCall_1_2_0()); 
						    
					pushFollow(FOLLOW_ruleUnDefineDirective_in_rulePreprocessorDirectives495);
					lv_directive_3_0=ruleUnDefineDirective();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
						        }
					       		set(
					       			current, 
					       			"directive",
					        		lv_directive_3_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.UnDefineDirective");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 4 :
					// InternalCPreprocess.g:323:3: ( (lv_directive_4_0= ruleErrorDirective ) )
					{
					// InternalCPreprocess.g:323:3: ( (lv_directive_4_0= ruleErrorDirective ) )
					// InternalCPreprocess.g:324:3: (lv_directive_4_0= ruleErrorDirective )
					{
					// InternalCPreprocess.g:324:3: (lv_directive_4_0= ruleErrorDirective )
					// InternalCPreprocess.g:325:3: lv_directive_4_0= ruleErrorDirective
					{
					 
						        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectiveErrorDirectiveParserRuleCall_1_3_0()); 
						    
					pushFollow(FOLLOW_ruleErrorDirective_in_rulePreprocessorDirectives525);
					lv_directive_4_0=ruleErrorDirective();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
						        }
					       		set(
					       			current, 
					       			"directive",
					        		lv_directive_4_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.ErrorDirective");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;
				case 5 :
					// InternalCPreprocess.g:345:3: ( (lv_directive_5_0= rulePragmaDirective ) )
					{
					// InternalCPreprocess.g:345:3: ( (lv_directive_5_0= rulePragmaDirective ) )
					// InternalCPreprocess.g:346:3: (lv_directive_5_0= rulePragmaDirective )
					{
					// InternalCPreprocess.g:346:3: (lv_directive_5_0= rulePragmaDirective )
					// InternalCPreprocess.g:347:3: lv_directive_5_0= rulePragmaDirective
					{
					 
						        newCompositeNode(grammarAccess.getPreprocessorDirectivesAccess().getDirectivePragmaDirectiveParserRuleCall_1_4_0()); 
						    
					pushFollow(FOLLOW_rulePragmaDirective_in_rulePreprocessorDirectives555);
					lv_directive_5_0=rulePragmaDirective();
					state._fsp--;


						        if (current==null) {
						            current = createModelElementForParent(grammarAccess.getPreprocessorDirectivesRule());
						        }
					       		set(
					       			current, 
					       			"directive",
					        		lv_directive_5_0, 
					        		"at.jku.weiner.cpreprocess.CPreprocess.PragmaDirective");
						        afterParserOrEnumRuleCall();
						    
					}

					}

					}
					break;

			}

			this_NEWLINE_6=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_rulePreprocessorDirectives572); 
			 
			    newLeafNode(this_NEWLINE_6, grammarAccess.getPreprocessorDirectivesAccess().getNEWLINETerminalRuleCall_2()); 
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "rulePreprocessorDirectives"



	// $ANTLR start "entryRuleIncludeDirective"
	// InternalCPreprocess.g:384:1: entryRuleIncludeDirective returns [EObject current=null] :iv_ruleIncludeDirective= ruleIncludeDirective EOF ;
	public final EObject entryRuleIncludeDirective() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleIncludeDirective =null;

		try {
			// InternalCPreprocess.g:385:2: (iv_ruleIncludeDirective= ruleIncludeDirective EOF )
			// InternalCPreprocess.g:386:2: iv_ruleIncludeDirective= ruleIncludeDirective EOF
			{
			 newCompositeNode(grammarAccess.getIncludeDirectiveRule()); 
			pushFollow(FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective611);
			iv_ruleIncludeDirective=ruleIncludeDirective();
			state._fsp--;

			 current =iv_ruleIncludeDirective; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeDirective621); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleIncludeDirective"



	// $ANTLR start "ruleIncludeDirective"
	// InternalCPreprocess.g:393:1: ruleIncludeDirective returns [EObject current=null] : ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= RULE_MYCODE ) ) ) ;
	public final EObject ruleIncludeDirective() throws RecognitionException {
		EObject current = null;


		Token this_INCLUDE_1=null;
		Token lv_string_2_0=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:399:7: ( ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= RULE_MYCODE ) ) ) )
			// InternalCPreprocess.g:401:5: ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= RULE_MYCODE ) ) )
			{
			// InternalCPreprocess.g:401:5: ( () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= RULE_MYCODE ) ) )
			// InternalCPreprocess.g:402:5: () this_INCLUDE_1= RULE_INCLUDE ( (lv_string_2_0= RULE_MYCODE ) )
			{
			// InternalCPreprocess.g:402:5: ()
			// InternalCPreprocess.g:403:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getIncludeDirectiveAccess().getIncludeDirectiveAction_0(),
			            current);
			    
			}

			this_INCLUDE_1=(Token)match(input,RULE_INCLUDE,FOLLOW_RULE_INCLUDE_in_ruleIncludeDirective671); 
			 
			    newLeafNode(this_INCLUDE_1, grammarAccess.getIncludeDirectiveAccess().getINCLUDETerminalRuleCall_1()); 
			    
			// InternalCPreprocess.g:418:3: ( (lv_string_2_0= RULE_MYCODE ) )
			// InternalCPreprocess.g:419:3: (lv_string_2_0= RULE_MYCODE )
			{
			// InternalCPreprocess.g:419:3: (lv_string_2_0= RULE_MYCODE )
			// InternalCPreprocess.g:420:3: lv_string_2_0= RULE_MYCODE
			{
			lv_string_2_0=(Token)match(input,RULE_MYCODE,FOLLOW_RULE_MYCODE_in_ruleIncludeDirective690); 

						newLeafNode(lv_string_2_0, grammarAccess.getIncludeDirectiveAccess().getStringMYCODETerminalRuleCall_2_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getIncludeDirectiveRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"string",
			        		lv_string_2_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.MYCODE");
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleIncludeDirective"



	// $ANTLR start "entryRuleDefineDirective"
	// InternalCPreprocess.g:448:1: entryRuleDefineDirective returns [EObject current=null] :iv_ruleDefineDirective= ruleDefineDirective EOF ;
	public final EObject entryRuleDefineDirective() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleDefineDirective =null;

		try {
			// InternalCPreprocess.g:449:2: (iv_ruleDefineDirective= ruleDefineDirective EOF )
			// InternalCPreprocess.g:450:2: iv_ruleDefineDirective= ruleDefineDirective EOF
			{
			 newCompositeNode(grammarAccess.getDefineDirectiveRule()); 
			pushFollow(FOLLOW_ruleDefineDirective_in_entryRuleDefineDirective735);
			iv_ruleDefineDirective=ruleDefineDirective();
			state._fsp--;

			 current =iv_ruleDefineDirective; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleDefineDirective745); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleDefineDirective"



	// $ANTLR start "ruleDefineDirective"
	// InternalCPreprocess.g:457:1: ruleDefineDirective returns [EObject current=null] : ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )+ ( (lv_string_4_0= RULE_MYCODE ) ) ) ;
	public final EObject ruleDefineDirective() throws RecognitionException {
		EObject current = null;


		Token this_DEFINE_1=null;
		Token lv_id_2_0=null;
		Token this_WS_3=null;
		Token lv_string_4_0=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:463:7: ( ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )+ ( (lv_string_4_0= RULE_MYCODE ) ) ) )
			// InternalCPreprocess.g:465:5: ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )+ ( (lv_string_4_0= RULE_MYCODE ) ) )
			{
			// InternalCPreprocess.g:465:5: ( () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )+ ( (lv_string_4_0= RULE_MYCODE ) ) )
			// InternalCPreprocess.g:466:5: () this_DEFINE_1= RULE_DEFINE ( (lv_id_2_0= RULE_ID ) ) (this_WS_3= RULE_WS )+ ( (lv_string_4_0= RULE_MYCODE ) )
			{
			// InternalCPreprocess.g:466:5: ()
			// InternalCPreprocess.g:467:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getDefineDirectiveAccess().getDefineDirectiveAction_0(),
			            current);
			    
			}

			this_DEFINE_1=(Token)match(input,RULE_DEFINE,FOLLOW_RULE_DEFINE_in_ruleDefineDirective795); 
			 
			    newLeafNode(this_DEFINE_1, grammarAccess.getDefineDirectiveAccess().getDEFINETerminalRuleCall_1()); 
			    
			// InternalCPreprocess.g:482:3: ( (lv_id_2_0= RULE_ID ) )
			// InternalCPreprocess.g:483:3: (lv_id_2_0= RULE_ID )
			{
			// InternalCPreprocess.g:483:3: (lv_id_2_0= RULE_ID )
			// InternalCPreprocess.g:484:3: lv_id_2_0= RULE_ID
			{
			lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefineDirective814); 

						newLeafNode(lv_id_2_0, grammarAccess.getDefineDirectiveAccess().getIdIDTerminalRuleCall_2_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getDefineDirectiveRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"id",
			        		lv_id_2_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.ID");
				    
			}

			}

			// InternalCPreprocess.g:503:2: (this_WS_3= RULE_WS )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==RULE_WS) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalCPreprocess.g:503:2: this_WS_3= RULE_WS
					{
					this_WS_3=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleDefineDirective834); 
					 
					    newLeafNode(this_WS_3, grammarAccess.getDefineDirectiveAccess().getWSTerminalRuleCall_3()); 
					    
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			// InternalCPreprocess.g:510:3: ( (lv_string_4_0= RULE_MYCODE ) )
			// InternalCPreprocess.g:511:3: (lv_string_4_0= RULE_MYCODE )
			{
			// InternalCPreprocess.g:511:3: (lv_string_4_0= RULE_MYCODE )
			// InternalCPreprocess.g:512:3: lv_string_4_0= RULE_MYCODE
			{
			lv_string_4_0=(Token)match(input,RULE_MYCODE,FOLLOW_RULE_MYCODE_in_ruleDefineDirective855); 

						newLeafNode(lv_string_4_0, grammarAccess.getDefineDirectiveAccess().getStringMYCODETerminalRuleCall_4_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getDefineDirectiveRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"string",
			        		lv_string_4_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.MYCODE");
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleDefineDirective"



	// $ANTLR start "entryRuleUnDefineDirective"
	// InternalCPreprocess.g:540:1: entryRuleUnDefineDirective returns [EObject current=null] :iv_ruleUnDefineDirective= ruleUnDefineDirective EOF ;
	public final EObject entryRuleUnDefineDirective() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleUnDefineDirective =null;

		try {
			// InternalCPreprocess.g:541:2: (iv_ruleUnDefineDirective= ruleUnDefineDirective EOF )
			// InternalCPreprocess.g:542:2: iv_ruleUnDefineDirective= ruleUnDefineDirective EOF
			{
			 newCompositeNode(grammarAccess.getUnDefineDirectiveRule()); 
			pushFollow(FOLLOW_ruleUnDefineDirective_in_entryRuleUnDefineDirective900);
			iv_ruleUnDefineDirective=ruleUnDefineDirective();
			state._fsp--;

			 current =iv_ruleUnDefineDirective; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleUnDefineDirective910); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleUnDefineDirective"



	// $ANTLR start "ruleUnDefineDirective"
	// InternalCPreprocess.g:549:1: ruleUnDefineDirective returns [EObject current=null] : ( () this_UNDEF_1= RULE_UNDEF ) ;
	public final EObject ruleUnDefineDirective() throws RecognitionException {
		EObject current = null;


		Token this_UNDEF_1=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:555:7: ( ( () this_UNDEF_1= RULE_UNDEF ) )
			// InternalCPreprocess.g:557:5: ( () this_UNDEF_1= RULE_UNDEF )
			{
			// InternalCPreprocess.g:557:5: ( () this_UNDEF_1= RULE_UNDEF )
			// InternalCPreprocess.g:558:5: () this_UNDEF_1= RULE_UNDEF
			{
			// InternalCPreprocess.g:558:5: ()
			// InternalCPreprocess.g:559:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getUnDefineDirectiveAccess().getUnDefineDirectiveAction_0(),
			            current);
			    
			}

			this_UNDEF_1=(Token)match(input,RULE_UNDEF,FOLLOW_RULE_UNDEF_in_ruleUnDefineDirective960); 
			 
			    newLeafNode(this_UNDEF_1, grammarAccess.getUnDefineDirectiveAccess().getUNDEFTerminalRuleCall_1()); 
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleUnDefineDirective"



	// $ANTLR start "entryRuleErrorDirective"
	// InternalCPreprocess.g:583:1: entryRuleErrorDirective returns [EObject current=null] :iv_ruleErrorDirective= ruleErrorDirective EOF ;
	public final EObject entryRuleErrorDirective() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleErrorDirective =null;

		try {
			// InternalCPreprocess.g:584:2: (iv_ruleErrorDirective= ruleErrorDirective EOF )
			// InternalCPreprocess.g:585:2: iv_ruleErrorDirective= ruleErrorDirective EOF
			{
			 newCompositeNode(grammarAccess.getErrorDirectiveRule()); 
			pushFollow(FOLLOW_ruleErrorDirective_in_entryRuleErrorDirective999);
			iv_ruleErrorDirective=ruleErrorDirective();
			state._fsp--;

			 current =iv_ruleErrorDirective; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleErrorDirective1009); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleErrorDirective"



	// $ANTLR start "ruleErrorDirective"
	// InternalCPreprocess.g:592:1: ruleErrorDirective returns [EObject current=null] : ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= RULE_MYCODE ) ) ) ;
	public final EObject ruleErrorDirective() throws RecognitionException {
		EObject current = null;


		Token this_ERROR_1=null;
		Token lv_msg_2_0=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:598:7: ( ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= RULE_MYCODE ) ) ) )
			// InternalCPreprocess.g:600:5: ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= RULE_MYCODE ) ) )
			{
			// InternalCPreprocess.g:600:5: ( () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= RULE_MYCODE ) ) )
			// InternalCPreprocess.g:601:5: () this_ERROR_1= RULE_ERROR ( (lv_msg_2_0= RULE_MYCODE ) )
			{
			// InternalCPreprocess.g:601:5: ()
			// InternalCPreprocess.g:602:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getErrorDirectiveAccess().getErrorDirectiveAction_0(),
			            current);
			    
			}

			this_ERROR_1=(Token)match(input,RULE_ERROR,FOLLOW_RULE_ERROR_in_ruleErrorDirective1059); 
			 
			    newLeafNode(this_ERROR_1, grammarAccess.getErrorDirectiveAccess().getERRORTerminalRuleCall_1()); 
			    
			// InternalCPreprocess.g:617:3: ( (lv_msg_2_0= RULE_MYCODE ) )
			// InternalCPreprocess.g:618:3: (lv_msg_2_0= RULE_MYCODE )
			{
			// InternalCPreprocess.g:618:3: (lv_msg_2_0= RULE_MYCODE )
			// InternalCPreprocess.g:619:3: lv_msg_2_0= RULE_MYCODE
			{
			lv_msg_2_0=(Token)match(input,RULE_MYCODE,FOLLOW_RULE_MYCODE_in_ruleErrorDirective1078); 

						newLeafNode(lv_msg_2_0, grammarAccess.getErrorDirectiveAccess().getMsgMYCODETerminalRuleCall_2_0()); 
					

				        if (current==null) {
				            current = createModelElement(grammarAccess.getErrorDirectiveRule());
				        }
			       		setWithLastConsumed(
			       			current, 
			       			"msg",
			        		lv_msg_2_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.MYCODE");
				    
			}

			}

			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleErrorDirective"



	// $ANTLR start "entryRulePragmaDirective"
	// InternalCPreprocess.g:647:1: entryRulePragmaDirective returns [EObject current=null] :iv_rulePragmaDirective= rulePragmaDirective EOF ;
	public final EObject entryRulePragmaDirective() throws RecognitionException {
		EObject current = null;


		EObject iv_rulePragmaDirective =null;

		try {
			// InternalCPreprocess.g:648:2: (iv_rulePragmaDirective= rulePragmaDirective EOF )
			// InternalCPreprocess.g:649:2: iv_rulePragmaDirective= rulePragmaDirective EOF
			{
			 newCompositeNode(grammarAccess.getPragmaDirectiveRule()); 
			pushFollow(FOLLOW_rulePragmaDirective_in_entryRulePragmaDirective1123);
			iv_rulePragmaDirective=rulePragmaDirective();
			state._fsp--;

			 current =iv_rulePragmaDirective; 
			match(input,EOF,FOLLOW_EOF_in_entryRulePragmaDirective1133); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRulePragmaDirective"



	// $ANTLR start "rulePragmaDirective"
	// InternalCPreprocess.g:656:1: rulePragmaDirective returns [EObject current=null] : ( () this_PRAGMA_1= RULE_PRAGMA ) ;
	public final EObject rulePragmaDirective() throws RecognitionException {
		EObject current = null;


		Token this_PRAGMA_1=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:662:7: ( ( () this_PRAGMA_1= RULE_PRAGMA ) )
			// InternalCPreprocess.g:664:5: ( () this_PRAGMA_1= RULE_PRAGMA )
			{
			// InternalCPreprocess.g:664:5: ( () this_PRAGMA_1= RULE_PRAGMA )
			// InternalCPreprocess.g:665:5: () this_PRAGMA_1= RULE_PRAGMA
			{
			// InternalCPreprocess.g:665:5: ()
			// InternalCPreprocess.g:666:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getPragmaDirectiveAccess().getPragmaDirectiveAction_0(),
			            current);
			    
			}

			this_PRAGMA_1=(Token)match(input,RULE_PRAGMA,FOLLOW_RULE_PRAGMA_in_rulePragmaDirective1183); 
			 
			    newLeafNode(this_PRAGMA_1, grammarAccess.getPragmaDirectiveAccess().getPRAGMATerminalRuleCall_1()); 
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "rulePragmaDirective"



	// $ANTLR start "entryRuleNewLineLine"
	// InternalCPreprocess.g:690:1: entryRuleNewLineLine returns [EObject current=null] :iv_ruleNewLineLine= ruleNewLineLine EOF ;
	public final EObject entryRuleNewLineLine() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleNewLineLine =null;

		try {
			// InternalCPreprocess.g:691:2: (iv_ruleNewLineLine= ruleNewLineLine EOF )
			// InternalCPreprocess.g:692:2: iv_ruleNewLineLine= ruleNewLineLine EOF
			{
			 newCompositeNode(grammarAccess.getNewLineLineRule()); 
			pushFollow(FOLLOW_ruleNewLineLine_in_entryRuleNewLineLine1222);
			iv_ruleNewLineLine=ruleNewLineLine();
			state._fsp--;

			 current =iv_ruleNewLineLine; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleNewLineLine1232); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleNewLineLine"



	// $ANTLR start "ruleNewLineLine"
	// InternalCPreprocess.g:699:1: ruleNewLineLine returns [EObject current=null] : ( () this_NEWLINE_1= RULE_NEWLINE ) ;
	public final EObject ruleNewLineLine() throws RecognitionException {
		EObject current = null;


		Token this_NEWLINE_1=null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:705:7: ( ( () this_NEWLINE_1= RULE_NEWLINE ) )
			// InternalCPreprocess.g:707:5: ( () this_NEWLINE_1= RULE_NEWLINE )
			{
			// InternalCPreprocess.g:707:5: ( () this_NEWLINE_1= RULE_NEWLINE )
			// InternalCPreprocess.g:708:5: () this_NEWLINE_1= RULE_NEWLINE
			{
			// InternalCPreprocess.g:708:5: ()
			// InternalCPreprocess.g:709:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getNewLineLineAccess().getNewLineLineAction_0(),
			            current);
			    
			}

			this_NEWLINE_1=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNewLineLine1282); 
			 
			    newLeafNode(this_NEWLINE_1, grammarAccess.getNewLineLineAccess().getNEWLINETerminalRuleCall_1()); 
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleNewLineLine"



	// $ANTLR start "entryRuleCode"
	// InternalCPreprocess.g:733:1: entryRuleCode returns [EObject current=null] :iv_ruleCode= ruleCode EOF ;
	public final EObject entryRuleCode() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleCode =null;

		try {
			// InternalCPreprocess.g:734:2: (iv_ruleCode= ruleCode EOF )
			// InternalCPreprocess.g:735:2: iv_ruleCode= ruleCode EOF
			{
			 newCompositeNode(grammarAccess.getCodeRule()); 
			pushFollow(FOLLOW_ruleCode_in_entryRuleCode1321);
			iv_ruleCode=ruleCode();
			state._fsp--;

			 current =iv_ruleCode; 
			match(input,EOF,FOLLOW_EOF_in_entryRuleCode1331); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleCode"



	// $ANTLR start "ruleCode"
	// InternalCPreprocess.g:742:1: ruleCode returns [EObject current=null] : ( () ( (lv_code_1_0= ruleMyCodeLine ) ) this_NEWLINE_2= RULE_NEWLINE ) ;
	public final EObject ruleCode() throws RecognitionException {
		EObject current = null;


		Token this_NEWLINE_2=null;
		AntlrDatatypeRuleToken lv_code_1_0 =null;

		 enterRule();
		   		/*no init found*/
		    
		try {
			// InternalCPreprocess.g:748:7: ( ( () ( (lv_code_1_0= ruleMyCodeLine ) ) this_NEWLINE_2= RULE_NEWLINE ) )
			// InternalCPreprocess.g:750:5: ( () ( (lv_code_1_0= ruleMyCodeLine ) ) this_NEWLINE_2= RULE_NEWLINE )
			{
			// InternalCPreprocess.g:750:5: ( () ( (lv_code_1_0= ruleMyCodeLine ) ) this_NEWLINE_2= RULE_NEWLINE )
			// InternalCPreprocess.g:751:5: () ( (lv_code_1_0= ruleMyCodeLine ) ) this_NEWLINE_2= RULE_NEWLINE
			{
			// InternalCPreprocess.g:751:5: ()
			// InternalCPreprocess.g:752:5: 
			{

			        current = forceCreateModelElement(
			            grammarAccess.getCodeAccess().getCodeAction_0(),
			            current);
			    
			}

			// InternalCPreprocess.g:760:3: ( (lv_code_1_0= ruleMyCodeLine ) )
			// InternalCPreprocess.g:761:3: (lv_code_1_0= ruleMyCodeLine )
			{
			// InternalCPreprocess.g:761:3: (lv_code_1_0= ruleMyCodeLine )
			// InternalCPreprocess.g:762:3: lv_code_1_0= ruleMyCodeLine
			{
			 
				        newCompositeNode(grammarAccess.getCodeAccess().getCodeMyCodeLineParserRuleCall_1_0()); 
				    
			pushFollow(FOLLOW_ruleMyCodeLine_in_ruleCode1391);
			lv_code_1_0=ruleMyCodeLine();
			state._fsp--;


				        if (current==null) {
				            current = createModelElementForParent(grammarAccess.getCodeRule());
				        }
			       		set(
			       			current, 
			       			"code",
			        		lv_code_1_0, 
			        		"at.jku.weiner.cpreprocess.CPreprocess.MyCodeLine");
				        afterParserOrEnumRuleCall();
				    
			}

			}

			this_NEWLINE_2=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleCode1405); 
			 
			    newLeafNode(this_NEWLINE_2, grammarAccess.getCodeAccess().getNEWLINETerminalRuleCall_2()); 
			    
			}

			}

			 leaveRule();
			    		/*no after found*/
			     
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleCode"



	// $ANTLR start "entryRuleMyCodeLine"
	// InternalCPreprocess.g:797:1: entryRuleMyCodeLine returns [String current=null] :iv_ruleMyCodeLine= ruleMyCodeLine EOF ;
	public final String entryRuleMyCodeLine() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleMyCodeLine =null;

		try {
			// InternalCPreprocess.g:798:2: (iv_ruleMyCodeLine= ruleMyCodeLine EOF )
			// InternalCPreprocess.g:799:2: iv_ruleMyCodeLine= ruleMyCodeLine EOF
			{
			 newCompositeNode(grammarAccess.getMyCodeLineRule()); 
			pushFollow(FOLLOW_ruleMyCodeLine_in_entryRuleMyCodeLine1445);
			iv_ruleMyCodeLine=ruleMyCodeLine();
			state._fsp--;

			 current =iv_ruleMyCodeLine.getText(); 
			match(input,EOF,FOLLOW_EOF_in_entryRuleMyCodeLine1456); 
			}

		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleMyCodeLine"



	// $ANTLR start "ruleMyCodeLine"
	// InternalCPreprocess.g:806:1: ruleMyCodeLine returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MYCODE_0= RULE_MYCODE |this_ID_1= RULE_ID )+ ;
	public final AntlrDatatypeRuleToken ruleMyCodeLine() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_MYCODE_0=null;
		Token this_ID_1=null;

		 enterRule(); 
		    
		try {
			// InternalCPreprocess.g:809:28: ( (this_MYCODE_0= RULE_MYCODE |this_ID_1= RULE_ID )+ )
			// InternalCPreprocess.g:810:6: (this_MYCODE_0= RULE_MYCODE |this_ID_1= RULE_ID )+
			{
			// InternalCPreprocess.g:810:6: (this_MYCODE_0= RULE_MYCODE |this_ID_1= RULE_ID )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=3;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==RULE_MYCODE) ) {
					alt4=1;
				}
				else if ( (LA4_0==RULE_ID) ) {
					alt4=2;
				}

				switch (alt4) {
				case 1 :
					// InternalCPreprocess.g:810:6: this_MYCODE_0= RULE_MYCODE
					{
					this_MYCODE_0=(Token)match(input,RULE_MYCODE,FOLLOW_RULE_MYCODE_in_ruleMyCodeLine1496); 

							current.merge(this_MYCODE_0);
					    
					 
					    newLeafNode(this_MYCODE_0, grammarAccess.getMyCodeLineAccess().getMYCODETerminalRuleCall_0()); 
					    
					}
					break;
				case 2 :
					// InternalCPreprocess.g:818:10: this_ID_1= RULE_ID
					{
					this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMyCodeLine1522); 

							current.merge(this_ID_1);
					    
					 
					    newLeafNode(this_ID_1, grammarAccess.getMyCodeLineAccess().getIDTerminalRuleCall_1()); 
					    
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			 leaveRule(); 
		}
		 
		    catch (RecognitionException re) { 
		        recover(input,re); 
		        appendSkippedTokens();
		    } 

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleMyCodeLine"

	// Delegated rules



	public static final BitSet FOLLOW_ruleModel_in_entryRuleModel77 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleModel87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleTranslationUnit_in_ruleModel147 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleTranslationUnit_in_entryRuleTranslationUnit187 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleTranslationUnit197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rulePreprocessorDirectives_in_ruleTranslationUnit259 = new BitSet(new long[]{0x00000000000D8AC2L});
	public static final BitSet FOLLOW_ruleNewLineLine_in_ruleTranslationUnit289 = new BitSet(new long[]{0x00000000000D8AC2L});
	public static final BitSet FOLLOW_ruleCode_in_ruleTranslationUnit319 = new BitSet(new long[]{0x00000000000D8AC2L});
	public static final BitSet FOLLOW_rulePreprocessorDirectives_in_entryRulePreprocessorDirectives363 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRulePreprocessorDirectives373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleIncludeDirective_in_rulePreprocessorDirectives435 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ruleDefineDirective_in_rulePreprocessorDirectives465 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ruleUnDefineDirective_in_rulePreprocessorDirectives495 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_ruleErrorDirective_in_rulePreprocessorDirectives525 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_rulePragmaDirective_in_rulePreprocessorDirectives555 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_RULE_NEWLINE_in_rulePreprocessorDirectives572 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleIncludeDirective_in_entryRuleIncludeDirective611 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleIncludeDirective621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_INCLUDE_in_ruleIncludeDirective671 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_RULE_MYCODE_in_ruleIncludeDirective690 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleDefineDirective_in_entryRuleDefineDirective735 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleDefineDirective745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_DEFINE_in_ruleDefineDirective795 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_RULE_ID_in_ruleDefineDirective814 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_RULE_WS_in_ruleDefineDirective834 = new BitSet(new long[]{0x0000000000108000L});
	public static final BitSet FOLLOW_RULE_MYCODE_in_ruleDefineDirective855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleUnDefineDirective_in_entryRuleUnDefineDirective900 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleUnDefineDirective910 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_UNDEF_in_ruleUnDefineDirective960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleErrorDirective_in_entryRuleErrorDirective999 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleErrorDirective1009 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_ERROR_in_ruleErrorDirective1059 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_RULE_MYCODE_in_ruleErrorDirective1078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rulePragmaDirective_in_entryRulePragmaDirective1123 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRulePragmaDirective1133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_PRAGMA_in_rulePragmaDirective1183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleNewLineLine_in_entryRuleNewLineLine1222 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleNewLineLine1232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNewLineLine1282 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleCode_in_entryRuleCode1321 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleCode1331 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleMyCodeLine_in_ruleCode1391 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleCode1405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ruleMyCodeLine_in_entryRuleMyCodeLine1445 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_entryRuleMyCodeLine1456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RULE_MYCODE_in_ruleMyCodeLine1496 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_RULE_ID_in_ruleMyCodeLine1522 = new BitSet(new long[]{0x0000000000008202L});
}
