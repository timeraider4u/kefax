package at.jku.isse.ecco.kefax.kbuild.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.isse.ecco.kefax.kbuild.services.KbuildGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalKbuildParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_IFEQ", "RULE_IFNEQ", "RULE_IFNDEF", "RULE_SYMBOL", "RULE_ENDIF", "RULE_DPOINT", "RULE_SEMICOLON", "RULE_TAB", "RULE_OBJ_START", "RULE_BRACE_START", "RULE_COMMA", "RULE_Y", "RULE_M", "RULE_BRACE_END", "RULE_ELSE", "RULE_OBJ_Y", "RULE_OBJ_M", "RULE_EQ", "RULE_PLUS", "RULE_BACKSLASH", "RULE_OBJ_FILE", "RULE_SLASH", "RULE_STRING", "RULE_SHELL_CHAR", "RULE_DOLLAR", "RULE_INCLUDE", "RULE_NLI", "RULE_WSS", "RULE_SL_COMMENT", "RULE_QUOTE", "RULE_STR_ESC"
    };
    public static final int RULE_DPOINT=9;
    public static final int RULE_SHELL_CHAR=27;
    public static final int RULE_OBJ_Y=19;
    public static final int RULE_QUOTE=33;
    public static final int RULE_OBJ_M=20;
    public static final int RULE_SEMICOLON=10;
    public static final int RULE_STR_ESC=34;
    public static final int RULE_PLUS=22;
    public static final int RULE_IFNDEF=6;
    public static final int RULE_COMMA=14;
    public static final int RULE_TAB=11;
    public static final int RULE_OBJ_START=12;
    public static final int RULE_BRACE_END=17;
    public static final int RULE_SL_COMMENT=32;
    public static final int EOF=-1;
    public static final int RULE_OBJ_FILE=24;
    public static final int RULE_WSS=31;
    public static final int RULE_DOLLAR=28;
    public static final int RULE_STRING=26;
    public static final int RULE_IFNEQ=5;
    public static final int RULE_IFEQ=4;
    public static final int RULE_NLI=30;
    public static final int RULE_ENDIF=8;
    public static final int RULE_M=16;
    public static final int RULE_EQ=21;
    public static final int RULE_Y=15;
    public static final int RULE_INCLUDE=29;
    public static final int RULE_BACKSLASH=23;
    public static final int RULE_SLASH=25;
    public static final int RULE_SYMBOL=7;
    public static final int RULE_BRACE_START=13;
    public static final int RULE_ELSE=18;

    // delegates
    // delegators


        public InternalKbuildParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalKbuildParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalKbuildParser.tokenNames; }
    public String getGrammarFileName() { return "../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g"; }



     	private KbuildGrammarAccess grammarAccess;
     	
        public InternalKbuildParser(TokenStream input, KbuildGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected KbuildGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:76:1: ruleModel returns [EObject current=null] : ( () ( (lv_buildEntry_1_0= ruleBuildEntry ) )? ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )* ruleEol ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_buildEntry_1_0 = null;

        EObject lv_buildEntry_3_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:79:28: ( ( () ( (lv_buildEntry_1_0= ruleBuildEntry ) )? ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )* ruleEol ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:80:1: ( () ( (lv_buildEntry_1_0= ruleBuildEntry ) )? ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )* ruleEol )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:80:1: ( () ( (lv_buildEntry_1_0= ruleBuildEntry ) )? ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )* ruleEol )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:80:2: () ( (lv_buildEntry_1_0= ruleBuildEntry ) )? ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )* ruleEol
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:80:2: ()
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:86:2: ( (lv_buildEntry_1_0= ruleBuildEntry ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_IFEQ && LA1_0<=RULE_SYMBOL)||LA1_0==RULE_OBJ_START||(LA1_0>=RULE_OBJ_Y && LA1_0<=RULE_OBJ_M)||LA1_0==RULE_BACKSLASH||(LA1_0>=RULE_STRING && LA1_0<=RULE_INCLUDE)) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:87:1: (lv_buildEntry_1_0= ruleBuildEntry )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:87:1: (lv_buildEntry_1_0= ruleBuildEntry )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:88:3: lv_buildEntry_1_0= ruleBuildEntry
                    {
                     
                    	        newCompositeNode(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBuildEntry_in_ruleModel140);
                    lv_buildEntry_1_0=ruleBuildEntry();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModelRule());
                    	        }
                           		add(
                           			current, 
                           			"buildEntry",
                            		lv_buildEntry_1_0, 
                            		"BuildEntry");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:104:3: ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )*
            loop2:
            do {
                int alt2=2;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:105:5: ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getModelAccess().getEolParserRuleCall_2_0()); 
            	        
            	    pushFollow(FOLLOW_ruleEol_in_ruleModel158);
            	    ruleEol();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:112:1: ( (lv_buildEntry_3_0= ruleBuildEntry ) )
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:113:1: (lv_buildEntry_3_0= ruleBuildEntry )
            	    {
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:113:1: (lv_buildEntry_3_0= ruleBuildEntry )
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:114:3: lv_buildEntry_3_0= ruleBuildEntry
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getBuildEntryBuildEntryParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleBuildEntry_in_ruleModel178);
            	    lv_buildEntry_3_0=ruleBuildEntry();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"buildEntry",
            	            		lv_buildEntry_3_0, 
            	            		"BuildEntry");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getModelAccess().getEolParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleEol_in_ruleModel196);
            ruleEol();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleBuildEntry"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:146:1: entryRuleBuildEntry returns [EObject current=null] : iv_ruleBuildEntry= ruleBuildEntry EOF ;
    public final EObject entryRuleBuildEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuildEntry = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:147:2: (iv_ruleBuildEntry= ruleBuildEntry EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:148:2: iv_ruleBuildEntry= ruleBuildEntry EOF
            {
             newCompositeNode(grammarAccess.getBuildEntryRule()); 
            pushFollow(FOLLOW_ruleBuildEntry_in_entryRuleBuildEntry231);
            iv_ruleBuildEntry=ruleBuildEntry();

            state._fsp--;

             current =iv_ruleBuildEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBuildEntry241); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuildEntry"


    // $ANTLR start "ruleBuildEntry"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:155:1: ruleBuildEntry returns [EObject current=null] : ( ( () ( (lv_value_1_0= ruleEntry ) ) ) | ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) ) | ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) ) | ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF ) | ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? ) | ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) ) | ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) ) | ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) ) ) ;
    public final EObject ruleBuildEntry() throws RecognitionException {
        EObject current = null;

        Token this_IFEQ_3=null;
        Token this_IFNEQ_6=null;
        Token this_IFNDEF_9=null;
        Token lv_name_10_0=null;
        Token this_ENDIF_15=null;
        Token lv_name_17_0=null;
        Token this_DPOINT_26=null;
        Token this_SEMICOLON_27=null;
        Token this_TAB_30=null;
        Token lv_name_33_0=null;
        EObject lv_value_1_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_value_7_0 = null;

        EObject lv_value_12_0 = null;

        EObject lv_value_13_0 = null;

        EObject lv_variable_18_0 = null;

        EObject lv_value_19_0 = null;

        EObject lv_inner_20_0 = null;

        EObject lv_value_22_0 = null;

        EObject lv_value_23_0 = null;

        EObject lv_target_25_0 = null;

        EObject lv_values_28_0 = null;

        EObject lv_values_31_0 = null;

        EObject lv_variable_34_0 = null;

        EObject lv_value_35_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:158:28: ( ( ( () ( (lv_value_1_0= ruleEntry ) ) ) | ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) ) | ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) ) | ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF ) | ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? ) | ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) ) | ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) ) | ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:1: ( ( () ( (lv_value_1_0= ruleEntry ) ) ) | ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) ) | ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) ) | ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF ) | ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? ) | ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) ) | ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) ) | ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:1: ( ( () ( (lv_value_1_0= ruleEntry ) ) ) | ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) ) | ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) ) | ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF ) | ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? ) | ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) ) | ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) ) | ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) ) )
            int alt11=8;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:2: ( () ( (lv_value_1_0= ruleEntry ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:2: ( () ( (lv_value_1_0= ruleEntry ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:3: () ( (lv_value_1_0= ruleEntry ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:159:3: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:160:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getBuildEntryAction_0_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:165:2: ( (lv_value_1_0= ruleEntry ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:166:1: (lv_value_1_0= ruleEntry )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:166:1: (lv_value_1_0= ruleEntry )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:167:3: lv_value_1_0= ruleEntry
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueEntryParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEntry_in_ruleBuildEntry297);
                    lv_value_1_0=ruleEntry();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"Entry");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:184:6: ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:184:6: ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:184:7: () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:184:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:185:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getIfEqAction_1_0(),
                                current);
                        

                    }

                    this_IFEQ_3=(Token)match(input,RULE_IFEQ,FOLLOW_RULE_IFEQ_in_ruleBuildEntry325); 
                     
                        newLeafNode(this_IFEQ_3, grammarAccess.getBuildEntryAccess().getIFEQTerminalRuleCall_1_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:194:1: ( (lv_value_4_0= ruleIf ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:195:1: (lv_value_4_0= ruleIf )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:195:1: (lv_value_4_0= ruleIf )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:196:3: lv_value_4_0= ruleIf
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIf_in_ruleBuildEntry345);
                    lv_value_4_0=ruleIf();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"If");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:213:6: ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:213:6: ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:213:7: () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:213:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:214:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getIfNEqAction_2_0(),
                                current);
                        

                    }

                    this_IFNEQ_6=(Token)match(input,RULE_IFNEQ,FOLLOW_RULE_IFNEQ_in_ruleBuildEntry373); 
                     
                        newLeafNode(this_IFNEQ_6, grammarAccess.getBuildEntryAccess().getIFNEQTerminalRuleCall_2_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:223:1: ( (lv_value_7_0= ruleIf ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:224:1: (lv_value_7_0= ruleIf )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:224:1: (lv_value_7_0= ruleIf )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:225:3: lv_value_7_0= ruleIf
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueIfParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleIf_in_ruleBuildEntry393);
                    lv_value_7_0=ruleIf();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_7_0, 
                            		"If");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:242:6: ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:242:6: ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:242:7: () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:242:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:243:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getIfndefAction_3_0(),
                                current);
                        

                    }

                    this_IFNDEF_9=(Token)match(input,RULE_IFNDEF,FOLLOW_RULE_IFNDEF_in_ruleBuildEntry421); 
                     
                        newLeafNode(this_IFNDEF_9, grammarAccess.getBuildEntryAccess().getIFNDEFTerminalRuleCall_3_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:252:1: ( (lv_name_10_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:253:1: (lv_name_10_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:253:1: (lv_name_10_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:254:3: lv_name_10_0= RULE_SYMBOL
                    {
                    lv_name_10_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleBuildEntry437); 

                    			newLeafNode(lv_name_10_0, grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_3_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBuildEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_10_0, 
                            		"SYMBOL");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_3()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleBuildEntry458);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:278:1: ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_OBJ_Y) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==RULE_OBJ_M) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:278:2: ( (lv_value_12_0= ruleObject_Y ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:278:2: ( (lv_value_12_0= ruleObject_Y ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:279:1: (lv_value_12_0= ruleObject_Y )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:279:1: (lv_value_12_0= ruleObject_Y )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:280:3: lv_value_12_0= ruleObject_Y
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_3_4_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_Y_in_ruleBuildEntry479);
                            lv_value_12_0=ruleObject_Y();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_12_0, 
                                    		"Object_Y");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:297:6: ( (lv_value_13_0= ruleObject_M ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:297:6: ( (lv_value_13_0= ruleObject_M ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:298:1: (lv_value_13_0= ruleObject_M )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:298:1: (lv_value_13_0= ruleObject_M )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:299:3: lv_value_13_0= ruleObject_M
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_3_4_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_M_in_ruleBuildEntry506);
                            lv_value_13_0=ruleObject_M();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_13_0, 
                                    		"Object_M");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_3_5()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleBuildEntry523);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    this_ENDIF_15=(Token)match(input,RULE_ENDIF,FOLLOW_RULE_ENDIF_in_ruleBuildEntry533); 
                     
                        newLeafNode(this_ENDIF_15, grammarAccess.getBuildEntryAccess().getENDIFTerminalRuleCall_3_6()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:328:6: ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:328:6: ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:328:7: () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )?
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:328:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:329:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getHostProgramAction_4_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:334:2: ( (lv_name_17_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:335:1: (lv_name_17_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:335:1: (lv_name_17_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:336:3: lv_name_17_0= RULE_SYMBOL
                    {
                    lv_name_17_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleBuildEntry566); 

                    			newLeafNode(lv_name_17_0, grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_4_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBuildEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_17_0, 
                            		"SYMBOL");
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:352:2: ( (lv_variable_18_0= ruleVariable ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_DOLLAR) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:353:1: (lv_variable_18_0= ruleVariable )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:353:1: (lv_variable_18_0= ruleVariable )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:354:3: lv_variable_18_0= ruleVariable
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_4_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVariable_in_ruleBuildEntry592);
                            lv_variable_18_0=ruleVariable();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"variable",
                                    		lv_variable_18_0, 
                                    		"Variable");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:370:3: ( (lv_value_19_0= ruleAssignExtra ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:371:1: (lv_value_19_0= ruleAssignExtra )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:371:1: (lv_value_19_0= ruleAssignExtra )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:372:3: lv_value_19_0= ruleAssignExtra
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueAssignExtraParserRuleCall_4_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAssignExtra_in_ruleBuildEntry614);
                    lv_value_19_0=ruleAssignExtra();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_19_0, 
                            		"AssignExtra");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:388:2: ( (lv_inner_20_0= ruleAssign ) )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_EQ) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:389:1: (lv_inner_20_0= ruleAssign )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:389:1: (lv_inner_20_0= ruleAssign )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:390:3: lv_inner_20_0= ruleAssign
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getInnerAssignParserRuleCall_4_4_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAssign_in_ruleBuildEntry635);
                            lv_inner_20_0=ruleAssign();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"inner",
                                    		lv_inner_20_0, 
                                    		"Assign");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:407:6: ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:407:6: ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:407:7: () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:407:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:408:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getObjectAction_5_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:413:2: ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==RULE_OBJ_Y) ) {
                        alt6=1;
                    }
                    else if ( (LA6_0==RULE_OBJ_M) ) {
                        alt6=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:413:3: ( (lv_value_22_0= ruleObject_Y ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:413:3: ( (lv_value_22_0= ruleObject_Y ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:414:1: (lv_value_22_0= ruleObject_Y )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:414:1: (lv_value_22_0= ruleObject_Y )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:415:3: lv_value_22_0= ruleObject_Y
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueObject_YParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_Y_in_ruleBuildEntry675);
                            lv_value_22_0=ruleObject_Y();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_22_0, 
                                    		"Object_Y");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:432:6: ( (lv_value_23_0= ruleObject_M ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:432:6: ( (lv_value_23_0= ruleObject_M ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:433:1: (lv_value_23_0= ruleObject_M )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:433:1: (lv_value_23_0= ruleObject_M )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:434:3: lv_value_23_0= ruleObject_M
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueObject_MParserRuleCall_5_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_M_in_ruleBuildEntry702);
                            lv_value_23_0=ruleObject_M();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_23_0, 
                                    		"Object_M");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 7 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:451:6: ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:451:6: ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:451:7: () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:451:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:452:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getTargetAction_6_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:457:2: ( (lv_target_25_0= ruleValues ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:458:1: (lv_target_25_0= ruleValues )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:458:1: (lv_target_25_0= ruleValues )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:459:3: lv_target_25_0= ruleValues
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getTargetValuesParserRuleCall_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValues_in_ruleBuildEntry741);
                    lv_target_25_0=ruleValues();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_25_0, 
                            		"Values");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    this_DPOINT_26=(Token)match(input,RULE_DPOINT,FOLLOW_RULE_DPOINT_in_ruleBuildEntry752); 
                     
                        newLeafNode(this_DPOINT_26, grammarAccess.getBuildEntryAccess().getDPOINTTerminalRuleCall_6_2()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:479:1: (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==RULE_SEMICOLON) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==RULE_SYMBOL||LA9_0==RULE_BACKSLASH||(LA9_0>=RULE_STRING && LA9_0<=RULE_INCLUDE)) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:479:2: this_SEMICOLON_27= RULE_SEMICOLON
                            {
                            this_SEMICOLON_27=(Token)match(input,RULE_SEMICOLON,FOLLOW_RULE_SEMICOLON_in_ruleBuildEntry763); 
                             
                                newLeafNode(this_SEMICOLON_27, grammarAccess.getBuildEntryAccess().getSEMICOLONTerminalRuleCall_6_3_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:484:6: ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:484:6: ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:484:7: ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )*
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:484:7: ( (lv_values_28_0= ruleValues ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:485:1: (lv_values_28_0= ruleValues )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:485:1: (lv_values_28_0= ruleValues )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:486:3: lv_values_28_0= ruleValues
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValues_in_ruleBuildEntry790);
                            lv_values_28_0=ruleValues();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"values",
                                    		lv_values_28_0, 
                                    		"Values");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:502:2: ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )*
                            loop8:
                            do {
                                int alt8=2;
                                alt8 = dfa8.predict(input);
                                switch (alt8) {
                            	case 1 :
                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:503:5: ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) )
                            	    {
                            	     
                            	            newCompositeNode(grammarAccess.getBuildEntryAccess().getEolParserRuleCall_6_3_1_1_0()); 
                            	        
                            	    pushFollow(FOLLOW_ruleEol_in_ruleBuildEntry807);
                            	    ruleEol();

                            	    state._fsp--;

                            	     
                            	            afterParserOrEnumRuleCall();
                            	        
                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:510:1: (this_TAB_30= RULE_TAB )+
                            	    int cnt7=0;
                            	    loop7:
                            	    do {
                            	        int alt7=2;
                            	        int LA7_0 = input.LA(1);

                            	        if ( (LA7_0==RULE_TAB) ) {
                            	            alt7=1;
                            	        }


                            	        switch (alt7) {
                            	    	case 1 :
                            	    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:510:2: this_TAB_30= RULE_TAB
                            	    	    {
                            	    	    this_TAB_30=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleBuildEntry818); 
                            	    	     
                            	    	        newLeafNode(this_TAB_30, grammarAccess.getBuildEntryAccess().getTABTerminalRuleCall_6_3_1_1_1()); 
                            	    	        

                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    if ( cnt7 >= 1 ) break loop7;
                            	                EarlyExitException eee =
                            	                    new EarlyExitException(7, input);
                            	                throw eee;
                            	        }
                            	        cnt7++;
                            	    } while (true);

                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:514:3: ( (lv_values_31_0= ruleValues ) )
                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:515:1: (lv_values_31_0= ruleValues )
                            	    {
                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:515:1: (lv_values_31_0= ruleValues )
                            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:516:3: lv_values_31_0= ruleValues
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValuesValuesParserRuleCall_6_3_1_1_2_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleValues_in_ruleBuildEntry840);
                            	    lv_values_31_0=ruleValues();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"values",
                            	            		lv_values_31_0, 
                            	            		"Values");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 8 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:533:6: ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:533:6: ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:533:7: () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:533:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:534:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getBuildEntryAccess().getMyVariableAction_7_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:539:2: ( (lv_name_33_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:540:1: (lv_name_33_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:540:1: (lv_name_33_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:541:3: lv_name_33_0= RULE_SYMBOL
                    {
                    lv_name_33_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleBuildEntry878); 

                    			newLeafNode(lv_name_33_0, grammarAccess.getBuildEntryAccess().getNameSYMBOLTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBuildEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_33_0, 
                            		"SYMBOL");
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:557:2: ( (lv_variable_34_0= ruleVariable ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==RULE_DOLLAR) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:558:1: (lv_variable_34_0= ruleVariable )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:558:1: (lv_variable_34_0= ruleVariable )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:559:3: lv_variable_34_0= ruleVariable
                            {
                             
                            	        newCompositeNode(grammarAccess.getBuildEntryAccess().getVariableVariableParserRuleCall_7_2_0()); 
                            	    
                            pushFollow(FOLLOW_ruleVariable_in_ruleBuildEntry904);
                            lv_variable_34_0=ruleVariable();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"variable",
                                    		lv_variable_34_0, 
                                    		"Variable");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:575:3: ( (lv_value_35_0= ruleAssign ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:576:1: (lv_value_35_0= ruleAssign )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:576:1: (lv_value_35_0= ruleAssign )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:577:3: lv_value_35_0= ruleAssign
                    {
                     
                    	        newCompositeNode(grammarAccess.getBuildEntryAccess().getValueAssignParserRuleCall_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAssign_in_ruleBuildEntry926);
                    lv_value_35_0=ruleAssign();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBuildEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_35_0, 
                            		"Assign");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuildEntry"


    // $ANTLR start "entryRuleEntry"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:601:1: entryRuleEntry returns [EObject current=null] : iv_ruleEntry= ruleEntry EOF ;
    public final EObject entryRuleEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntry = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:602:2: (iv_ruleEntry= ruleEntry EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:603:2: iv_ruleEntry= ruleEntry EOF
            {
             newCompositeNode(grammarAccess.getEntryRule()); 
            pushFollow(FOLLOW_ruleEntry_in_entryRuleEntry963);
            iv_ruleEntry=ruleEntry();

            state._fsp--;

             current =iv_ruleEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntry973); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntry"


    // $ANTLR start "ruleEntry"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:610:1: ruleEntry returns [EObject current=null] : ( () this_OBJ_START_1= RULE_OBJ_START ( (lv_variable_2_0= ruleVariable ) ) ( (lv_value_3_0= ruleAssignExtra ) ) ) ;
    public final EObject ruleEntry() throws RecognitionException {
        EObject current = null;

        Token this_OBJ_START_1=null;
        EObject lv_variable_2_0 = null;

        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:613:28: ( ( () this_OBJ_START_1= RULE_OBJ_START ( (lv_variable_2_0= ruleVariable ) ) ( (lv_value_3_0= ruleAssignExtra ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:614:1: ( () this_OBJ_START_1= RULE_OBJ_START ( (lv_variable_2_0= ruleVariable ) ) ( (lv_value_3_0= ruleAssignExtra ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:614:1: ( () this_OBJ_START_1= RULE_OBJ_START ( (lv_variable_2_0= ruleVariable ) ) ( (lv_value_3_0= ruleAssignExtra ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:614:2: () this_OBJ_START_1= RULE_OBJ_START ( (lv_variable_2_0= ruleVariable ) ) ( (lv_value_3_0= ruleAssignExtra ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:614:2: ()
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:615:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEntryAccess().getEntryAction_0(),
                        current);
                

            }

            this_OBJ_START_1=(Token)match(input,RULE_OBJ_START,FOLLOW_RULE_OBJ_START_in_ruleEntry1018); 
             
                newLeafNode(this_OBJ_START_1, grammarAccess.getEntryAccess().getOBJ_STARTTerminalRuleCall_1()); 
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:624:1: ( (lv_variable_2_0= ruleVariable ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:625:1: (lv_variable_2_0= ruleVariable )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:625:1: (lv_variable_2_0= ruleVariable )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:626:3: lv_variable_2_0= ruleVariable
            {
             
            	        newCompositeNode(grammarAccess.getEntryAccess().getVariableVariableParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleVariable_in_ruleEntry1038);
            lv_variable_2_0=ruleVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEntryRule());
            	        }
                   		set(
                   			current, 
                   			"variable",
                    		lv_variable_2_0, 
                    		"Variable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:642:2: ( (lv_value_3_0= ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:643:1: (lv_value_3_0= ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:643:1: (lv_value_3_0= ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:644:3: lv_value_3_0= ruleAssignExtra
            {
             
            	        newCompositeNode(grammarAccess.getEntryAccess().getValueAssignExtraParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignExtra_in_ruleEntry1059);
            lv_value_3_0=ruleAssignExtra();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getEntryRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"AssignExtra");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntry"


    // $ANTLR start "entryRuleIf"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:668:1: entryRuleIf returns [EObject current=null] : iv_ruleIf= ruleIf EOF ;
    public final EObject entryRuleIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:669:2: (iv_ruleIf= ruleIf EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:670:2: iv_ruleIf= ruleIf EOF
            {
             newCompositeNode(grammarAccess.getIfRule()); 
            pushFollow(FOLLOW_ruleIf_in_entryRuleIf1095);
            iv_ruleIf=ruleIf();

            state._fsp--;

             current =iv_ruleIf; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIf1105); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf"


    // $ANTLR start "ruleIf"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:677:1: ruleIf returns [EObject current=null] : (this_BRACE_START_0= RULE_BRACE_START ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) ) this_BRACE_END_7= RULE_BRACE_END ruleEol (this_TAB_9= RULE_TAB )* ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) ) ruleEol (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )? this_ENDIF_21= RULE_ENDIF ) ;
    public final EObject ruleIf() throws RecognitionException {
        EObject current = null;

        Token this_BRACE_START_0=null;
        Token this_COMMA_2=null;
        Token this_Y_3=null;
        Token this_M_4=null;
        Token this_COMMA_6=null;
        Token this_BRACE_END_7=null;
        Token this_TAB_9=null;
        Token this_ELSE_15=null;
        Token this_TAB_17=null;
        Token this_ENDIF_21=null;
        EObject this_Variable_1 = null;

        EObject lv_shell_5_0 = null;

        EObject lv_value_10_0 = null;

        EObject lv_value_11_0 = null;

        EObject lv_value_12_0 = null;

        EObject lv_value_13_0 = null;

        EObject lv_elsevalue_18_0 = null;

        EObject lv_elsevalue_19_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:680:28: ( (this_BRACE_START_0= RULE_BRACE_START ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) ) this_BRACE_END_7= RULE_BRACE_END ruleEol (this_TAB_9= RULE_TAB )* ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) ) ruleEol (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )? this_ENDIF_21= RULE_ENDIF ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:681:1: (this_BRACE_START_0= RULE_BRACE_START ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) ) this_BRACE_END_7= RULE_BRACE_END ruleEol (this_TAB_9= RULE_TAB )* ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) ) ruleEol (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )? this_ENDIF_21= RULE_ENDIF )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:681:1: (this_BRACE_START_0= RULE_BRACE_START ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) ) this_BRACE_END_7= RULE_BRACE_END ruleEol (this_TAB_9= RULE_TAB )* ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) ) ruleEol (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )? this_ENDIF_21= RULE_ENDIF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:681:2: this_BRACE_START_0= RULE_BRACE_START ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) ) this_BRACE_END_7= RULE_BRACE_END ruleEol (this_TAB_9= RULE_TAB )* ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) ) ruleEol (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )? this_ENDIF_21= RULE_ENDIF
            {
            this_BRACE_START_0=(Token)match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_ruleIf1141); 
             
                newLeafNode(this_BRACE_START_0, grammarAccess.getIfAccess().getBRACE_STARTTerminalRuleCall_0()); 
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:685:1: ( (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) ) | ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_DOLLAR) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==RULE_BRACE_START) ) {
                    int LA14_3 = input.LA(3);

                    if ( (LA14_3==RULE_SYMBOL) ) {
                        int LA14_5 = input.LA(4);

                        if ( (LA14_5==RULE_BRACE_END) ) {
                            alt14=1;
                        }
                        else if ( (LA14_5==RULE_SYMBOL||LA14_5==RULE_COMMA||LA14_5==RULE_BACKSLASH||(LA14_5>=RULE_SLASH && LA14_5<=RULE_INCLUDE)) ) {
                            alt14=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA14_1==RULE_SYMBOL) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA14_0==RULE_INCLUDE) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:685:2: (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:685:2: (this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:686:5: this_Variable_1= ruleVariable this_COMMA_2= RULE_COMMA (this_Y_3= RULE_Y | this_M_4= RULE_M )
                    {
                     
                            newCompositeNode(grammarAccess.getIfAccess().getVariableParserRuleCall_1_0_0()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleIf1164);
                    this_Variable_1=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_1; 
                            afterParserOrEnumRuleCall();
                        
                    this_COMMA_2=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleIf1174); 
                     
                        newLeafNode(this_COMMA_2, grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_0_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:698:1: (this_Y_3= RULE_Y | this_M_4= RULE_M )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE_Y) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_M) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:698:2: this_Y_3= RULE_Y
                            {
                            this_Y_3=(Token)match(input,RULE_Y,FOLLOW_RULE_Y_in_ruleIf1185); 
                             
                                newLeafNode(this_Y_3, grammarAccess.getIfAccess().getYTerminalRuleCall_1_0_2_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:703:6: this_M_4= RULE_M
                            {
                            this_M_4=(Token)match(input,RULE_M,FOLLOW_RULE_M_in_ruleIf1201); 
                             
                                newLeafNode(this_M_4, grammarAccess.getIfAccess().getMTerminalRuleCall_1_0_2_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:708:6: ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:708:6: ( ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )? )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:708:7: ( (lv_shell_5_0= ruleShellCmd ) ) (this_COMMA_6= RULE_COMMA )?
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:708:7: ( (lv_shell_5_0= ruleShellCmd ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:709:1: (lv_shell_5_0= ruleShellCmd )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:709:1: (lv_shell_5_0= ruleShellCmd )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:710:3: lv_shell_5_0= ruleShellCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfAccess().getShellShellCmdParserRuleCall_1_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShellCmd_in_ruleIf1230);
                    lv_shell_5_0=ruleShellCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfRule());
                    	        }
                           		set(
                           			current, 
                           			"shell",
                            		lv_shell_5_0, 
                            		"ShellCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:726:2: (this_COMMA_6= RULE_COMMA )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_COMMA) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:726:3: this_COMMA_6= RULE_COMMA
                            {
                            this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleIf1242); 
                             
                                newLeafNode(this_COMMA_6, grammarAccess.getIfAccess().getCOMMATerminalRuleCall_1_1_1()); 
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            this_BRACE_END_7=(Token)match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_ruleIf1256); 
             
                newLeafNode(this_BRACE_END_7, grammarAccess.getIfAccess().getBRACE_ENDTerminalRuleCall_2()); 
                
             
                    newCompositeNode(grammarAccess.getIfAccess().getEolParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleEol_in_ruleIf1271);
            ruleEol();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:742:1: (this_TAB_9= RULE_TAB )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_TAB) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:742:2: this_TAB_9= RULE_TAB
            	    {
            	    this_TAB_9=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleIf1282); 
            	     
            	        newLeafNode(this_TAB_9, grammarAccess.getIfAccess().getTABTerminalRuleCall_4()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:746:3: ( ( (lv_value_10_0= ruleObject_Y ) ) | ( (lv_value_11_0= ruleObject_M ) ) | ( (lv_value_12_0= ruleEntry ) ) | ( (lv_value_13_0= ruleShellCmd ) ) )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_OBJ_Y:
                {
                alt16=1;
                }
                break;
            case RULE_OBJ_M:
                {
                alt16=2;
                }
                break;
            case RULE_OBJ_START:
                {
                alt16=3;
                }
                break;
            case RULE_DOLLAR:
            case RULE_INCLUDE:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:746:4: ( (lv_value_10_0= ruleObject_Y ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:746:4: ( (lv_value_10_0= ruleObject_Y ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:747:1: (lv_value_10_0= ruleObject_Y )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:747:1: (lv_value_10_0= ruleObject_Y )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:748:3: lv_value_10_0= ruleObject_Y
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfAccess().getValueObject_YParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleObject_Y_in_ruleIf1305);
                    lv_value_10_0=ruleObject_Y();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_10_0, 
                            		"Object_Y");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:765:6: ( (lv_value_11_0= ruleObject_M ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:765:6: ( (lv_value_11_0= ruleObject_M ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:766:1: (lv_value_11_0= ruleObject_M )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:766:1: (lv_value_11_0= ruleObject_M )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:767:3: lv_value_11_0= ruleObject_M
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfAccess().getValueObject_MParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleObject_M_in_ruleIf1332);
                    lv_value_11_0=ruleObject_M();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_11_0, 
                            		"Object_M");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:784:6: ( (lv_value_12_0= ruleEntry ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:784:6: ( (lv_value_12_0= ruleEntry ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:785:1: (lv_value_12_0= ruleEntry )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:785:1: (lv_value_12_0= ruleEntry )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:786:3: lv_value_12_0= ruleEntry
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfAccess().getValueEntryParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEntry_in_ruleIf1359);
                    lv_value_12_0=ruleEntry();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_12_0, 
                            		"Entry");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:803:6: ( (lv_value_13_0= ruleShellCmd ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:803:6: ( (lv_value_13_0= ruleShellCmd ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:804:1: (lv_value_13_0= ruleShellCmd )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:804:1: (lv_value_13_0= ruleShellCmd )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:805:3: lv_value_13_0= ruleShellCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getIfAccess().getValueShellCmdParserRuleCall_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShellCmd_in_ruleIf1386);
                    lv_value_13_0=ruleShellCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getIfRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_13_0, 
                            		"ShellCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getIfAccess().getEolParserRuleCall_6()); 
                
            pushFollow(FOLLOW_ruleEol_in_ruleIf1403);
            ruleEol();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:829:1: (this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ELSE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:829:2: this_ELSE_15= RULE_ELSE ruleEol (this_TAB_17= RULE_TAB )* ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) ) ruleEol
                    {
                    this_ELSE_15=(Token)match(input,RULE_ELSE,FOLLOW_RULE_ELSE_in_ruleIf1414); 
                     
                        newLeafNode(this_ELSE_15, grammarAccess.getIfAccess().getELSETerminalRuleCall_7_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getIfAccess().getEolParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleIf1429);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:841:1: (this_TAB_17= RULE_TAB )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_TAB) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:841:2: this_TAB_17= RULE_TAB
                    	    {
                    	    this_TAB_17=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleIf1440); 
                    	     
                    	        newLeafNode(this_TAB_17, grammarAccess.getIfAccess().getTABTerminalRuleCall_7_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:845:3: ( ( (lv_elsevalue_18_0= ruleObject_Y ) ) | ( (lv_elsevalue_19_0= ruleObject_M ) ) )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==RULE_OBJ_Y) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==RULE_OBJ_M) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:845:4: ( (lv_elsevalue_18_0= ruleObject_Y ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:845:4: ( (lv_elsevalue_18_0= ruleObject_Y ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:846:1: (lv_elsevalue_18_0= ruleObject_Y )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:846:1: (lv_elsevalue_18_0= ruleObject_Y )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:847:3: lv_elsevalue_18_0= ruleObject_Y
                            {
                             
                            	        newCompositeNode(grammarAccess.getIfAccess().getElsevalueObject_YParserRuleCall_7_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_Y_in_ruleIf1463);
                            lv_elsevalue_18_0=ruleObject_Y();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getIfRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"elsevalue",
                                    		lv_elsevalue_18_0, 
                                    		"Object_Y");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:864:6: ( (lv_elsevalue_19_0= ruleObject_M ) )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:864:6: ( (lv_elsevalue_19_0= ruleObject_M ) )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:865:1: (lv_elsevalue_19_0= ruleObject_M )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:865:1: (lv_elsevalue_19_0= ruleObject_M )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:866:3: lv_elsevalue_19_0= ruleObject_M
                            {
                             
                            	        newCompositeNode(grammarAccess.getIfAccess().getElsevalueObject_MParserRuleCall_7_3_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleObject_M_in_ruleIf1490);
                            lv_elsevalue_19_0=ruleObject_M();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getIfRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"elsevalue",
                                    		lv_elsevalue_19_0, 
                                    		"Object_M");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getIfAccess().getEolParserRuleCall_7_4()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleIf1507);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            this_ENDIF_21=(Token)match(input,RULE_ENDIF,FOLLOW_RULE_ENDIF_in_ruleIf1519); 
             
                newLeafNode(this_ENDIF_21, grammarAccess.getIfAccess().getENDIFTerminalRuleCall_8()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf"


    // $ANTLR start "entryRuleObject_Y"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:902:1: entryRuleObject_Y returns [EObject current=null] : iv_ruleObject_Y= ruleObject_Y EOF ;
    public final EObject entryRuleObject_Y() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject_Y = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:903:2: (iv_ruleObject_Y= ruleObject_Y EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:904:2: iv_ruleObject_Y= ruleObject_Y EOF
            {
             newCompositeNode(grammarAccess.getObject_YRule()); 
            pushFollow(FOLLOW_ruleObject_Y_in_entryRuleObject_Y1554);
            iv_ruleObject_Y=ruleObject_Y();

            state._fsp--;

             current =iv_ruleObject_Y; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject_Y1564); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject_Y"


    // $ANTLR start "ruleObject_Y"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:911:1: ruleObject_Y returns [EObject current=null] : ( () this_OBJ_Y_1= RULE_OBJ_Y ( (lv_value_2_0= ruleAssignExtra ) ) ) ;
    public final EObject ruleObject_Y() throws RecognitionException {
        EObject current = null;

        Token this_OBJ_Y_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:914:28: ( ( () this_OBJ_Y_1= RULE_OBJ_Y ( (lv_value_2_0= ruleAssignExtra ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:915:1: ( () this_OBJ_Y_1= RULE_OBJ_Y ( (lv_value_2_0= ruleAssignExtra ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:915:1: ( () this_OBJ_Y_1= RULE_OBJ_Y ( (lv_value_2_0= ruleAssignExtra ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:915:2: () this_OBJ_Y_1= RULE_OBJ_Y ( (lv_value_2_0= ruleAssignExtra ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:915:2: ()
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:916:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObject_YAccess().getObj_yAction_0(),
                        current);
                

            }

            this_OBJ_Y_1=(Token)match(input,RULE_OBJ_Y,FOLLOW_RULE_OBJ_Y_in_ruleObject_Y1609); 
             
                newLeafNode(this_OBJ_Y_1, grammarAccess.getObject_YAccess().getOBJ_YTerminalRuleCall_1()); 
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:925:1: ( (lv_value_2_0= ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:926:1: (lv_value_2_0= ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:926:1: (lv_value_2_0= ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:927:3: lv_value_2_0= ruleAssignExtra
            {
             
            	        newCompositeNode(grammarAccess.getObject_YAccess().getValueAssignExtraParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignExtra_in_ruleObject_Y1629);
            lv_value_2_0=ruleAssignExtra();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObject_YRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"AssignExtra");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject_Y"


    // $ANTLR start "entryRuleObject_M"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:951:1: entryRuleObject_M returns [EObject current=null] : iv_ruleObject_M= ruleObject_M EOF ;
    public final EObject entryRuleObject_M() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject_M = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:952:2: (iv_ruleObject_M= ruleObject_M EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:953:2: iv_ruleObject_M= ruleObject_M EOF
            {
             newCompositeNode(grammarAccess.getObject_MRule()); 
            pushFollow(FOLLOW_ruleObject_M_in_entryRuleObject_M1665);
            iv_ruleObject_M=ruleObject_M();

            state._fsp--;

             current =iv_ruleObject_M; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleObject_M1675); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject_M"


    // $ANTLR start "ruleObject_M"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:960:1: ruleObject_M returns [EObject current=null] : ( () this_OBJ_M_1= RULE_OBJ_M ( (lv_value_2_0= ruleAssignExtra ) ) ) ;
    public final EObject ruleObject_M() throws RecognitionException {
        EObject current = null;

        Token this_OBJ_M_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:963:28: ( ( () this_OBJ_M_1= RULE_OBJ_M ( (lv_value_2_0= ruleAssignExtra ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:964:1: ( () this_OBJ_M_1= RULE_OBJ_M ( (lv_value_2_0= ruleAssignExtra ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:964:1: ( () this_OBJ_M_1= RULE_OBJ_M ( (lv_value_2_0= ruleAssignExtra ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:964:2: () this_OBJ_M_1= RULE_OBJ_M ( (lv_value_2_0= ruleAssignExtra ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:964:2: ()
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:965:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObject_MAccess().getObj_mAction_0(),
                        current);
                

            }

            this_OBJ_M_1=(Token)match(input,RULE_OBJ_M,FOLLOW_RULE_OBJ_M_in_ruleObject_M1720); 
             
                newLeafNode(this_OBJ_M_1, grammarAccess.getObject_MAccess().getOBJ_MTerminalRuleCall_1()); 
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:974:1: ( (lv_value_2_0= ruleAssignExtra ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:975:1: (lv_value_2_0= ruleAssignExtra )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:975:1: (lv_value_2_0= ruleAssignExtra )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:976:3: lv_value_2_0= ruleAssignExtra
            {
             
            	        newCompositeNode(grammarAccess.getObject_MAccess().getValueAssignExtraParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleAssignExtra_in_ruleObject_M1740);
            lv_value_2_0=ruleAssignExtra();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObject_MRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"AssignExtra");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject_M"


    // $ANTLR start "entryRuleAssign"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1000:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1001:2: (iv_ruleAssign= ruleAssign EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1002:2: iv_ruleAssign= ruleAssign EOF
            {
             newCompositeNode(grammarAccess.getAssignRule()); 
            pushFollow(FOLLOW_ruleAssign_in_entryRuleAssign1776);
            iv_ruleAssign=ruleAssign();

            state._fsp--;

             current =iv_ruleAssign; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssign1786); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1009:1: ruleAssign returns [EObject current=null] : (this_EQ_0= RULE_EQ (this_TAB_1= RULE_TAB )* this_Values_2= ruleValues ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token this_EQ_0=null;
        Token this_TAB_1=null;
        EObject this_Values_2 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1012:28: ( (this_EQ_0= RULE_EQ (this_TAB_1= RULE_TAB )* this_Values_2= ruleValues ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1013:1: (this_EQ_0= RULE_EQ (this_TAB_1= RULE_TAB )* this_Values_2= ruleValues )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1013:1: (this_EQ_0= RULE_EQ (this_TAB_1= RULE_TAB )* this_Values_2= ruleValues )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1013:2: this_EQ_0= RULE_EQ (this_TAB_1= RULE_TAB )* this_Values_2= ruleValues
            {
            this_EQ_0=(Token)match(input,RULE_EQ,FOLLOW_RULE_EQ_in_ruleAssign1822); 
             
                newLeafNode(this_EQ_0, grammarAccess.getAssignAccess().getEQTerminalRuleCall_0()); 
                
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1017:1: (this_TAB_1= RULE_TAB )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_TAB) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1017:2: this_TAB_1= RULE_TAB
            	    {
            	    this_TAB_1=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleAssign1833); 
            	     
            	        newLeafNode(this_TAB_1, grammarAccess.getAssignAccess().getTABTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getAssignAccess().getValuesParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleValues_in_ruleAssign1856);
            this_Values_2=ruleValues();

            state._fsp--;

             
                    current = this_Values_2; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleAssignExtra"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1038:1: entryRuleAssignExtra returns [EObject current=null] : iv_ruleAssignExtra= ruleAssignExtra EOF ;
    public final EObject entryRuleAssignExtra() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignExtra = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1039:2: (iv_ruleAssignExtra= ruleAssignExtra EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1040:2: iv_ruleAssignExtra= ruleAssignExtra EOF
            {
             newCompositeNode(grammarAccess.getAssignExtraRule()); 
            pushFollow(FOLLOW_ruleAssignExtra_in_entryRuleAssignExtra1891);
            iv_ruleAssignExtra=ruleAssignExtra();

            state._fsp--;

             current =iv_ruleAssignExtra; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignExtra1901); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignExtra"


    // $ANTLR start "ruleAssignExtra"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1047:1: ruleAssignExtra returns [EObject current=null] : ( (this_TAB_0= RULE_TAB )* (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT ) this_Assign_3= ruleAssign ) ;
    public final EObject ruleAssignExtra() throws RecognitionException {
        EObject current = null;

        Token this_TAB_0=null;
        Token this_PLUS_1=null;
        Token this_DPOINT_2=null;
        EObject this_Assign_3 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1050:28: ( ( (this_TAB_0= RULE_TAB )* (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT ) this_Assign_3= ruleAssign ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1051:1: ( (this_TAB_0= RULE_TAB )* (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT ) this_Assign_3= ruleAssign )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1051:1: ( (this_TAB_0= RULE_TAB )* (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT ) this_Assign_3= ruleAssign )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1051:2: (this_TAB_0= RULE_TAB )* (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT ) this_Assign_3= ruleAssign
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1051:2: (this_TAB_0= RULE_TAB )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_TAB) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1051:3: this_TAB_0= RULE_TAB
            	    {
            	    this_TAB_0=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleAssignExtra1938); 
            	     
            	        newLeafNode(this_TAB_0, grammarAccess.getAssignExtraAccess().getTABTerminalRuleCall_0()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1055:3: (this_PLUS_1= RULE_PLUS | this_DPOINT_2= RULE_DPOINT )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_PLUS) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_DPOINT) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1055:4: this_PLUS_1= RULE_PLUS
                    {
                    this_PLUS_1=(Token)match(input,RULE_PLUS,FOLLOW_RULE_PLUS_in_ruleAssignExtra1951); 
                     
                        newLeafNode(this_PLUS_1, grammarAccess.getAssignExtraAccess().getPLUSTerminalRuleCall_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1060:6: this_DPOINT_2= RULE_DPOINT
                    {
                    this_DPOINT_2=(Token)match(input,RULE_DPOINT,FOLLOW_RULE_DPOINT_in_ruleAssignExtra1967); 
                     
                        newLeafNode(this_DPOINT_2, grammarAccess.getAssignExtraAccess().getDPOINTTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getAssignExtraAccess().getAssignParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleAssign_in_ruleAssignExtra1989);
            this_Assign_3=ruleAssign();

            state._fsp--;

             
                    current = this_Assign_3; 
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignExtra"


    // $ANTLR start "entryRuleValues"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1081:1: entryRuleValues returns [EObject current=null] : iv_ruleValues= ruleValues EOF ;
    public final EObject entryRuleValues() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValues = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1082:2: (iv_ruleValues= ruleValues EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1083:2: iv_ruleValues= ruleValues EOF
            {
             newCompositeNode(grammarAccess.getValuesRule()); 
            pushFollow(FOLLOW_ruleValues_in_entryRuleValues2024);
            iv_ruleValues=ruleValues();

            state._fsp--;

             current =iv_ruleValues; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValues2034); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValues"


    // $ANTLR start "ruleValues"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1090:1: ruleValues returns [EObject current=null] : ( (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )? ( (lv_values_3_0= ruleValue ) )+ (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )* ) ;
    public final EObject ruleValues() throws RecognitionException {
        EObject current = null;

        Token this_BACKSLASH_0=null;
        Token this_TAB_2=null;
        Token this_BACKSLASH_4=null;
        Token this_TAB_6=null;
        EObject lv_values_3_0 = null;

        EObject lv_values_7_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1093:28: ( ( (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )? ( (lv_values_3_0= ruleValue ) )+ (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )* ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1094:1: ( (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )? ( (lv_values_3_0= ruleValue ) )+ (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )* )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1094:1: ( (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )? ( (lv_values_3_0= ruleValue ) )+ (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )* )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1094:2: (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )? ( (lv_values_3_0= ruleValue ) )+ (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )*
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1094:2: (this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_BACKSLASH) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1094:3: this_BACKSLASH_0= RULE_BACKSLASH ruleEol (this_TAB_2= RULE_TAB )*
                    {
                    this_BACKSLASH_0=(Token)match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_ruleValues2071); 
                     
                        newLeafNode(this_BACKSLASH_0, grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_0_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getValuesAccess().getEolParserRuleCall_0_1()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleValues2086);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1106:1: (this_TAB_2= RULE_TAB )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_TAB) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1106:2: this_TAB_2= RULE_TAB
                    	    {
                    	    this_TAB_2=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleValues2097); 
                    	     
                    	        newLeafNode(this_TAB_2, grammarAccess.getValuesAccess().getTABTerminalRuleCall_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1110:5: ( (lv_values_3_0= ruleValue ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_SYMBOL||(LA25_0>=RULE_STRING && LA25_0<=RULE_INCLUDE)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1111:1: (lv_values_3_0= ruleValue )
            	    {
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1111:1: (lv_values_3_0= ruleValue )
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1112:3: lv_values_3_0= ruleValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValue_in_ruleValues2121);
            	    lv_values_3_0=ruleValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getValuesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_3_0, 
            	            		"Value");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1128:3: (this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+ )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_BACKSLASH) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1128:4: this_BACKSLASH_4= RULE_BACKSLASH ruleEol (this_TAB_6= RULE_TAB )* ( (lv_values_7_0= ruleValue ) )+
            	    {
            	    this_BACKSLASH_4=(Token)match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_ruleValues2134); 
            	     
            	        newLeafNode(this_BACKSLASH_4, grammarAccess.getValuesAccess().getBACKSLASHTerminalRuleCall_2_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getValuesAccess().getEolParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleEol_in_ruleValues2149);
            	    ruleEol();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1140:1: (this_TAB_6= RULE_TAB )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==RULE_TAB) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1140:2: this_TAB_6= RULE_TAB
            	    	    {
            	    	    this_TAB_6=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleValues2160); 
            	    	     
            	    	        newLeafNode(this_TAB_6, grammarAccess.getValuesAccess().getTABTerminalRuleCall_2_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);

            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1144:3: ( (lv_values_7_0= ruleValue ) )+
            	    int cnt27=0;
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==RULE_SYMBOL||(LA27_0>=RULE_STRING && LA27_0<=RULE_INCLUDE)) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1145:1: (lv_values_7_0= ruleValue )
            	    	    {
            	    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1145:1: (lv_values_7_0= ruleValue )
            	    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1146:3: lv_values_7_0= ruleValue
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getValuesAccess().getValuesValueParserRuleCall_2_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValue_in_ruleValues2182);
            	    	    lv_values_7_0=ruleValue();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getValuesRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"values",
            	    	            		lv_values_7_0, 
            	    	            		"Value");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt27 >= 1 ) break loop27;
            	                EarlyExitException eee =
            	                    new EarlyExitException(27, input);
            	                throw eee;
            	        }
            	        cnt27++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValues"


    // $ANTLR start "entryRuleValue"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1170:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1171:2: (iv_ruleValue= ruleValue EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1172:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue2221);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2231); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1179:1: ruleValue returns [EObject current=null] : ( ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE ) | ( () ( (lv_name_4_0= RULE_SYMBOL ) ) ) | ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? ) | ( () ( (lv_value_9_0= ruleShellCmd ) ) ) | ( () this_STRING_11= RULE_STRING ) | ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) ) | ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH ) ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        Token this_SYMBOL_1=null;
        Token this_OBJ_FILE_2=null;
        Token lv_name_4_0=null;
        Token lv_additional_7_0=null;
        Token this_STRING_11=null;
        Token lv_value_13_0=null;
        Token this_SYMBOL_15=null;
        Token this_SLASH_16=null;
        EObject lv_value_6_0 = null;

        EObject lv_value_9_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1182:28: ( ( ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE ) | ( () ( (lv_name_4_0= RULE_SYMBOL ) ) ) | ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? ) | ( () ( (lv_value_9_0= ruleShellCmd ) ) ) | ( () this_STRING_11= RULE_STRING ) | ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) ) | ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:1: ( ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE ) | ( () ( (lv_name_4_0= RULE_SYMBOL ) ) ) | ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? ) | ( () ( (lv_value_9_0= ruleShellCmd ) ) ) | ( () this_STRING_11= RULE_STRING ) | ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) ) | ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:1: ( ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE ) | ( () ( (lv_name_4_0= RULE_SYMBOL ) ) ) | ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? ) | ( () ( (lv_value_9_0= ruleShellCmd ) ) ) | ( () this_STRING_11= RULE_STRING ) | ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) ) | ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH ) )
            int alt30=7;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:2: ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:2: ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:3: () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1183:3: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1184:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectFileAction_0_0(),
                                current);
                        

                    }

                    this_SYMBOL_1=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleValue2277); 
                     
                        newLeafNode(this_SYMBOL_1, grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_0_1()); 
                        
                    this_OBJ_FILE_2=(Token)match(input,RULE_OBJ_FILE,FOLLOW_RULE_OBJ_FILE_in_ruleValue2287); 
                     
                        newLeafNode(this_OBJ_FILE_2, grammarAccess.getValueAccess().getOBJ_FILETerminalRuleCall_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1198:6: ( () ( (lv_name_4_0= RULE_SYMBOL ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1198:6: ( () ( (lv_name_4_0= RULE_SYMBOL ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1198:7: () ( (lv_name_4_0= RULE_SYMBOL ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1198:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1199:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectSingleFileAction_1_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1204:2: ( (lv_name_4_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1205:1: (lv_name_4_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1205:1: (lv_name_4_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1206:3: lv_name_4_0= RULE_SYMBOL
                    {
                    lv_name_4_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleValue2320); 

                    			newLeafNode(lv_name_4_0, grammarAccess.getValueAccess().getNameSYMBOLTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_4_0, 
                            		"SYMBOL");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1223:6: ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1223:6: ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1223:7: () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )?
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1223:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1224:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectVariableAction_2_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1229:2: ( (lv_value_6_0= ruleVariable ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1230:1: (lv_value_6_0= ruleVariable )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1230:1: (lv_value_6_0= ruleVariable )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1231:3: lv_value_6_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getValueVariableParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue2363);
                    lv_value_6_0=ruleVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_6_0, 
                            		"Variable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1247:2: ( (lv_additional_7_0= RULE_SLASH ) )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_SLASH) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1248:1: (lv_additional_7_0= RULE_SLASH )
                            {
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1248:1: (lv_additional_7_0= RULE_SLASH )
                            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1249:3: lv_additional_7_0= RULE_SLASH
                            {
                            lv_additional_7_0=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleValue2380); 

                            			newLeafNode(lv_additional_7_0, grammarAccess.getValueAccess().getAdditionalSLASHTerminalRuleCall_2_2_0()); 
                            		

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getValueRule());
                            	        }
                                   		setWithLastConsumed(
                                   			current, 
                                   			"additional",
                                    		lv_additional_7_0, 
                                    		"SLASH");
                            	    

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1266:6: ( () ( (lv_value_9_0= ruleShellCmd ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1266:6: ( () ( (lv_value_9_0= ruleShellCmd ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1266:7: () ( (lv_value_9_0= ruleShellCmd ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1266:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1267:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectShellCmdAction_3_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1272:2: ( (lv_value_9_0= ruleShellCmd ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1273:1: (lv_value_9_0= ruleShellCmd )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1273:1: (lv_value_9_0= ruleShellCmd )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1274:3: lv_value_9_0= ruleShellCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getValueAccess().getValueShellCmdParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShellCmd_in_ruleValue2424);
                    lv_value_9_0=ruleShellCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getValueRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_9_0, 
                            		"ShellCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1291:6: ( () this_STRING_11= RULE_STRING )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1291:6: ( () this_STRING_11= RULE_STRING )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1291:7: () this_STRING_11= RULE_STRING
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1291:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1292:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectStringAction_4_0(),
                                current);
                        

                    }

                    this_STRING_11=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValue2452); 
                     
                        newLeafNode(this_STRING_11, grammarAccess.getValueAccess().getSTRINGTerminalRuleCall_4_1()); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1302:6: ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1302:6: ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1302:7: () ( (lv_value_13_0= RULE_SHELL_CHAR ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1302:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1303:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectShellCharAction_5_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1308:2: ( (lv_value_13_0= RULE_SHELL_CHAR ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1309:1: (lv_value_13_0= RULE_SHELL_CHAR )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1309:1: (lv_value_13_0= RULE_SHELL_CHAR )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1310:3: lv_value_13_0= RULE_SHELL_CHAR
                    {
                    lv_value_13_0=(Token)match(input,RULE_SHELL_CHAR,FOLLOW_RULE_SHELL_CHAR_in_ruleValue2485); 

                    			newLeafNode(lv_value_13_0, grammarAccess.getValueAccess().getValueSHELL_CHARTerminalRuleCall_5_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"value",
                            		lv_value_13_0, 
                            		"SHELL_CHAR");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1327:6: ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1327:6: ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1327:7: () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1327:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1328:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getValueAccess().getObjectDirAction_6_0(),
                                current);
                        

                    }

                    this_SYMBOL_15=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleValue2518); 
                     
                        newLeafNode(this_SYMBOL_15, grammarAccess.getValueAccess().getSYMBOLTerminalRuleCall_6_1()); 
                        
                    this_SLASH_16=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleValue2528); 
                     
                        newLeafNode(this_SLASH_16, grammarAccess.getValueAccess().getSLASHTerminalRuleCall_6_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleVariable"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1349:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1350:2: (iv_ruleVariable= ruleVariable EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1351:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable2564);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable2574); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1358:1: ruleVariable returns [EObject current=null] : ( ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) ) | (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token this_DOLLAR_1=null;
        Token lv_name_2_0=null;
        Token this_DOLLAR_3=null;
        Token this_BRACE_START_4=null;
        Token lv_name_5_0=null;
        Token this_BRACE_END_6=null;

         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1361:28: ( ( ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) ) | (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:1: ( ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) ) | (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:1: ( ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) ) | (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END ) )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_DOLLAR) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==RULE_BRACE_START) ) {
                    alt31=2;
                }
                else if ( (LA31_1==RULE_SYMBOL) ) {
                    alt31=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:2: ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:2: ( () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:3: () this_DOLLAR_1= RULE_DOLLAR ( (lv_name_2_0= RULE_SYMBOL ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1362:3: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1363:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getVariableAccess().getVariableAction_0_0(),
                                current);
                        

                    }

                    this_DOLLAR_1=(Token)match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_ruleVariable2620); 
                     
                        newLeafNode(this_DOLLAR_1, grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_0_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1372:1: ( (lv_name_2_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1373:1: (lv_name_2_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1373:1: (lv_name_2_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1374:3: lv_name_2_0= RULE_SYMBOL
                    {
                    lv_name_2_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleVariable2636); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_0_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"SYMBOL");
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1391:6: (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1391:6: (this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1391:7: this_DOLLAR_3= RULE_DOLLAR this_BRACE_START_4= RULE_BRACE_START ( (lv_name_5_0= RULE_SYMBOL ) ) this_BRACE_END_6= RULE_BRACE_END
                    {
                    this_DOLLAR_3=(Token)match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_ruleVariable2660); 
                     
                        newLeafNode(this_DOLLAR_3, grammarAccess.getVariableAccess().getDOLLARTerminalRuleCall_1_0()); 
                        
                    this_BRACE_START_4=(Token)match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_ruleVariable2670); 
                     
                        newLeafNode(this_BRACE_START_4, grammarAccess.getVariableAccess().getBRACE_STARTTerminalRuleCall_1_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1399:1: ( (lv_name_5_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1400:1: (lv_name_5_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1400:1: (lv_name_5_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1401:3: lv_name_5_0= RULE_SYMBOL
                    {
                    lv_name_5_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleVariable2686); 

                    			newLeafNode(lv_name_5_0, grammarAccess.getVariableAccess().getNameSYMBOLTerminalRuleCall_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_5_0, 
                            		"SYMBOL");
                    	    

                    }


                    }

                    this_BRACE_END_6=(Token)match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_ruleVariable2702); 
                     
                        newLeafNode(this_BRACE_END_6, grammarAccess.getVariableAccess().getBRACE_ENDTerminalRuleCall_1_3()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleShellCmd"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1429:1: entryRuleShellCmd returns [EObject current=null] : iv_ruleShellCmd= ruleShellCmd EOF ;
    public final EObject entryRuleShellCmd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShellCmd = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1430:2: (iv_ruleShellCmd= ruleShellCmd EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1431:2: iv_ruleShellCmd= ruleShellCmd EOF
            {
             newCompositeNode(grammarAccess.getShellCmdRule()); 
            pushFollow(FOLLOW_ruleShellCmd_in_entryRuleShellCmd2738);
            iv_ruleShellCmd=ruleShellCmd();

            state._fsp--;

             current =iv_ruleShellCmd; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShellCmd2748); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShellCmd"


    // $ANTLR start "ruleShellCmd"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1438:1: ruleShellCmd returns [EObject current=null] : ( ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) ) | ( () this_INCLUDE_7= RULE_INCLUDE ) ) ;
    public final EObject ruleShellCmd() throws RecognitionException {
        EObject current = null;

        Token this_DOLLAR_1=null;
        Token this_BRACE_START_2=null;
        Token lv_name_3_0=null;
        Token this_BRACE_END_5=null;
        Token this_INCLUDE_7=null;
        EObject lv_shellPart_4_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1441:28: ( ( ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) ) | ( () this_INCLUDE_7= RULE_INCLUDE ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:1: ( ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) ) | ( () this_INCLUDE_7= RULE_INCLUDE ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:1: ( ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) ) | ( () this_INCLUDE_7= RULE_INCLUDE ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_DOLLAR) ) {
                alt33=1;
            }
            else if ( (LA33_0==RULE_INCLUDE) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:2: ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:2: ( () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:3: () (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1442:3: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1443:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getShellCmdAccess().getShellCmdAction_0_0(),
                                current);
                        

                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1448:2: (this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1448:3: this_DOLLAR_1= RULE_DOLLAR this_BRACE_START_2= RULE_BRACE_START ( (lv_name_3_0= RULE_SYMBOL ) ) ( (lv_shellPart_4_0= ruleShellPart ) )+ this_BRACE_END_5= RULE_BRACE_END
                    {
                    this_DOLLAR_1=(Token)match(input,RULE_DOLLAR,FOLLOW_RULE_DOLLAR_in_ruleShellCmd2795); 
                     
                        newLeafNode(this_DOLLAR_1, grammarAccess.getShellCmdAccess().getDOLLARTerminalRuleCall_0_1_0()); 
                        
                    this_BRACE_START_2=(Token)match(input,RULE_BRACE_START,FOLLOW_RULE_BRACE_START_in_ruleShellCmd2805); 
                     
                        newLeafNode(this_BRACE_START_2, grammarAccess.getShellCmdAccess().getBRACE_STARTTerminalRuleCall_0_1_1()); 
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1456:1: ( (lv_name_3_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1457:1: (lv_name_3_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1457:1: (lv_name_3_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1458:3: lv_name_3_0= RULE_SYMBOL
                    {
                    lv_name_3_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleShellCmd2821); 

                    			newLeafNode(lv_name_3_0, grammarAccess.getShellCmdAccess().getNameSYMBOLTerminalRuleCall_0_1_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShellCmdRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_3_0, 
                            		"SYMBOL");
                    	    

                    }


                    }

                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1474:2: ( (lv_shellPart_4_0= ruleShellPart ) )+
                    int cnt32=0;
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==RULE_SYMBOL||LA32_0==RULE_COMMA||LA32_0==RULE_BACKSLASH||(LA32_0>=RULE_SLASH && LA32_0<=RULE_INCLUDE)) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1475:1: (lv_shellPart_4_0= ruleShellPart )
                    	    {
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1475:1: (lv_shellPart_4_0= ruleShellPart )
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1476:3: lv_shellPart_4_0= ruleShellPart
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getShellCmdAccess().getShellPartShellPartParserRuleCall_0_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleShellPart_in_ruleShellCmd2847);
                    	    lv_shellPart_4_0=ruleShellPart();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getShellCmdRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"shellPart",
                    	            		lv_shellPart_4_0, 
                    	            		"ShellPart");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt32 >= 1 ) break loop32;
                                EarlyExitException eee =
                                    new EarlyExitException(32, input);
                                throw eee;
                        }
                        cnt32++;
                    } while (true);

                    this_BRACE_END_5=(Token)match(input,RULE_BRACE_END,FOLLOW_RULE_BRACE_END_in_ruleShellCmd2859); 
                     
                        newLeafNode(this_BRACE_END_5, grammarAccess.getShellCmdAccess().getBRACE_ENDTerminalRuleCall_0_1_4()); 
                        

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1497:6: ( () this_INCLUDE_7= RULE_INCLUDE )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1497:6: ( () this_INCLUDE_7= RULE_INCLUDE )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1497:7: () this_INCLUDE_7= RULE_INCLUDE
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1497:7: ()
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1498:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getShellCmdAccess().getIncludeAction_1_0(),
                                current);
                        

                    }

                    this_INCLUDE_7=(Token)match(input,RULE_INCLUDE,FOLLOW_RULE_INCLUDE_in_ruleShellCmd2887); 
                     
                        newLeafNode(this_INCLUDE_7, grammarAccess.getShellCmdAccess().getINCLUDETerminalRuleCall_1_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShellCmd"


    // $ANTLR start "entryRuleShellPart"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1515:1: entryRuleShellPart returns [EObject current=null] : iv_ruleShellPart= ruleShellPart EOF ;
    public final EObject entryRuleShellPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShellPart = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1516:2: (iv_ruleShellPart= ruleShellPart EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1517:2: iv_ruleShellPart= ruleShellPart EOF
            {
             newCompositeNode(grammarAccess.getShellPartRule()); 
            pushFollow(FOLLOW_ruleShellPart_in_entryRuleShellPart2923);
            iv_ruleShellPart=ruleShellPart();

            state._fsp--;

             current =iv_ruleShellPart; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShellPart2933); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShellPart"


    // $ANTLR start "ruleShellPart"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1524:1: ruleShellPart returns [EObject current=null] : ( () ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) ) ) ;
    public final EObject ruleShellPart() throws RecognitionException {
        EObject current = null;

        Token this_STRING_3=null;
        Token this_COMMA_4=null;
        Token this_SHELL_CHAR_5=null;
        Token this_BACKSLASH_6=null;
        Token this_TAB_8=null;
        EObject lv_val_1_0 = null;

        EObject lv_cmd_2_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1527:28: ( ( () ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1528:1: ( () ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1528:1: ( () ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1528:2: () ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1528:2: ()
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1529:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getShellPartAccess().getShellPartAction_0(),
                        current);
                

            }

            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1534:2: ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) )
            int alt35=6;
            alt35 = dfa35.predict(input);
            switch (alt35) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1534:3: ( (lv_val_1_0= ruleVarSlashSym ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1534:3: ( (lv_val_1_0= ruleVarSlashSym ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1535:1: (lv_val_1_0= ruleVarSlashSym )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1535:1: (lv_val_1_0= ruleVarSlashSym )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1536:3: lv_val_1_0= ruleVarSlashSym
                    {
                     
                    	        newCompositeNode(grammarAccess.getShellPartAccess().getValVarSlashSymParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVarSlashSym_in_ruleShellPart2989);
                    lv_val_1_0=ruleVarSlashSym();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getShellPartRule());
                    	        }
                           		set(
                           			current, 
                           			"val",
                            		lv_val_1_0, 
                            		"VarSlashSym");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1553:6: ( (lv_cmd_2_0= ruleShellCmd ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1553:6: ( (lv_cmd_2_0= ruleShellCmd ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1554:1: (lv_cmd_2_0= ruleShellCmd )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1554:1: (lv_cmd_2_0= ruleShellCmd )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1555:3: lv_cmd_2_0= ruleShellCmd
                    {
                     
                    	        newCompositeNode(grammarAccess.getShellPartAccess().getCmdShellCmdParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShellCmd_in_ruleShellPart3016);
                    lv_cmd_2_0=ruleShellCmd();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getShellPartRule());
                    	        }
                           		set(
                           			current, 
                           			"cmd",
                            		lv_cmd_2_0, 
                            		"ShellCmd");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1572:6: this_STRING_3= RULE_STRING
                    {
                    this_STRING_3=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleShellPart3033); 
                     
                        newLeafNode(this_STRING_3, grammarAccess.getShellPartAccess().getSTRINGTerminalRuleCall_1_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1577:6: this_COMMA_4= RULE_COMMA
                    {
                    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_RULE_COMMA_in_ruleShellPart3049); 
                     
                        newLeafNode(this_COMMA_4, grammarAccess.getShellPartAccess().getCOMMATerminalRuleCall_1_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1582:6: this_SHELL_CHAR_5= RULE_SHELL_CHAR
                    {
                    this_SHELL_CHAR_5=(Token)match(input,RULE_SHELL_CHAR,FOLLOW_RULE_SHELL_CHAR_in_ruleShellPart3065); 
                     
                        newLeafNode(this_SHELL_CHAR_5, grammarAccess.getShellPartAccess().getSHELL_CHARTerminalRuleCall_1_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1587:6: (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1587:6: (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1587:7: this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )*
                    {
                    this_BACKSLASH_6=(Token)match(input,RULE_BACKSLASH,FOLLOW_RULE_BACKSLASH_in_ruleShellPart3082); 
                     
                        newLeafNode(this_BACKSLASH_6, grammarAccess.getShellPartAccess().getBACKSLASHTerminalRuleCall_1_5_0()); 
                        
                     
                            newCompositeNode(grammarAccess.getShellPartAccess().getEolParserRuleCall_1_5_1()); 
                        
                    pushFollow(FOLLOW_ruleEol_in_ruleShellPart3097);
                    ruleEol();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1599:1: (this_TAB_8= RULE_TAB )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==RULE_TAB) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1599:2: this_TAB_8= RULE_TAB
                    	    {
                    	    this_TAB_8=(Token)match(input,RULE_TAB,FOLLOW_RULE_TAB_in_ruleShellPart3108); 
                    	     
                    	        newLeafNode(this_TAB_8, grammarAccess.getShellPartAccess().getTABTerminalRuleCall_1_5_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShellPart"


    // $ANTLR start "entryRuleVarSlashSym"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1611:1: entryRuleVarSlashSym returns [EObject current=null] : iv_ruleVarSlashSym= ruleVarSlashSym EOF ;
    public final EObject entryRuleVarSlashSym() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarSlashSym = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1612:2: (iv_ruleVarSlashSym= ruleVarSlashSym EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1613:2: iv_ruleVarSlashSym= ruleVarSlashSym EOF
            {
             newCompositeNode(grammarAccess.getVarSlashSymRule()); 
            pushFollow(FOLLOW_ruleVarSlashSym_in_entryRuleVarSlashSym3147);
            iv_ruleVarSlashSym=ruleVarSlashSym();

            state._fsp--;

             current =iv_ruleVarSlashSym; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarSlashSym3157); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarSlashSym"


    // $ANTLR start "ruleVarSlashSym"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1620:1: ruleVarSlashSym returns [EObject current=null] : (this_Variable_0= ruleVariable | ( (lv_name_1_0= RULE_SLASH ) ) | ( (lv_name_2_0= RULE_SYMBOL ) ) ) ;
    public final EObject ruleVarSlashSym() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_name_2_0=null;
        EObject this_Variable_0 = null;


         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1623:28: ( (this_Variable_0= ruleVariable | ( (lv_name_1_0= RULE_SLASH ) ) | ( (lv_name_2_0= RULE_SYMBOL ) ) ) )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1624:1: (this_Variable_0= ruleVariable | ( (lv_name_1_0= RULE_SLASH ) ) | ( (lv_name_2_0= RULE_SYMBOL ) ) )
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1624:1: (this_Variable_0= ruleVariable | ( (lv_name_1_0= RULE_SLASH ) ) | ( (lv_name_2_0= RULE_SYMBOL ) ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case RULE_DOLLAR:
                {
                alt36=1;
                }
                break;
            case RULE_SLASH:
                {
                alt36=2;
                }
                break;
            case RULE_SYMBOL:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1625:5: this_Variable_0= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getVarSlashSymAccess().getVariableParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleVarSlashSym3204);
                    this_Variable_0=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1634:6: ( (lv_name_1_0= RULE_SLASH ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1634:6: ( (lv_name_1_0= RULE_SLASH ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1635:1: (lv_name_1_0= RULE_SLASH )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1635:1: (lv_name_1_0= RULE_SLASH )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1636:3: lv_name_1_0= RULE_SLASH
                    {
                    lv_name_1_0=(Token)match(input,RULE_SLASH,FOLLOW_RULE_SLASH_in_ruleVarSlashSym3226); 

                    			newLeafNode(lv_name_1_0, grammarAccess.getVarSlashSymAccess().getNameSLASHTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVarSlashSymRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"SLASH");
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1653:6: ( (lv_name_2_0= RULE_SYMBOL ) )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1653:6: ( (lv_name_2_0= RULE_SYMBOL ) )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1654:1: (lv_name_2_0= RULE_SYMBOL )
                    {
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1654:1: (lv_name_2_0= RULE_SYMBOL )
                    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1655:3: lv_name_2_0= RULE_SYMBOL
                    {
                    lv_name_2_0=(Token)match(input,RULE_SYMBOL,FOLLOW_RULE_SYMBOL_in_ruleVarSlashSym3254); 

                    			newLeafNode(lv_name_2_0, grammarAccess.getVarSlashSymAccess().getNameSYMBOLTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVarSlashSymRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"SYMBOL");
                    	    

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarSlashSym"


    // $ANTLR start "entryRuleEol"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1679:1: entryRuleEol returns [String current=null] : iv_ruleEol= ruleEol EOF ;
    public final String entryRuleEol() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEol = null;


        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1680:2: (iv_ruleEol= ruleEol EOF )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1681:2: iv_ruleEol= ruleEol EOF
            {
             newCompositeNode(grammarAccess.getEolRule()); 
            pushFollow(FOLLOW_ruleEol_in_entryRuleEol3296);
            iv_ruleEol=ruleEol();

            state._fsp--;

             current =iv_ruleEol.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEol3307); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEol"


    // $ANTLR start "ruleEol"
    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1688:1: ruleEol returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NLI_0= RULE_NLI )+ ;
    public final AntlrDatatypeRuleToken ruleEol() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NLI_0=null;

         enterRule(); 
            
        try {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1691:28: ( (this_NLI_0= RULE_NLI )+ )
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1692:1: (this_NLI_0= RULE_NLI )+
            {
            // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1692:1: (this_NLI_0= RULE_NLI )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_NLI) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../at.jku.isse.ecco.kefax.kbuild/src-gen/at/jku/isse/ecco/kefax/kbuild/parser/antlr/internal/InternalKbuild.g:1692:6: this_NLI_0= RULE_NLI
            	    {
            	    this_NLI_0=(Token)match(input,RULE_NLI,FOLLOW_RULE_NLI_in_ruleEol3347); 

            	    		current.merge(this_NLI_0);
            	        
            	     
            	        newLeafNode(this_NLI_0, grammarAccess.getEolAccess().getNLITerminalRuleCall()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEol"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA35 dfa35 = new DFA35(this);
    static final String DFA2_eotS =
        "\4\uffff";
    static final String DFA2_eofS =
        "\1\uffff\1\2\2\uffff";
    static final String DFA2_minS =
        "\1\36\1\4\2\uffff";
    static final String DFA2_maxS =
        "\2\36\2\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA2_specialS =
        "\4\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\4\3\4\uffff\1\3\6\uffff\2\3\2\uffff\1\3\2\uffff\4\3\1\1",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "()* loopback of 104:3: ( ruleEol ( (lv_buildEntry_3_0= ruleBuildEntry ) ) )*";
        }
    }
    static final String DFA11_eotS =
        "\20\uffff";
    static final String DFA11_eofS =
        "\20\uffff";
    static final String DFA11_minS =
        "\1\4\4\uffff\1\7\2\uffff\1\7\1\uffff\1\7\1\uffff\4\7";
    static final String DFA11_maxS =
        "\1\35\4\uffff\1\35\2\uffff\1\15\1\uffff\1\35\1\uffff\1\7\3\35";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\uffff\1\10\1\uffff\1\5\4\uffff";
    static final String DFA11_specialS =
        "\20\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\2\1\3\1\4\1\5\4\uffff\1\1\6\uffff\2\6\2\uffff\1\7\2\uffff\4\7",
            "",
            "",
            "",
            "",
            "\1\7\1\uffff\1\12\1\uffff\1\13\11\uffff\1\11\1\13\5\7\1\10\1\7",
            "",
            "",
            "\1\15\5\uffff\1\14",
            "",
            "\1\7\2\uffff\1\7\12\uffff\1\13\1\uffff\1\7\2\uffff\4\7",
            "",
            "\1\16",
            "\1\7\1\uffff\1\12\1\uffff\1\13\11\uffff\1\11\1\13\1\7\1\uffff\5\7",
            "\1\7\6\uffff\1\7\2\uffff\1\17\5\uffff\1\7\1\uffff\5\7",
            "\1\7\1\uffff\1\12\1\uffff\1\13\11\uffff\1\11\1\13\1\7\1\uffff\5\7"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "159:1: ( ( () ( (lv_value_1_0= ruleEntry ) ) ) | ( () this_IFEQ_3= RULE_IFEQ ( (lv_value_4_0= ruleIf ) ) ) | ( () this_IFNEQ_6= RULE_IFNEQ ( (lv_value_7_0= ruleIf ) ) ) | ( () this_IFNDEF_9= RULE_IFNDEF ( (lv_name_10_0= RULE_SYMBOL ) ) ruleEol ( ( (lv_value_12_0= ruleObject_Y ) ) | ( (lv_value_13_0= ruleObject_M ) ) ) ruleEol this_ENDIF_15= RULE_ENDIF ) | ( () ( (lv_name_17_0= RULE_SYMBOL ) ) ( (lv_variable_18_0= ruleVariable ) )? ( (lv_value_19_0= ruleAssignExtra ) ) ( (lv_inner_20_0= ruleAssign ) )? ) | ( () ( ( (lv_value_22_0= ruleObject_Y ) ) | ( (lv_value_23_0= ruleObject_M ) ) ) ) | ( () ( (lv_target_25_0= ruleValues ) ) this_DPOINT_26= RULE_DPOINT (this_SEMICOLON_27= RULE_SEMICOLON | ( ( (lv_values_28_0= ruleValues ) ) ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )* ) ) ) | ( () ( (lv_name_33_0= RULE_SYMBOL ) ) ( (lv_variable_34_0= ruleVariable ) )? ( (lv_value_35_0= ruleAssign ) ) ) )";
        }
    }
    static final String DFA8_eotS =
        "\4\uffff";
    static final String DFA8_eofS =
        "\2\2\2\uffff";
    static final String DFA8_minS =
        "\1\36\1\4\2\uffff";
    static final String DFA8_maxS =
        "\2\36\2\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA8_specialS =
        "\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1",
            "\4\2\3\uffff\1\3\1\2\6\uffff\2\2\2\uffff\1\2\2\uffff\4\2\1\1",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 502:2: ( ruleEol (this_TAB_30= RULE_TAB )+ ( (lv_values_31_0= ruleValues ) ) )*";
        }
    }
    static final String DFA30_eotS =
        "\14\uffff";
    static final String DFA30_eofS =
        "\1\uffff\1\7\12\uffff";
    static final String DFA30_minS =
        "\3\7\7\uffff\2\7";
    static final String DFA30_maxS =
        "\1\35\1\36\1\15\7\uffff\1\7\1\35";
    static final String DFA30_acceptS =
        "\3\uffff\1\4\1\5\1\6\1\1\1\2\1\7\1\3\2\uffff";
    static final String DFA30_specialS =
        "\14\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\22\uffff\1\4\1\5\1\2\1\3",
            "\1\7\1\uffff\1\7\13\uffff\1\7\1\uffff\1\7\1\6\1\10\5\7",
            "\1\11\5\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\3\6\uffff\1\3\2\uffff\1\11\5\uffff\1\3\1\uffff\5\3"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1183:1: ( ( () this_SYMBOL_1= RULE_SYMBOL this_OBJ_FILE_2= RULE_OBJ_FILE ) | ( () ( (lv_name_4_0= RULE_SYMBOL ) ) ) | ( () ( (lv_value_6_0= ruleVariable ) ) ( (lv_additional_7_0= RULE_SLASH ) )? ) | ( () ( (lv_value_9_0= ruleShellCmd ) ) ) | ( () this_STRING_11= RULE_STRING ) | ( () ( (lv_value_13_0= RULE_SHELL_CHAR ) ) ) | ( () this_SYMBOL_15= RULE_SYMBOL this_SLASH_16= RULE_SLASH ) )";
        }
    }
    static final String DFA35_eotS =
        "\12\uffff";
    static final String DFA35_eofS =
        "\12\uffff";
    static final String DFA35_minS =
        "\2\7\6\uffff\2\7";
    static final String DFA35_maxS =
        "\1\35\1\15\6\uffff\1\7\1\35";
    static final String DFA35_acceptS =
        "\2\uffff\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff";
    static final String DFA35_specialS =
        "\12\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\2\6\uffff\1\5\10\uffff\1\7\1\uffff\1\2\1\4\1\6\1\1\1\3",
            "\1\2\5\uffff\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\3\6\uffff\1\3\2\uffff\1\2\5\uffff\1\3\1\uffff\5\3"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "1534:2: ( ( (lv_val_1_0= ruleVarSlashSym ) ) | ( (lv_cmd_2_0= ruleShellCmd ) ) | this_STRING_3= RULE_STRING | this_COMMA_4= RULE_COMMA | this_SHELL_CHAR_5= RULE_SHELL_CHAR | (this_BACKSLASH_6= RULE_BACKSLASH ruleEol (this_TAB_8= RULE_TAB )* ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_ruleModel140 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleModel158 = new BitSet(new long[]{0x000000003C9810F0L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_ruleModel178 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleModel196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBuildEntry_in_entryRuleBuildEntry231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBuildEntry241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_ruleBuildEntry297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFEQ_in_ruleBuildEntry325 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleIf_in_ruleBuildEntry345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFNEQ_in_ruleBuildEntry373 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ruleIf_in_ruleBuildEntry393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_IFNDEF_in_ruleBuildEntry421 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleBuildEntry437 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleBuildEntry458 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_ruleObject_Y_in_ruleBuildEntry479 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleObject_M_in_ruleBuildEntry506 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleBuildEntry523 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ENDIF_in_ruleBuildEntry533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleBuildEntry566 = new BitSet(new long[]{0x0000000010400A00L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleBuildEntry592 = new BitSet(new long[]{0x0000000010400A00L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_ruleBuildEntry614 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleAssign_in_ruleBuildEntry635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_ruleBuildEntry675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_ruleBuildEntry702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_ruleBuildEntry741 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RULE_DPOINT_in_ruleBuildEntry752 = new BitSet(new long[]{0x000000003C800480L});
    public static final BitSet FOLLOW_RULE_SEMICOLON_in_ruleBuildEntry763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_ruleBuildEntry790 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleEol_in_ruleBuildEntry807 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleBuildEntry818 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_ruleValues_in_ruleBuildEntry840 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleBuildEntry878 = new BitSet(new long[]{0x0000000010200000L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleBuildEntry904 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleAssign_in_ruleBuildEntry926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntry_in_entryRuleEntry963 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntry973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_START_in_ruleEntry1018 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleEntry1038 = new BitSet(new long[]{0x0000000010400A00L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_ruleEntry1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIf_in_entryRuleIf1095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIf1105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_ruleIf1141 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleIf1164 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleIf1174 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_RULE_Y_in_ruleIf1185 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_M_in_ruleIf1201 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleShellCmd_in_ruleIf1230 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleIf1242 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_ruleIf1256 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleIf1271 = new BitSet(new long[]{0x0000000030181800L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleIf1282 = new BitSet(new long[]{0x0000000030181800L});
    public static final BitSet FOLLOW_ruleObject_Y_in_ruleIf1305 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleObject_M_in_ruleIf1332 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEntry_in_ruleIf1359 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleShellCmd_in_ruleIf1386 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleIf1403 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_RULE_ELSE_in_ruleIf1414 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleIf1429 = new BitSet(new long[]{0x0000000000180800L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleIf1440 = new BitSet(new long[]{0x0000000000180800L});
    public static final BitSet FOLLOW_ruleObject_Y_in_ruleIf1463 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleObject_M_in_ruleIf1490 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleIf1507 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ENDIF_in_ruleIf1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_Y_in_entryRuleObject_Y1554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject_Y1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_Y_in_ruleObject_Y1609 = new BitSet(new long[]{0x0000000010400A00L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_ruleObject_Y1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObject_M_in_entryRuleObject_M1665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObject_M1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OBJ_M_in_ruleObject_M1720 = new BitSet(new long[]{0x0000000010400A00L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_ruleObject_M1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssign_in_entryRuleAssign1776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssign1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EQ_in_ruleAssign1822 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleAssign1833 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_ruleValues_in_ruleAssign1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignExtra_in_entryRuleAssignExtra1891 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignExtra1901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleAssignExtra1938 = new BitSet(new long[]{0x0000000000400A00L});
    public static final BitSet FOLLOW_RULE_PLUS_in_ruleAssignExtra1951 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RULE_DPOINT_in_ruleAssignExtra1967 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleAssign_in_ruleAssignExtra1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValues_in_entryRuleValues2024 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValues2034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_ruleValues2071 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleValues2086 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleValues2097 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValues2121 = new BitSet(new long[]{0x000000003C800082L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_ruleValues2134 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleValues2149 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleValues2160 = new BitSet(new long[]{0x000000003C800880L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValues2182 = new BitSet(new long[]{0x000000003C800082L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue2221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleValue2277 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_RULE_OBJ_FILE_in_ruleValue2287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleValue2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue2363 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleValue2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_ruleValue2424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValue2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SHELL_CHAR_in_ruleValue2485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleValue2518 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleValue2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable2564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_ruleVariable2620 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleVariable2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_ruleVariable2660 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_ruleVariable2670 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleVariable2686 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_ruleVariable2702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_entryRuleShellCmd2738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShellCmd2748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DOLLAR_in_ruleShellCmd2795 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_RULE_BRACE_START_in_ruleShellCmd2805 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleShellCmd2821 = new BitSet(new long[]{0x000000003E804080L});
    public static final BitSet FOLLOW_ruleShellPart_in_ruleShellCmd2847 = new BitSet(new long[]{0x000000003E824080L});
    public static final BitSet FOLLOW_RULE_BRACE_END_in_ruleShellCmd2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INCLUDE_in_ruleShellCmd2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellPart_in_entryRuleShellPart2923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShellPart2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarSlashSym_in_ruleShellPart2989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShellCmd_in_ruleShellPart3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleShellPart3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_COMMA_in_ruleShellPart3049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SHELL_CHAR_in_ruleShellPart3065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BACKSLASH_in_ruleShellPart3082 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleEol_in_ruleShellPart3097 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_RULE_TAB_in_ruleShellPart3108 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleVarSlashSym_in_entryRuleVarSlashSym3147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarSlashSym3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVarSlashSym3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SLASH_in_ruleVarSlashSym3226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SYMBOL_in_ruleVarSlashSym3254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEol_in_entryRuleEol3296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEol3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NLI_in_ruleEol3347 = new BitSet(new long[]{0x0000000040000002L});

}