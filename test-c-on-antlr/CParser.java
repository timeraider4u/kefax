// $ANTLR 3.x C.g 2015-09-22 20:20:04

import java.util.Set;
import java.util.HashSet;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


/** ANSI C ANTLR v3 grammar

Translated from Jutta Degener's 1995 ANSI C yacc grammar by Terence Parr
July 2006.  The lexical rules were taken from the Java grammar.

Jutta says: "In 1985, Jeff Lee published his Yacc grammar (which
is accompanied by a matching Lex specification) for the April 30, 1985 draft
version of the ANSI C standard.  Tom Stockfisch reposted it to net.sources in
1987; that original, as mentioned in the answer to question 17.25 of the
comp.lang.c FAQ, can be ftp'ed from ftp.uu.net,
   file usenet/net.sources/ansi.c.grammar.Z.
I intend to keep this version as close to the current C Standard grammar as
possible; please let me know if you discover discrepancies. Jutta Degener, 1995"

Generally speaking, you need symbol table info to parse C; typedefs
define types and then IDENTIFIERS are either types or plain IDs.  I'm doing
the min necessary here tracking only type names.  This is a good example
of the global scope (called Symbols).  Every rule that declares its usage
of Symbols pushes a new copy on the stack effectively creating a new
symbol scope.  Also note rule declaration declares a rule scope that
lets any invoked rule see isTypedef boolean.  It's much easier than
passing that info down as parameters.  Very clean.  Rule
direct_declarator can then easily determine whether the IDENTIFIER
should be declared as a type name.

I have only tested this on a single file, though it is 3500 lines.

This grammar requires ANTLR v3.0.1 or higher.

Terence Parr
July 2006
*/
@SuppressWarnings("all")
public class CParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CHARACTER_LITERAL", "COMMENT", 
		"DECIMAL_LITERAL", "EscapeSequence", "Exponent", "FLOATING_POINT_LITERAL", 
		"FloatTypeSuffix", "HEX_LITERAL", "HexDigit", "IDENTIFIER", "IntegerTypeSuffix", 
		"LETTER", "LINE_COMMAND", "LINE_COMMENT", "OCTAL_LITERAL", "OctalEscape", 
		"STRING_LITERAL", "UnicodeEscape", "WS", "'!'", "'!='", "'%'", "'%='", 
		"'&&'", "'&'", "'&='", "'('", "')'", "'*'", "'*='", "'+'", "'++'", "'+='", 
		"','", "'-'", "'--'", "'-='", "'->'", "'.'", "'...'", "'/'", "'/='", "':'", 
		"';'", "'<'", "'<<'", "'<<='", "'<='", "'='", "'=='", "'>'", "'>='", "'>>'", 
		"'>>='", "'?'", "'['", "']'", "'^'", "'^='", "'auto'", "'break'", "'case'", 
		"'char'", "'const'", "'continue'", "'default'", "'do'", "'double'", "'else'", 
		"'enum'", "'extern'", "'float'", "'for'", "'goto'", "'if'", "'int'", "'long'", 
		"'register'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
		"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
		"'volatile'", "'while'", "'{'", "'|'", "'|='", "'||'", "'}'", "'~'"
	};
	public static final int EOF=-1;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int T__94=94;
	public static final int T__95=95;
	public static final int T__96=96;
	public static final int T__97=97;
	public static final int T__98=98;
	public static final int T__99=99;
	public static final int T__100=100;
	public static final int CHARACTER_LITERAL=4;
	public static final int COMMENT=5;
	public static final int DECIMAL_LITERAL=6;
	public static final int EscapeSequence=7;
	public static final int Exponent=8;
	public static final int FLOATING_POINT_LITERAL=9;
	public static final int FloatTypeSuffix=10;
	public static final int HEX_LITERAL=11;
	public static final int HexDigit=12;
	public static final int IDENTIFIER=13;
	public static final int IntegerTypeSuffix=14;
	public static final int LETTER=15;
	public static final int LINE_COMMAND=16;
	public static final int LINE_COMMENT=17;
	public static final int OCTAL_LITERAL=18;
	public static final int OctalEscape=19;
	public static final int STRING_LITERAL=20;
	public static final int UnicodeEscape=21;
	public static final int WS=22;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	protected static class Symbols_scope {
		Set types;
	}
	protected Stack<Symbols_scope> Symbols_stack = new Stack<Symbols_scope>();


	public CParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public CParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.state.ruleMemo = new HashMap[213+1];


	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return CParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C.g"; }


		boolean isTypeName(String name) {
			for (int i = Symbols_stack.size()-1; i>=0; i--) {
				Symbols_scope scope = (Symbols_scope)Symbols_stack.get(i);
				if ( scope.types.contains(name) ) {
					return true;
				}
			}
			return false;
		}
		
		public static void main(String[] args) throws Exception {
			CLexer lex = new CLexer(new ANTLRFileStream(args[0]));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			CParser parser = new CParser(tokens);
			
			//acquire parse result
			CParser.translation_unit_return ret = parser.translation_unit();
			CommonTree ast = (CommonTree) ret.tree;
			// printTree(ast);
			ast.toString();
	    }


	public static class translation_unit_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "translation_unit"
	// C.g:74:1: translation_unit : ( external_declaration )+ ;
	public final CParser.translation_unit_return translation_unit() throws RecognitionException {
		Symbols_stack.push(new Symbols_scope());

		CParser.translation_unit_return retval = new CParser.translation_unit_return();
		retval.start = input.LT(1);
		int translation_unit_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope external_declaration1 =null;



		  Symbols_stack.peek().types = new HashSet();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

			// C.g:79:2: ( ( external_declaration )+ )
			// C.g:79:4: ( external_declaration )+
			{
			root_0 = (Object)adaptor.nil();


			// C.g:79:4: ( external_declaration )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==IDENTIFIER||LA1_0==30||LA1_0==32||LA1_0==63||(LA1_0 >= 66 && LA1_0 <= 67)||LA1_0==71||(LA1_0 >= 73 && LA1_0 <= 75)||(LA1_0 >= 79 && LA1_0 <= 81)||(LA1_0 >= 83 && LA1_0 <= 84)||(LA1_0 >= 86 && LA1_0 <= 87)||(LA1_0 >= 89 && LA1_0 <= 93)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C.g:79:4: external_declaration
					{
					pushFollow(FOLLOW_external_declaration_in_translation_unit85);
					external_declaration1=external_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, external_declaration1.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 1, translation_unit_StartIndex); }

			Symbols_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "translation_unit"


	public static class external_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "external_declaration"
	// C.g:96:1: external_declaration options {k=1; } : ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration );
	public final CParser.external_declaration_return external_declaration() throws RecognitionException {
		CParser.external_declaration_return retval = new CParser.external_declaration_return();
		retval.start = input.LT(1);
		int external_declaration_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope function_definition2 =null;
		ParserRuleReturnScope declaration3 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

			// C.g:98:2: ( ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition | declaration )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==63||LA2_0==74||LA2_0==81||LA2_0==86) ) {
				int LA2_1 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==92) ) {
				int LA2_2 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==66) ) {
				int LA2_3 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==83) ) {
				int LA2_4 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==79) ) {
				int LA2_5 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==80) ) {
				int LA2_6 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==75) ) {
				int LA2_7 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==71) ) {
				int LA2_8 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==84) ) {
				int LA2_9 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==91) ) {
				int LA2_10 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==87||LA2_0==90) ) {
				int LA2_11 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==73) ) {
				int LA2_12 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==IDENTIFIER) ) {
				int LA2_13 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( ((isTypeName(input.LT(1).getText()))) ) {
					alt2=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 13, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA2_0==67||LA2_0==93) ) {
				int LA2_14 = input.LA(2);
				if ( (synpred4_C()) ) {
					alt2=1;
				}
				else if ( (true) ) {
					alt2=2;
				}

			}
			else if ( (LA2_0==32) && (synpred4_C())) {
				alt2=1;
			}
			else if ( (LA2_0==30) && (synpred4_C())) {
				alt2=1;
			}
			else if ( (LA2_0==89) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C.g:98:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )=> function_definition
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_function_definition_in_external_declaration121);
					function_definition2=function_definition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_definition2.getTree());

					}
					break;
				case 2 :
					// C.g:99:4: declaration
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_declaration_in_external_declaration126);
					declaration3=declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration3.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 2, external_declaration_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "external_declaration"


	public static class function_definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function_definition"
	// C.g:102:1: function_definition : ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement ) ;
	public final CParser.function_definition_return function_definition() throws RecognitionException {
		Symbols_stack.push(new Symbols_scope());

		CParser.function_definition_return retval = new CParser.function_definition_return();
		retval.start = input.LT(1);
		int function_definition_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope declaration_specifiers4 =null;
		ParserRuleReturnScope declarator5 =null;
		ParserRuleReturnScope declaration6 =null;
		ParserRuleReturnScope compound_statement7 =null;
		ParserRuleReturnScope compound_statement8 =null;



		  Symbols_stack.peek().types = new HashSet();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

			// C.g:107:2: ( ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement ) )
			// C.g:107:4: ( declaration_specifiers )? declarator ( ( declaration )+ compound_statement | compound_statement )
			{
			root_0 = (Object)adaptor.nil();


			// C.g:107:4: ( declaration_specifiers )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==63||(LA3_0 >= 66 && LA3_0 <= 67)||LA3_0==71||(LA3_0 >= 73 && LA3_0 <= 75)||(LA3_0 >= 79 && LA3_0 <= 81)||(LA3_0 >= 83 && LA3_0 <= 84)||(LA3_0 >= 86 && LA3_0 <= 87)||(LA3_0 >= 90 && LA3_0 <= 93)) ) {
				alt3=1;
			}
			else if ( (LA3_0==IDENTIFIER) ) {
				switch ( input.LA(2) ) {
					case 32:
						{
						alt3=1;
						}
						break;
					case IDENTIFIER:
						{
						int LA3_18 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 30:
						{
						int LA3_19 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 63:
					case 74:
					case 81:
					case 86:
						{
						int LA3_20 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 92:
						{
						int LA3_21 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 66:
						{
						int LA3_22 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 83:
						{
						int LA3_23 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 79:
						{
						int LA3_24 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 80:
						{
						int LA3_25 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 75:
						{
						int LA3_26 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 71:
						{
						int LA3_27 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 84:
						{
						int LA3_28 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 91:
						{
						int LA3_29 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 87:
					case 90:
						{
						int LA3_30 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 73:
						{
						int LA3_31 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
					case 67:
					case 93:
						{
						int LA3_32 = input.LA(3);
						if ( ((synpred5_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt3=1;
						}
						}
						break;
				}
			}
			switch (alt3) {
				case 1 :
					// C.g:107:4: declaration_specifiers
					{
					pushFollow(FOLLOW_declaration_specifiers_in_function_definition148);
					declaration_specifiers4=declaration_specifiers();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_specifiers4.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_declarator_in_function_definition151);
			declarator5=declarator();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator5.getTree());

			// C.g:108:3: ( ( declaration )+ compound_statement | compound_statement )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENTIFIER||LA5_0==63||(LA5_0 >= 66 && LA5_0 <= 67)||LA5_0==71||(LA5_0 >= 73 && LA5_0 <= 75)||(LA5_0 >= 79 && LA5_0 <= 81)||(LA5_0 >= 83 && LA5_0 <= 84)||(LA5_0 >= 86 && LA5_0 <= 87)||(LA5_0 >= 89 && LA5_0 <= 93)) ) {
				alt5=1;
			}
			else if ( (LA5_0==95) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C.g:108:5: ( declaration )+ compound_statement
					{
					// C.g:108:5: ( declaration )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==IDENTIFIER||LA4_0==63||(LA4_0 >= 66 && LA4_0 <= 67)||LA4_0==71||(LA4_0 >= 73 && LA4_0 <= 75)||(LA4_0 >= 79 && LA4_0 <= 81)||(LA4_0 >= 83 && LA4_0 <= 84)||(LA4_0 >= 86 && LA4_0 <= 87)||(LA4_0 >= 89 && LA4_0 <= 93)) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// C.g:108:5: declaration
							{
							pushFollow(FOLLOW_declaration_in_function_definition157);
							declaration6=declaration();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration6.getTree());

							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					pushFollow(FOLLOW_compound_statement_in_function_definition160);
					compound_statement7=compound_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_statement7.getTree());

					}
					break;
				case 2 :
					// C.g:109:5: compound_statement
					{
					pushFollow(FOLLOW_compound_statement_in_function_definition167);
					compound_statement8=compound_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_statement8.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 3, function_definition_StartIndex); }

			Symbols_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "function_definition"


	protected static class declaration_scope {
		boolean isTypedef;
	}
	protected Stack<declaration_scope> declaration_stack = new Stack<declaration_scope>();

	public static class declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration"
	// C.g:113:1: declaration : ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' );
	public final CParser.declaration_return declaration() throws RecognitionException {
		declaration_stack.push(new declaration_scope());
		CParser.declaration_return retval = new CParser.declaration_return();
		retval.start = input.LT(1);
		int declaration_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal9=null;
		Token char_literal12=null;
		Token char_literal15=null;
		ParserRuleReturnScope declaration_specifiers10 =null;
		ParserRuleReturnScope init_declarator_list11 =null;
		ParserRuleReturnScope declaration_specifiers13 =null;
		ParserRuleReturnScope init_declarator_list14 =null;

		Object string_literal9_tree=null;
		Object char_literal12_tree=null;
		Object char_literal15_tree=null;


		  declaration_stack.peek().isTypedef = false;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

			// C.g:120:2: ( 'typedef' ( declaration_specifiers )? init_declarator_list ';' | declaration_specifiers ( init_declarator_list )? ';' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==89) ) {
				alt8=1;
			}
			else if ( (LA8_0==IDENTIFIER||LA8_0==63||(LA8_0 >= 66 && LA8_0 <= 67)||LA8_0==71||(LA8_0 >= 73 && LA8_0 <= 75)||(LA8_0 >= 79 && LA8_0 <= 81)||(LA8_0 >= 83 && LA8_0 <= 84)||(LA8_0 >= 86 && LA8_0 <= 87)||(LA8_0 >= 90 && LA8_0 <= 93)) ) {
				alt8=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// C.g:120:4: 'typedef' ( declaration_specifiers )? init_declarator_list ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal9=(Token)match(input,89,FOLLOW_89_in_declaration195); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal9_tree = (Object)adaptor.create(string_literal9);
					adaptor.addChild(root_0, string_literal9_tree);
					}

					// C.g:120:14: ( declaration_specifiers )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==63||(LA6_0 >= 66 && LA6_0 <= 67)||LA6_0==71||(LA6_0 >= 73 && LA6_0 <= 75)||(LA6_0 >= 79 && LA6_0 <= 81)||(LA6_0 >= 83 && LA6_0 <= 84)||(LA6_0 >= 86 && LA6_0 <= 87)||(LA6_0 >= 90 && LA6_0 <= 93)) ) {
						alt6=1;
					}
					else if ( (LA6_0==IDENTIFIER) ) {
						int LA6_13 = input.LA(2);
						if ( (LA6_13==IDENTIFIER||LA6_13==32||LA6_13==63||(LA6_13 >= 66 && LA6_13 <= 67)||LA6_13==71||(LA6_13 >= 73 && LA6_13 <= 75)||(LA6_13 >= 79 && LA6_13 <= 81)||(LA6_13 >= 83 && LA6_13 <= 84)||(LA6_13 >= 86 && LA6_13 <= 87)||(LA6_13 >= 90 && LA6_13 <= 93)) ) {
							alt6=1;
						}
						else if ( (LA6_13==30) ) {
							int LA6_19 = input.LA(3);
							if ( (((isTypeName(input.LT(1).getText()))&&synpred8_C())) ) {
								alt6=1;
							}
						}
					}
					switch (alt6) {
						case 1 :
							// C.g:120:14: declaration_specifiers
							{
							pushFollow(FOLLOW_declaration_specifiers_in_declaration197);
							declaration_specifiers10=declaration_specifiers();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_specifiers10.getTree());

							}
							break;

					}

					if ( state.backtracking==0 ) {declaration_stack.peek().isTypedef =true;}
					pushFollow(FOLLOW_init_declarator_list_in_declaration205);
					init_declarator_list11=init_declarator_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, init_declarator_list11.getTree());

					char_literal12=(Token)match(input,47,FOLLOW_47_in_declaration207); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal12_tree = (Object)adaptor.create(char_literal12);
					adaptor.addChild(root_0, char_literal12_tree);
					}

					}
					break;
				case 2 :
					// C.g:122:4: declaration_specifiers ( init_declarator_list )? ';'
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_declaration_specifiers_in_declaration213);
					declaration_specifiers13=declaration_specifiers();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_specifiers13.getTree());

					// C.g:122:27: ( init_declarator_list )?
					int alt7=2;
					int LA7_0 = input.LA(1);
					if ( (LA7_0==IDENTIFIER||LA7_0==30||LA7_0==32) ) {
						alt7=1;
					}
					switch (alt7) {
						case 1 :
							// C.g:122:27: init_declarator_list
							{
							pushFollow(FOLLOW_init_declarator_list_in_declaration215);
							init_declarator_list14=init_declarator_list();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, init_declarator_list14.getTree());

							}
							break;

					}

					char_literal15=(Token)match(input,47,FOLLOW_47_in_declaration218); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal15_tree = (Object)adaptor.create(char_literal15);
					adaptor.addChild(root_0, char_literal15_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 4, declaration_StartIndex); }

			declaration_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "declaration"


	public static class declaration_specifiers_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declaration_specifiers"
	// C.g:125:1: declaration_specifiers : ( storage_class_specifier | type_specifier | type_qualifier )+ ;
	public final CParser.declaration_specifiers_return declaration_specifiers() throws RecognitionException {
		CParser.declaration_specifiers_return retval = new CParser.declaration_specifiers_return();
		retval.start = input.LT(1);
		int declaration_specifiers_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope storage_class_specifier16 =null;
		ParserRuleReturnScope type_specifier17 =null;
		ParserRuleReturnScope type_qualifier18 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

			// C.g:126:2: ( ( storage_class_specifier | type_specifier | type_qualifier )+ )
			// C.g:126:6: ( storage_class_specifier | type_specifier | type_qualifier )+
			{
			root_0 = (Object)adaptor.nil();


			// C.g:126:6: ( storage_class_specifier | type_specifier | type_qualifier )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=4;
				switch ( input.LA(1) ) {
				case IDENTIFIER:
					{
					int LA9_2 = input.LA(2);
					if ( ((synpred12_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt9=2;
					}

					}
					break;
				case 63:
				case 74:
				case 81:
				case 86:
					{
					alt9=1;
					}
					break;
				case 66:
				case 71:
				case 73:
				case 75:
				case 79:
				case 80:
				case 83:
				case 84:
				case 87:
				case 90:
				case 91:
				case 92:
					{
					alt9=2;
					}
					break;
				case 67:
				case 93:
					{
					alt9=3;
					}
					break;
				}
				switch (alt9) {
				case 1 :
					// C.g:126:10: storage_class_specifier
					{
					pushFollow(FOLLOW_storage_class_specifier_in_declaration_specifiers235);
					storage_class_specifier16=storage_class_specifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, storage_class_specifier16.getTree());

					}
					break;
				case 2 :
					// C.g:127:7: type_specifier
					{
					pushFollow(FOLLOW_type_specifier_in_declaration_specifiers243);
					type_specifier17=type_specifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_specifier17.getTree());

					}
					break;
				case 3 :
					// C.g:128:13: type_qualifier
					{
					pushFollow(FOLLOW_type_qualifier_in_declaration_specifiers257);
					type_qualifier18=type_qualifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_qualifier18.getTree());

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 5, declaration_specifiers_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "declaration_specifiers"


	public static class init_declarator_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "init_declarator_list"
	// C.g:132:1: init_declarator_list : init_declarator ( ',' init_declarator )* ;
	public final CParser.init_declarator_list_return init_declarator_list() throws RecognitionException {
		CParser.init_declarator_list_return retval = new CParser.init_declarator_list_return();
		retval.start = input.LT(1);
		int init_declarator_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal20=null;
		ParserRuleReturnScope init_declarator19 =null;
		ParserRuleReturnScope init_declarator21 =null;

		Object char_literal20_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

			// C.g:133:2: ( init_declarator ( ',' init_declarator )* )
			// C.g:133:4: init_declarator ( ',' init_declarator )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_init_declarator_in_init_declarator_list279);
			init_declarator19=init_declarator();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, init_declarator19.getTree());

			// C.g:133:20: ( ',' init_declarator )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==37) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C.g:133:21: ',' init_declarator
					{
					char_literal20=(Token)match(input,37,FOLLOW_37_in_init_declarator_list282); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal20_tree = (Object)adaptor.create(char_literal20);
					adaptor.addChild(root_0, char_literal20_tree);
					}

					pushFollow(FOLLOW_init_declarator_in_init_declarator_list284);
					init_declarator21=init_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, init_declarator21.getTree());

					}
					break;

				default :
					break loop10;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 6, init_declarator_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "init_declarator_list"


	public static class init_declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "init_declarator"
	// C.g:136:1: init_declarator : declarator ( '=' initializer )? ;
	public final CParser.init_declarator_return init_declarator() throws RecognitionException {
		CParser.init_declarator_return retval = new CParser.init_declarator_return();
		retval.start = input.LT(1);
		int init_declarator_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal23=null;
		ParserRuleReturnScope declarator22 =null;
		ParserRuleReturnScope initializer24 =null;

		Object char_literal23_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

			// C.g:137:2: ( declarator ( '=' initializer )? )
			// C.g:137:4: declarator ( '=' initializer )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_declarator_in_init_declarator297);
			declarator22=declarator();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator22.getTree());

			// C.g:137:15: ( '=' initializer )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==52) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// C.g:137:16: '=' initializer
					{
					char_literal23=(Token)match(input,52,FOLLOW_52_in_init_declarator300); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal23_tree = (Object)adaptor.create(char_literal23);
					adaptor.addChild(root_0, char_literal23_tree);
					}

					pushFollow(FOLLOW_initializer_in_init_declarator302);
					initializer24=initializer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, initializer24.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 7, init_declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "init_declarator"


	public static class storage_class_specifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "storage_class_specifier"
	// C.g:140:1: storage_class_specifier : ( 'extern' | 'static' | 'auto' | 'register' );
	public final CParser.storage_class_specifier_return storage_class_specifier() throws RecognitionException {
		CParser.storage_class_specifier_return retval = new CParser.storage_class_specifier_return();
		retval.start = input.LT(1);
		int storage_class_specifier_StartIndex = input.index();

		Object root_0 = null;

		Token set25=null;

		Object set25_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

			// C.g:141:2: ( 'extern' | 'static' | 'auto' | 'register' )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set25=input.LT(1);
			if ( input.LA(1)==63||input.LA(1)==74||input.LA(1)==81||input.LA(1)==86 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set25));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 8, storage_class_specifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "storage_class_specifier"


	public static class type_specifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_specifier"
	// C.g:147:1: type_specifier : ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | struct_or_union_specifier | enum_specifier | type_id );
	public final CParser.type_specifier_return type_specifier() throws RecognitionException {
		CParser.type_specifier_return retval = new CParser.type_specifier_return();
		retval.start = input.LT(1);
		int type_specifier_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal26=null;
		Token string_literal27=null;
		Token string_literal28=null;
		Token string_literal29=null;
		Token string_literal30=null;
		Token string_literal31=null;
		Token string_literal32=null;
		Token string_literal33=null;
		Token string_literal34=null;
		ParserRuleReturnScope struct_or_union_specifier35 =null;
		ParserRuleReturnScope enum_specifier36 =null;
		ParserRuleReturnScope type_id37 =null;

		Object string_literal26_tree=null;
		Object string_literal27_tree=null;
		Object string_literal28_tree=null;
		Object string_literal29_tree=null;
		Object string_literal30_tree=null;
		Object string_literal31_tree=null;
		Object string_literal32_tree=null;
		Object string_literal33_tree=null;
		Object string_literal34_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

			// C.g:148:2: ( 'void' | 'char' | 'short' | 'int' | 'long' | 'float' | 'double' | 'signed' | 'unsigned' | struct_or_union_specifier | enum_specifier | type_id )
			int alt12=12;
			switch ( input.LA(1) ) {
			case 92:
				{
				alt12=1;
				}
				break;
			case 66:
				{
				alt12=2;
				}
				break;
			case 83:
				{
				alt12=3;
				}
				break;
			case 79:
				{
				alt12=4;
				}
				break;
			case 80:
				{
				alt12=5;
				}
				break;
			case 75:
				{
				alt12=6;
				}
				break;
			case 71:
				{
				alt12=7;
				}
				break;
			case 84:
				{
				alt12=8;
				}
				break;
			case 91:
				{
				alt12=9;
				}
				break;
			case 87:
			case 90:
				{
				alt12=10;
				}
				break;
			case 73:
				{
				alt12=11;
				}
				break;
			case IDENTIFIER:
				{
				alt12=12;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// C.g:148:4: 'void'
					{
					root_0 = (Object)adaptor.nil();


					string_literal26=(Token)match(input,92,FOLLOW_92_in_type_specifier341); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal26_tree = (Object)adaptor.create(string_literal26);
					adaptor.addChild(root_0, string_literal26_tree);
					}

					}
					break;
				case 2 :
					// C.g:149:4: 'char'
					{
					root_0 = (Object)adaptor.nil();


					string_literal27=(Token)match(input,66,FOLLOW_66_in_type_specifier346); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal27_tree = (Object)adaptor.create(string_literal27);
					adaptor.addChild(root_0, string_literal27_tree);
					}

					}
					break;
				case 3 :
					// C.g:150:4: 'short'
					{
					root_0 = (Object)adaptor.nil();


					string_literal28=(Token)match(input,83,FOLLOW_83_in_type_specifier351); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal28_tree = (Object)adaptor.create(string_literal28);
					adaptor.addChild(root_0, string_literal28_tree);
					}

					}
					break;
				case 4 :
					// C.g:151:4: 'int'
					{
					root_0 = (Object)adaptor.nil();


					string_literal29=(Token)match(input,79,FOLLOW_79_in_type_specifier356); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal29_tree = (Object)adaptor.create(string_literal29);
					adaptor.addChild(root_0, string_literal29_tree);
					}

					}
					break;
				case 5 :
					// C.g:152:4: 'long'
					{
					root_0 = (Object)adaptor.nil();


					string_literal30=(Token)match(input,80,FOLLOW_80_in_type_specifier361); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal30_tree = (Object)adaptor.create(string_literal30);
					adaptor.addChild(root_0, string_literal30_tree);
					}

					}
					break;
				case 6 :
					// C.g:153:4: 'float'
					{
					root_0 = (Object)adaptor.nil();


					string_literal31=(Token)match(input,75,FOLLOW_75_in_type_specifier366); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal31_tree = (Object)adaptor.create(string_literal31);
					adaptor.addChild(root_0, string_literal31_tree);
					}

					}
					break;
				case 7 :
					// C.g:154:4: 'double'
					{
					root_0 = (Object)adaptor.nil();


					string_literal32=(Token)match(input,71,FOLLOW_71_in_type_specifier371); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal32_tree = (Object)adaptor.create(string_literal32);
					adaptor.addChild(root_0, string_literal32_tree);
					}

					}
					break;
				case 8 :
					// C.g:155:4: 'signed'
					{
					root_0 = (Object)adaptor.nil();


					string_literal33=(Token)match(input,84,FOLLOW_84_in_type_specifier376); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal33_tree = (Object)adaptor.create(string_literal33);
					adaptor.addChild(root_0, string_literal33_tree);
					}

					}
					break;
				case 9 :
					// C.g:156:4: 'unsigned'
					{
					root_0 = (Object)adaptor.nil();


					string_literal34=(Token)match(input,91,FOLLOW_91_in_type_specifier381); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal34_tree = (Object)adaptor.create(string_literal34);
					adaptor.addChild(root_0, string_literal34_tree);
					}

					}
					break;
				case 10 :
					// C.g:157:4: struct_or_union_specifier
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_struct_or_union_specifier_in_type_specifier386);
					struct_or_union_specifier35=struct_or_union_specifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_or_union_specifier35.getTree());

					}
					break;
				case 11 :
					// C.g:158:4: enum_specifier
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_enum_specifier_in_type_specifier391);
					enum_specifier36=enum_specifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enum_specifier36.getTree());

					}
					break;
				case 12 :
					// C.g:159:4: type_id
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_type_id_in_type_specifier396);
					type_id37=type_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_id37.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 9, type_specifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "type_specifier"


	public static class type_id_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_id"
	// C.g:162:1: type_id :{...}? IDENTIFIER ;
	public final CParser.type_id_return type_id() throws RecognitionException {
		CParser.type_id_return retval = new CParser.type_id_return();
		retval.start = input.LT(1);
		int type_id_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER38=null;

		Object IDENTIFIER38_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

			// C.g:163:5: ({...}? IDENTIFIER )
			// C.g:163:9: {...}? IDENTIFIER
			{
			root_0 = (Object)adaptor.nil();


			if ( !((isTypeName(input.LT(1).getText()))) ) {
				if (state.backtracking>0) {state.failed=true; return retval;}
				throw new FailedPredicateException(input, "type_id", "isTypeName(input.LT(1).getText())");
			}
			IDENTIFIER38=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_id414); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER38_tree = (Object)adaptor.create(IDENTIFIER38);
			adaptor.addChild(root_0, IDENTIFIER38_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 10, type_id_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "type_id"


	public static class struct_or_union_specifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_or_union_specifier"
	// C.g:167:1: struct_or_union_specifier options {k=3; } : ( struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}' | struct_or_union IDENTIFIER );
	public final CParser.struct_or_union_specifier_return struct_or_union_specifier() throws RecognitionException {
		Symbols_stack.push(new Symbols_scope());

		CParser.struct_or_union_specifier_return retval = new CParser.struct_or_union_specifier_return();
		retval.start = input.LT(1);
		int struct_or_union_specifier_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER40=null;
		Token char_literal41=null;
		Token char_literal43=null;
		Token IDENTIFIER45=null;
		ParserRuleReturnScope struct_or_union39 =null;
		ParserRuleReturnScope struct_declaration_list42 =null;
		ParserRuleReturnScope struct_or_union44 =null;

		Object IDENTIFIER40_tree=null;
		Object char_literal41_tree=null;
		Object char_literal43_tree=null;
		Object IDENTIFIER45_tree=null;


		  Symbols_stack.peek().types = new HashSet();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

			// C.g:173:2: ( struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}' | struct_or_union IDENTIFIER )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==87||LA14_0==90) ) {
				int LA14_1 = input.LA(2);
				if ( (LA14_1==IDENTIFIER) ) {
					int LA14_2 = input.LA(3);
					if ( (LA14_2==95) ) {
						alt14=1;
					}
					else if ( (LA14_2==EOF||LA14_2==IDENTIFIER||(LA14_2 >= 30 && LA14_2 <= 32)||LA14_2==37||(LA14_2 >= 46 && LA14_2 <= 47)||LA14_2==59||LA14_2==63||(LA14_2 >= 66 && LA14_2 <= 67)||LA14_2==71||(LA14_2 >= 73 && LA14_2 <= 75)||(LA14_2 >= 79 && LA14_2 <= 81)||(LA14_2 >= 83 && LA14_2 <= 84)||(LA14_2 >= 86 && LA14_2 <= 87)||(LA14_2 >= 90 && LA14_2 <= 93)) ) {
						alt14=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 14, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA14_1==95) ) {
					alt14=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// C.g:173:4: struct_or_union ( IDENTIFIER )? '{' struct_declaration_list '}'
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_struct_or_union_in_struct_or_union_specifier447);
					struct_or_union39=struct_or_union();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_or_union39.getTree());

					// C.g:173:20: ( IDENTIFIER )?
					int alt13=2;
					int LA13_0 = input.LA(1);
					if ( (LA13_0==IDENTIFIER) ) {
						alt13=1;
					}
					switch (alt13) {
						case 1 :
							// C.g:173:20: IDENTIFIER
							{
							IDENTIFIER40=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_specifier449); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							IDENTIFIER40_tree = (Object)adaptor.create(IDENTIFIER40);
							adaptor.addChild(root_0, IDENTIFIER40_tree);
							}

							}
							break;

					}

					char_literal41=(Token)match(input,95,FOLLOW_95_in_struct_or_union_specifier452); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal41_tree = (Object)adaptor.create(char_literal41);
					adaptor.addChild(root_0, char_literal41_tree);
					}

					pushFollow(FOLLOW_struct_declaration_list_in_struct_or_union_specifier454);
					struct_declaration_list42=struct_declaration_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declaration_list42.getTree());

					char_literal43=(Token)match(input,99,FOLLOW_99_in_struct_or_union_specifier456); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal43_tree = (Object)adaptor.create(char_literal43);
					adaptor.addChild(root_0, char_literal43_tree);
					}

					}
					break;
				case 2 :
					// C.g:174:4: struct_or_union IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_struct_or_union_in_struct_or_union_specifier461);
					struct_or_union44=struct_or_union();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_or_union44.getTree());

					IDENTIFIER45=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_struct_or_union_specifier463); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER45_tree = (Object)adaptor.create(IDENTIFIER45);
					adaptor.addChild(root_0, IDENTIFIER45_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 11, struct_or_union_specifier_StartIndex); }

			Symbols_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "struct_or_union_specifier"


	public static class struct_or_union_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_or_union"
	// C.g:177:1: struct_or_union : ( 'struct' | 'union' );
	public final CParser.struct_or_union_return struct_or_union() throws RecognitionException {
		CParser.struct_or_union_return retval = new CParser.struct_or_union_return();
		retval.start = input.LT(1);
		int struct_or_union_StartIndex = input.index();

		Object root_0 = null;

		Token set46=null;

		Object set46_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

			// C.g:178:2: ( 'struct' | 'union' )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set46=input.LT(1);
			if ( input.LA(1)==87||input.LA(1)==90 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set46));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 12, struct_or_union_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "struct_or_union"


	public static class struct_declaration_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_declaration_list"
	// C.g:182:1: struct_declaration_list : ( struct_declaration )+ ;
	public final CParser.struct_declaration_list_return struct_declaration_list() throws RecognitionException {
		CParser.struct_declaration_list_return retval = new CParser.struct_declaration_list_return();
		retval.start = input.LT(1);
		int struct_declaration_list_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope struct_declaration47 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

			// C.g:183:2: ( ( struct_declaration )+ )
			// C.g:183:4: ( struct_declaration )+
			{
			root_0 = (Object)adaptor.nil();


			// C.g:183:4: ( struct_declaration )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==IDENTIFIER||(LA15_0 >= 66 && LA15_0 <= 67)||LA15_0==71||LA15_0==73||LA15_0==75||(LA15_0 >= 79 && LA15_0 <= 80)||(LA15_0 >= 83 && LA15_0 <= 84)||LA15_0==87||(LA15_0 >= 90 && LA15_0 <= 93)) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C.g:183:4: struct_declaration
					{
					pushFollow(FOLLOW_struct_declaration_in_struct_declaration_list490);
					struct_declaration47=struct_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declaration47.getTree());

					}
					break;

				default :
					if ( cnt15 >= 1 ) break loop15;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 13, struct_declaration_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "struct_declaration_list"


	public static class struct_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_declaration"
	// C.g:186:1: struct_declaration : specifier_qualifier_list struct_declarator_list ';' ;
	public final CParser.struct_declaration_return struct_declaration() throws RecognitionException {
		CParser.struct_declaration_return retval = new CParser.struct_declaration_return();
		retval.start = input.LT(1);
		int struct_declaration_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal50=null;
		ParserRuleReturnScope specifier_qualifier_list48 =null;
		ParserRuleReturnScope struct_declarator_list49 =null;

		Object char_literal50_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

			// C.g:187:2: ( specifier_qualifier_list struct_declarator_list ';' )
			// C.g:187:4: specifier_qualifier_list struct_declarator_list ';'
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_specifier_qualifier_list_in_struct_declaration502);
			specifier_qualifier_list48=specifier_qualifier_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, specifier_qualifier_list48.getTree());

			pushFollow(FOLLOW_struct_declarator_list_in_struct_declaration504);
			struct_declarator_list49=struct_declarator_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declarator_list49.getTree());

			char_literal50=(Token)match(input,47,FOLLOW_47_in_struct_declaration506); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal50_tree = (Object)adaptor.create(char_literal50);
			adaptor.addChild(root_0, char_literal50_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 14, struct_declaration_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "struct_declaration"


	public static class specifier_qualifier_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "specifier_qualifier_list"
	// C.g:190:1: specifier_qualifier_list : ( type_qualifier | type_specifier )+ ;
	public final CParser.specifier_qualifier_list_return specifier_qualifier_list() throws RecognitionException {
		CParser.specifier_qualifier_list_return retval = new CParser.specifier_qualifier_list_return();
		retval.start = input.LT(1);
		int specifier_qualifier_list_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope type_qualifier51 =null;
		ParserRuleReturnScope type_specifier52 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

			// C.g:191:2: ( ( type_qualifier | type_specifier )+ )
			// C.g:191:4: ( type_qualifier | type_specifier )+
			{
			root_0 = (Object)adaptor.nil();


			// C.g:191:4: ( type_qualifier | type_specifier )+
			int cnt16=0;
			loop16:
			while (true) {
				int alt16=3;
				switch ( input.LA(1) ) {
				case IDENTIFIER:
					{
					switch ( input.LA(2) ) {
					case 59:
						{
						int LA16_19 = input.LA(3);
						if ( ((synpred35_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt16=2;
						}

						}
						break;
					case 30:
						{
						int LA16_20 = input.LA(3);
						if ( ((synpred35_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt16=2;
						}

						}
						break;
					case 46:
						{
						int LA16_21 = input.LA(3);
						if ( ((synpred35_C()&&(isTypeName(input.LT(1).getText())))) ) {
							alt16=2;
						}

						}
						break;
					case IDENTIFIER:
					case 31:
					case 32:
					case 66:
					case 67:
					case 71:
					case 73:
					case 75:
					case 79:
					case 80:
					case 83:
					case 84:
					case 87:
					case 90:
					case 91:
					case 92:
					case 93:
						{
						alt16=2;
						}
						break;
					}
					}
					break;
				case 67:
				case 93:
					{
					alt16=1;
					}
					break;
				case 66:
				case 71:
				case 73:
				case 75:
				case 79:
				case 80:
				case 83:
				case 84:
				case 87:
				case 90:
				case 91:
				case 92:
					{
					alt16=2;
					}
					break;
				}
				switch (alt16) {
				case 1 :
					// C.g:191:6: type_qualifier
					{
					pushFollow(FOLLOW_type_qualifier_in_specifier_qualifier_list519);
					type_qualifier51=type_qualifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_qualifier51.getTree());

					}
					break;
				case 2 :
					// C.g:191:23: type_specifier
					{
					pushFollow(FOLLOW_type_specifier_in_specifier_qualifier_list523);
					type_specifier52=type_specifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_specifier52.getTree());

					}
					break;

				default :
					if ( cnt16 >= 1 ) break loop16;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(16, input);
					throw eee;
				}
				cnt16++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 15, specifier_qualifier_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "specifier_qualifier_list"


	public static class struct_declarator_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_declarator_list"
	// C.g:194:1: struct_declarator_list : struct_declarator ( ',' struct_declarator )* ;
	public final CParser.struct_declarator_list_return struct_declarator_list() throws RecognitionException {
		CParser.struct_declarator_list_return retval = new CParser.struct_declarator_list_return();
		retval.start = input.LT(1);
		int struct_declarator_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal54=null;
		ParserRuleReturnScope struct_declarator53 =null;
		ParserRuleReturnScope struct_declarator55 =null;

		Object char_literal54_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

			// C.g:195:2: ( struct_declarator ( ',' struct_declarator )* )
			// C.g:195:4: struct_declarator ( ',' struct_declarator )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list537);
			struct_declarator53=struct_declarator();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declarator53.getTree());

			// C.g:195:22: ( ',' struct_declarator )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==37) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// C.g:195:23: ',' struct_declarator
					{
					char_literal54=(Token)match(input,37,FOLLOW_37_in_struct_declarator_list540); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal54_tree = (Object)adaptor.create(char_literal54);
					adaptor.addChild(root_0, char_literal54_tree);
					}

					pushFollow(FOLLOW_struct_declarator_in_struct_declarator_list542);
					struct_declarator55=struct_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, struct_declarator55.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 16, struct_declarator_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "struct_declarator_list"


	public static class struct_declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "struct_declarator"
	// C.g:198:1: struct_declarator : ( declarator ( ':' constant_expression )? | ':' constant_expression );
	public final CParser.struct_declarator_return struct_declarator() throws RecognitionException {
		CParser.struct_declarator_return retval = new CParser.struct_declarator_return();
		retval.start = input.LT(1);
		int struct_declarator_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal57=null;
		Token char_literal59=null;
		ParserRuleReturnScope declarator56 =null;
		ParserRuleReturnScope constant_expression58 =null;
		ParserRuleReturnScope constant_expression60 =null;

		Object char_literal57_tree=null;
		Object char_literal59_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

			// C.g:199:2: ( declarator ( ':' constant_expression )? | ':' constant_expression )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==IDENTIFIER||LA19_0==30||LA19_0==32) ) {
				alt19=1;
			}
			else if ( (LA19_0==46) ) {
				alt19=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// C.g:199:4: declarator ( ':' constant_expression )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_declarator_in_struct_declarator555);
					declarator56=declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator56.getTree());

					// C.g:199:15: ( ':' constant_expression )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==46) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// C.g:199:16: ':' constant_expression
							{
							char_literal57=(Token)match(input,46,FOLLOW_46_in_struct_declarator558); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal57_tree = (Object)adaptor.create(char_literal57);
							adaptor.addChild(root_0, char_literal57_tree);
							}

							pushFollow(FOLLOW_constant_expression_in_struct_declarator560);
							constant_expression58=constant_expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression58.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// C.g:200:4: ':' constant_expression
					{
					root_0 = (Object)adaptor.nil();


					char_literal59=(Token)match(input,46,FOLLOW_46_in_struct_declarator567); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal59_tree = (Object)adaptor.create(char_literal59);
					adaptor.addChild(root_0, char_literal59_tree);
					}

					pushFollow(FOLLOW_constant_expression_in_struct_declarator569);
					constant_expression60=constant_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression60.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 17, struct_declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "struct_declarator"


	public static class enum_specifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enum_specifier"
	// C.g:203:1: enum_specifier options {k=3; } : ( 'enum' '{' enumerator_list '}' | 'enum' IDENTIFIER '{' enumerator_list '}' | 'enum' IDENTIFIER );
	public final CParser.enum_specifier_return enum_specifier() throws RecognitionException {
		CParser.enum_specifier_return retval = new CParser.enum_specifier_return();
		retval.start = input.LT(1);
		int enum_specifier_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal61=null;
		Token char_literal62=null;
		Token char_literal64=null;
		Token string_literal65=null;
		Token IDENTIFIER66=null;
		Token char_literal67=null;
		Token char_literal69=null;
		Token string_literal70=null;
		Token IDENTIFIER71=null;
		ParserRuleReturnScope enumerator_list63 =null;
		ParserRuleReturnScope enumerator_list68 =null;

		Object string_literal61_tree=null;
		Object char_literal62_tree=null;
		Object char_literal64_tree=null;
		Object string_literal65_tree=null;
		Object IDENTIFIER66_tree=null;
		Object char_literal67_tree=null;
		Object char_literal69_tree=null;
		Object string_literal70_tree=null;
		Object IDENTIFIER71_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

			// C.g:205:2: ( 'enum' '{' enumerator_list '}' | 'enum' IDENTIFIER '{' enumerator_list '}' | 'enum' IDENTIFIER )
			int alt20=3;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==73) ) {
				int LA20_1 = input.LA(2);
				if ( (LA20_1==95) ) {
					alt20=1;
				}
				else if ( (LA20_1==IDENTIFIER) ) {
					int LA20_3 = input.LA(3);
					if ( (LA20_3==95) ) {
						alt20=2;
					}
					else if ( (LA20_3==EOF||LA20_3==IDENTIFIER||(LA20_3 >= 30 && LA20_3 <= 32)||LA20_3==37||(LA20_3 >= 46 && LA20_3 <= 47)||LA20_3==59||LA20_3==63||(LA20_3 >= 66 && LA20_3 <= 67)||LA20_3==71||(LA20_3 >= 73 && LA20_3 <= 75)||(LA20_3 >= 79 && LA20_3 <= 81)||(LA20_3 >= 83 && LA20_3 <= 84)||(LA20_3 >= 86 && LA20_3 <= 87)||(LA20_3 >= 90 && LA20_3 <= 93)) ) {
						alt20=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 20, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// C.g:205:4: 'enum' '{' enumerator_list '}'
					{
					root_0 = (Object)adaptor.nil();


					string_literal61=(Token)match(input,73,FOLLOW_73_in_enum_specifier587); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal61_tree = (Object)adaptor.create(string_literal61);
					adaptor.addChild(root_0, string_literal61_tree);
					}

					char_literal62=(Token)match(input,95,FOLLOW_95_in_enum_specifier589); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal62_tree = (Object)adaptor.create(char_literal62);
					adaptor.addChild(root_0, char_literal62_tree);
					}

					pushFollow(FOLLOW_enumerator_list_in_enum_specifier591);
					enumerator_list63=enumerator_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enumerator_list63.getTree());

					char_literal64=(Token)match(input,99,FOLLOW_99_in_enum_specifier593); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal64_tree = (Object)adaptor.create(char_literal64);
					adaptor.addChild(root_0, char_literal64_tree);
					}

					}
					break;
				case 2 :
					// C.g:206:4: 'enum' IDENTIFIER '{' enumerator_list '}'
					{
					root_0 = (Object)adaptor.nil();


					string_literal65=(Token)match(input,73,FOLLOW_73_in_enum_specifier598); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal65_tree = (Object)adaptor.create(string_literal65);
					adaptor.addChild(root_0, string_literal65_tree);
					}

					IDENTIFIER66=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_specifier600); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER66_tree = (Object)adaptor.create(IDENTIFIER66);
					adaptor.addChild(root_0, IDENTIFIER66_tree);
					}

					char_literal67=(Token)match(input,95,FOLLOW_95_in_enum_specifier602); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal67_tree = (Object)adaptor.create(char_literal67);
					adaptor.addChild(root_0, char_literal67_tree);
					}

					pushFollow(FOLLOW_enumerator_list_in_enum_specifier604);
					enumerator_list68=enumerator_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enumerator_list68.getTree());

					char_literal69=(Token)match(input,99,FOLLOW_99_in_enum_specifier606); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal69_tree = (Object)adaptor.create(char_literal69);
					adaptor.addChild(root_0, char_literal69_tree);
					}

					}
					break;
				case 3 :
					// C.g:207:4: 'enum' IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					string_literal70=(Token)match(input,73,FOLLOW_73_in_enum_specifier611); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal70_tree = (Object)adaptor.create(string_literal70);
					adaptor.addChild(root_0, string_literal70_tree);
					}

					IDENTIFIER71=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enum_specifier613); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER71_tree = (Object)adaptor.create(IDENTIFIER71);
					adaptor.addChild(root_0, IDENTIFIER71_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 18, enum_specifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "enum_specifier"


	public static class enumerator_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enumerator_list"
	// C.g:210:1: enumerator_list : enumerator ( ',' enumerator )* ;
	public final CParser.enumerator_list_return enumerator_list() throws RecognitionException {
		CParser.enumerator_list_return retval = new CParser.enumerator_list_return();
		retval.start = input.LT(1);
		int enumerator_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal73=null;
		ParserRuleReturnScope enumerator72 =null;
		ParserRuleReturnScope enumerator74 =null;

		Object char_literal73_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }

			// C.g:211:2: ( enumerator ( ',' enumerator )* )
			// C.g:211:4: enumerator ( ',' enumerator )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_enumerator_in_enumerator_list624);
			enumerator72=enumerator();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, enumerator72.getTree());

			// C.g:211:15: ( ',' enumerator )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==37) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// C.g:211:16: ',' enumerator
					{
					char_literal73=(Token)match(input,37,FOLLOW_37_in_enumerator_list627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal73_tree = (Object)adaptor.create(char_literal73);
					adaptor.addChild(root_0, char_literal73_tree);
					}

					pushFollow(FOLLOW_enumerator_in_enumerator_list629);
					enumerator74=enumerator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, enumerator74.getTree());

					}
					break;

				default :
					break loop21;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 19, enumerator_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "enumerator_list"


	public static class enumerator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "enumerator"
	// C.g:214:1: enumerator : IDENTIFIER ( '=' constant_expression )? ;
	public final CParser.enumerator_return enumerator() throws RecognitionException {
		CParser.enumerator_return retval = new CParser.enumerator_return();
		retval.start = input.LT(1);
		int enumerator_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER75=null;
		Token char_literal76=null;
		ParserRuleReturnScope constant_expression77 =null;

		Object IDENTIFIER75_tree=null;
		Object char_literal76_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }

			// C.g:215:2: ( IDENTIFIER ( '=' constant_expression )? )
			// C.g:215:4: IDENTIFIER ( '=' constant_expression )?
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER75=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_enumerator642); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER75_tree = (Object)adaptor.create(IDENTIFIER75);
			adaptor.addChild(root_0, IDENTIFIER75_tree);
			}

			// C.g:215:15: ( '=' constant_expression )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==52) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// C.g:215:16: '=' constant_expression
					{
					char_literal76=(Token)match(input,52,FOLLOW_52_in_enumerator645); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal76_tree = (Object)adaptor.create(char_literal76);
					adaptor.addChild(root_0, char_literal76_tree);
					}

					pushFollow(FOLLOW_constant_expression_in_enumerator647);
					constant_expression77=constant_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression77.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 20, enumerator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "enumerator"


	public static class type_qualifier_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_qualifier"
	// C.g:218:1: type_qualifier : ( 'const' | 'volatile' );
	public final CParser.type_qualifier_return type_qualifier() throws RecognitionException {
		CParser.type_qualifier_return retval = new CParser.type_qualifier_return();
		retval.start = input.LT(1);
		int type_qualifier_StartIndex = input.index();

		Object root_0 = null;

		Token set78=null;

		Object set78_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }

			// C.g:219:2: ( 'const' | 'volatile' )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set78=input.LT(1);
			if ( input.LA(1)==67||input.LA(1)==93 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set78));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 21, type_qualifier_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "type_qualifier"


	public static class declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declarator"
	// C.g:223:1: declarator : ( ( pointer )? direct_declarator | pointer );
	public final CParser.declarator_return declarator() throws RecognitionException {
		CParser.declarator_return retval = new CParser.declarator_return();
		retval.start = input.LT(1);
		int declarator_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope pointer79 =null;
		ParserRuleReturnScope direct_declarator80 =null;
		ParserRuleReturnScope pointer81 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }

			// C.g:224:2: ( ( pointer )? direct_declarator | pointer )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==32) ) {
				int LA24_1 = input.LA(2);
				if ( (synpred45_C()) ) {
					alt24=1;
				}
				else if ( (true) ) {
					alt24=2;
				}

			}
			else if ( (LA24_0==IDENTIFIER||LA24_0==30) ) {
				alt24=1;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// C.g:224:4: ( pointer )? direct_declarator
					{
					root_0 = (Object)adaptor.nil();


					// C.g:224:4: ( pointer )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==32) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// C.g:224:4: pointer
							{
							pushFollow(FOLLOW_pointer_in_declarator676);
							pointer79=pointer();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, pointer79.getTree());

							}
							break;

					}

					pushFollow(FOLLOW_direct_declarator_in_declarator679);
					direct_declarator80=direct_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, direct_declarator80.getTree());

					}
					break;
				case 2 :
					// C.g:225:4: pointer
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pointer_in_declarator684);
					pointer81=pointer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pointer81.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 22, declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "declarator"


	public static class direct_declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "direct_declarator"
	// C.g:228:1: direct_declarator : ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* ;
	public final CParser.direct_declarator_return direct_declarator() throws RecognitionException {
		CParser.direct_declarator_return retval = new CParser.direct_declarator_return();
		retval.start = input.LT(1);
		int direct_declarator_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER82=null;
		Token char_literal83=null;
		Token char_literal85=null;
		ParserRuleReturnScope declarator84 =null;
		ParserRuleReturnScope declarator_suffix86 =null;

		Object IDENTIFIER82_tree=null;
		Object char_literal83_tree=null;
		Object char_literal85_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }

			// C.g:229:2: ( ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )* )
			// C.g:229:6: ( IDENTIFIER | '(' declarator ')' ) ( declarator_suffix )*
			{
			root_0 = (Object)adaptor.nil();


			// C.g:229:6: ( IDENTIFIER | '(' declarator ')' )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==IDENTIFIER) ) {
				alt25=1;
			}
			else if ( (LA25_0==30) ) {
				alt25=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// C.g:229:8: IDENTIFIER
					{
					IDENTIFIER82=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_direct_declarator699); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER82_tree = (Object)adaptor.create(IDENTIFIER82);
					adaptor.addChild(root_0, IDENTIFIER82_tree);
					}

					if ( state.backtracking==0 ) {
								if (declaration_stack.size()>0&&declaration_stack.peek().isTypedef) {
									Symbols_stack.peek().types.add((IDENTIFIER82!=null?IDENTIFIER82.getText():null));
									System.out.println("define type "+(IDENTIFIER82!=null?IDENTIFIER82.getText():null));
								}
								}
					}
					break;
				case 2 :
					// C.g:236:5: '(' declarator ')'
					{
					char_literal83=(Token)match(input,30,FOLLOW_30_in_direct_declarator710); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal83_tree = (Object)adaptor.create(char_literal83);
					adaptor.addChild(root_0, char_literal83_tree);
					}

					pushFollow(FOLLOW_declarator_in_direct_declarator712);
					declarator84=declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator84.getTree());

					char_literal85=(Token)match(input,31,FOLLOW_31_in_direct_declarator714); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal85_tree = (Object)adaptor.create(char_literal85);
					adaptor.addChild(root_0, char_literal85_tree);
					}

					}
					break;

			}

			// C.g:238:9: ( declarator_suffix )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==30) ) {
					switch ( input.LA(2) ) {
					case 31:
						{
						int LA26_26 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case IDENTIFIER:
						{
						int LA26_28 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 63:
					case 74:
					case 81:
					case 86:
						{
						int LA26_31 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 92:
						{
						int LA26_32 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 66:
						{
						int LA26_33 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 83:
						{
						int LA26_34 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 79:
						{
						int LA26_35 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 80:
						{
						int LA26_36 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 75:
						{
						int LA26_37 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 71:
						{
						int LA26_38 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 84:
						{
						int LA26_39 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 91:
						{
						int LA26_40 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 87:
					case 90:
						{
						int LA26_41 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 73:
						{
						int LA26_42 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 67:
					case 93:
						{
						int LA26_43 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					}
				}
				else if ( (LA26_0==59) ) {
					switch ( input.LA(2) ) {
					case 60:
						{
						int LA26_44 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 30:
						{
						int LA26_45 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case IDENTIFIER:
						{
						int LA26_46 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case CHARACTER_LITERAL:
					case DECIMAL_LITERAL:
					case FLOATING_POINT_LITERAL:
					case HEX_LITERAL:
					case OCTAL_LITERAL:
					case STRING_LITERAL:
						{
						int LA26_47 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 35:
						{
						int LA26_48 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 39:
						{
						int LA26_49 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 23:
					case 28:
					case 32:
					case 34:
					case 38:
					case 100:
						{
						int LA26_50 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					case 85:
						{
						int LA26_51 = input.LA(3);
						if ( (synpred47_C()) ) {
							alt26=1;
						}

						}
						break;
					}
				}

				switch (alt26) {
				case 1 :
					// C.g:238:9: declarator_suffix
					{
					pushFollow(FOLLOW_declarator_suffix_in_direct_declarator728);
					declarator_suffix86=declarator_suffix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator_suffix86.getTree());

					}
					break;

				default :
					break loop26;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 23, direct_declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "direct_declarator"


	public static class declarator_suffix_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "declarator_suffix"
	// C.g:241:1: declarator_suffix : ( '[' constant_expression ']' | '[' ']' | '(' parameter_type_list ')' | '(' identifier_list ')' | '(' ')' );
	public final CParser.declarator_suffix_return declarator_suffix() throws RecognitionException {
		CParser.declarator_suffix_return retval = new CParser.declarator_suffix_return();
		retval.start = input.LT(1);
		int declarator_suffix_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal87=null;
		Token char_literal89=null;
		Token char_literal90=null;
		Token char_literal91=null;
		Token char_literal92=null;
		Token char_literal94=null;
		Token char_literal95=null;
		Token char_literal97=null;
		Token char_literal98=null;
		Token char_literal99=null;
		ParserRuleReturnScope constant_expression88 =null;
		ParserRuleReturnScope parameter_type_list93 =null;
		ParserRuleReturnScope identifier_list96 =null;

		Object char_literal87_tree=null;
		Object char_literal89_tree=null;
		Object char_literal90_tree=null;
		Object char_literal91_tree=null;
		Object char_literal92_tree=null;
		Object char_literal94_tree=null;
		Object char_literal95_tree=null;
		Object char_literal97_tree=null;
		Object char_literal98_tree=null;
		Object char_literal99_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }

			// C.g:242:2: ( '[' constant_expression ']' | '[' ']' | '(' parameter_type_list ')' | '(' identifier_list ')' | '(' ')' )
			int alt27=5;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==59) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==60) ) {
					alt27=2;
				}
				else if ( (LA27_1==CHARACTER_LITERAL||LA27_1==DECIMAL_LITERAL||LA27_1==FLOATING_POINT_LITERAL||LA27_1==HEX_LITERAL||LA27_1==IDENTIFIER||LA27_1==OCTAL_LITERAL||LA27_1==STRING_LITERAL||LA27_1==23||LA27_1==28||LA27_1==30||LA27_1==32||(LA27_1 >= 34 && LA27_1 <= 35)||(LA27_1 >= 38 && LA27_1 <= 39)||LA27_1==85||LA27_1==100) ) {
					alt27=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA27_0==30) ) {
				switch ( input.LA(2) ) {
				case 31:
					{
					alt27=5;
					}
					break;
				case 63:
				case 66:
				case 67:
				case 71:
				case 73:
				case 74:
				case 75:
				case 79:
				case 80:
				case 81:
				case 83:
				case 84:
				case 86:
				case 87:
				case 90:
				case 91:
				case 92:
				case 93:
					{
					alt27=3;
					}
					break;
				case IDENTIFIER:
					{
					int LA27_24 = input.LA(3);
					if ( (synpred50_C()) ) {
						alt27=3;
					}
					else if ( (synpred51_C()) ) {
						alt27=4;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 27, 24, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// C.g:242:6: '[' constant_expression ']'
					{
					root_0 = (Object)adaptor.nil();


					char_literal87=(Token)match(input,59,FOLLOW_59_in_declarator_suffix742); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal87_tree = (Object)adaptor.create(char_literal87);
					adaptor.addChild(root_0, char_literal87_tree);
					}

					pushFollow(FOLLOW_constant_expression_in_declarator_suffix744);
					constant_expression88=constant_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression88.getTree());

					char_literal89=(Token)match(input,60,FOLLOW_60_in_declarator_suffix746); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal89_tree = (Object)adaptor.create(char_literal89);
					adaptor.addChild(root_0, char_literal89_tree);
					}

					}
					break;
				case 2 :
					// C.g:243:9: '[' ']'
					{
					root_0 = (Object)adaptor.nil();


					char_literal90=(Token)match(input,59,FOLLOW_59_in_declarator_suffix756); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal90_tree = (Object)adaptor.create(char_literal90);
					adaptor.addChild(root_0, char_literal90_tree);
					}

					char_literal91=(Token)match(input,60,FOLLOW_60_in_declarator_suffix758); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal91_tree = (Object)adaptor.create(char_literal91);
					adaptor.addChild(root_0, char_literal91_tree);
					}

					}
					break;
				case 3 :
					// C.g:244:9: '(' parameter_type_list ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal92=(Token)match(input,30,FOLLOW_30_in_declarator_suffix768); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal92_tree = (Object)adaptor.create(char_literal92);
					adaptor.addChild(root_0, char_literal92_tree);
					}

					pushFollow(FOLLOW_parameter_type_list_in_declarator_suffix770);
					parameter_type_list93=parameter_type_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, parameter_type_list93.getTree());

					char_literal94=(Token)match(input,31,FOLLOW_31_in_declarator_suffix772); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal94_tree = (Object)adaptor.create(char_literal94);
					adaptor.addChild(root_0, char_literal94_tree);
					}

					}
					break;
				case 4 :
					// C.g:245:9: '(' identifier_list ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal95=(Token)match(input,30,FOLLOW_30_in_declarator_suffix782); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal95_tree = (Object)adaptor.create(char_literal95);
					adaptor.addChild(root_0, char_literal95_tree);
					}

					pushFollow(FOLLOW_identifier_list_in_declarator_suffix784);
					identifier_list96=identifier_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, identifier_list96.getTree());

					char_literal97=(Token)match(input,31,FOLLOW_31_in_declarator_suffix786); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal97_tree = (Object)adaptor.create(char_literal97);
					adaptor.addChild(root_0, char_literal97_tree);
					}

					}
					break;
				case 5 :
					// C.g:246:9: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal98=(Token)match(input,30,FOLLOW_30_in_declarator_suffix796); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal98_tree = (Object)adaptor.create(char_literal98);
					adaptor.addChild(root_0, char_literal98_tree);
					}

					char_literal99=(Token)match(input,31,FOLLOW_31_in_declarator_suffix798); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal99_tree = (Object)adaptor.create(char_literal99);
					adaptor.addChild(root_0, char_literal99_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 24, declarator_suffix_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "declarator_suffix"


	public static class pointer_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "pointer"
	// C.g:249:1: pointer : ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' );
	public final CParser.pointer_return pointer() throws RecognitionException {
		CParser.pointer_return retval = new CParser.pointer_return();
		retval.start = input.LT(1);
		int pointer_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal100=null;
		Token char_literal103=null;
		Token char_literal105=null;
		ParserRuleReturnScope type_qualifier101 =null;
		ParserRuleReturnScope pointer102 =null;
		ParserRuleReturnScope pointer104 =null;

		Object char_literal100_tree=null;
		Object char_literal103_tree=null;
		Object char_literal105_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }

			// C.g:250:2: ( '*' ( type_qualifier )+ ( pointer )? | '*' pointer | '*' )
			int alt30=3;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==32) ) {
				switch ( input.LA(2) ) {
				case 67:
				case 93:
					{
					int LA30_2 = input.LA(3);
					if ( (synpred54_C()) ) {
						alt30=1;
					}
					else if ( (true) ) {
						alt30=3;
					}

					}
					break;
				case 32:
					{
					int LA30_3 = input.LA(3);
					if ( (synpred55_C()) ) {
						alt30=2;
					}
					else if ( (true) ) {
						alt30=3;
					}

					}
					break;
				case EOF:
				case IDENTIFIER:
				case 30:
				case 31:
				case 37:
				case 46:
				case 47:
				case 52:
				case 59:
				case 63:
				case 66:
				case 71:
				case 73:
				case 74:
				case 75:
				case 79:
				case 80:
				case 81:
				case 83:
				case 84:
				case 86:
				case 87:
				case 89:
				case 90:
				case 91:
				case 92:
				case 95:
					{
					alt30=3;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// C.g:250:4: '*' ( type_qualifier )+ ( pointer )?
					{
					root_0 = (Object)adaptor.nil();


					char_literal100=(Token)match(input,32,FOLLOW_32_in_pointer809); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal100_tree = (Object)adaptor.create(char_literal100);
					adaptor.addChild(root_0, char_literal100_tree);
					}

					// C.g:250:8: ( type_qualifier )+
					int cnt28=0;
					loop28:
					while (true) {
						int alt28=2;
						int LA28_0 = input.LA(1);
						if ( (LA28_0==67||LA28_0==93) ) {
							int LA28_17 = input.LA(2);
							if ( (synpred52_C()) ) {
								alt28=1;
							}

						}

						switch (alt28) {
						case 1 :
							// C.g:250:8: type_qualifier
							{
							pushFollow(FOLLOW_type_qualifier_in_pointer811);
							type_qualifier101=type_qualifier();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, type_qualifier101.getTree());

							}
							break;

						default :
							if ( cnt28 >= 1 ) break loop28;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(28, input);
							throw eee;
						}
						cnt28++;
					}

					// C.g:250:24: ( pointer )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==32) ) {
						int LA29_1 = input.LA(2);
						if ( (synpred53_C()) ) {
							alt29=1;
						}
					}
					switch (alt29) {
						case 1 :
							// C.g:250:24: pointer
							{
							pushFollow(FOLLOW_pointer_in_pointer814);
							pointer102=pointer();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, pointer102.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// C.g:251:4: '*' pointer
					{
					root_0 = (Object)adaptor.nil();


					char_literal103=(Token)match(input,32,FOLLOW_32_in_pointer820); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal103_tree = (Object)adaptor.create(char_literal103);
					adaptor.addChild(root_0, char_literal103_tree);
					}

					pushFollow(FOLLOW_pointer_in_pointer822);
					pointer104=pointer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pointer104.getTree());

					}
					break;
				case 3 :
					// C.g:252:4: '*'
					{
					root_0 = (Object)adaptor.nil();


					char_literal105=(Token)match(input,32,FOLLOW_32_in_pointer827); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal105_tree = (Object)adaptor.create(char_literal105);
					adaptor.addChild(root_0, char_literal105_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 25, pointer_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "pointer"


	public static class parameter_type_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parameter_type_list"
	// C.g:255:1: parameter_type_list : parameter_list ( ',' '...' )? ;
	public final CParser.parameter_type_list_return parameter_type_list() throws RecognitionException {
		CParser.parameter_type_list_return retval = new CParser.parameter_type_list_return();
		retval.start = input.LT(1);
		int parameter_type_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal107=null;
		Token string_literal108=null;
		ParserRuleReturnScope parameter_list106 =null;

		Object char_literal107_tree=null;
		Object string_literal108_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }

			// C.g:256:2: ( parameter_list ( ',' '...' )? )
			// C.g:256:4: parameter_list ( ',' '...' )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_parameter_list_in_parameter_type_list838);
			parameter_list106=parameter_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, parameter_list106.getTree());

			// C.g:256:19: ( ',' '...' )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==37) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// C.g:256:20: ',' '...'
					{
					char_literal107=(Token)match(input,37,FOLLOW_37_in_parameter_type_list841); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal107_tree = (Object)adaptor.create(char_literal107);
					adaptor.addChild(root_0, char_literal107_tree);
					}

					string_literal108=(Token)match(input,43,FOLLOW_43_in_parameter_type_list843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal108_tree = (Object)adaptor.create(string_literal108);
					adaptor.addChild(root_0, string_literal108_tree);
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 26, parameter_type_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "parameter_type_list"


	public static class parameter_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parameter_list"
	// C.g:259:1: parameter_list : parameter_declaration ( ',' parameter_declaration )* ;
	public final CParser.parameter_list_return parameter_list() throws RecognitionException {
		CParser.parameter_list_return retval = new CParser.parameter_list_return();
		retval.start = input.LT(1);
		int parameter_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal110=null;
		ParserRuleReturnScope parameter_declaration109 =null;
		ParserRuleReturnScope parameter_declaration111 =null;

		Object char_literal110_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }

			// C.g:260:2: ( parameter_declaration ( ',' parameter_declaration )* )
			// C.g:260:4: parameter_declaration ( ',' parameter_declaration )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_parameter_declaration_in_parameter_list856);
			parameter_declaration109=parameter_declaration();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, parameter_declaration109.getTree());

			// C.g:260:26: ( ',' parameter_declaration )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==37) ) {
					int LA32_1 = input.LA(2);
					if ( (LA32_1==IDENTIFIER||LA32_1==63||(LA32_1 >= 66 && LA32_1 <= 67)||LA32_1==71||(LA32_1 >= 73 && LA32_1 <= 75)||(LA32_1 >= 79 && LA32_1 <= 81)||(LA32_1 >= 83 && LA32_1 <= 84)||(LA32_1 >= 86 && LA32_1 <= 87)||(LA32_1 >= 90 && LA32_1 <= 93)) ) {
						alt32=1;
					}

				}

				switch (alt32) {
				case 1 :
					// C.g:260:27: ',' parameter_declaration
					{
					char_literal110=(Token)match(input,37,FOLLOW_37_in_parameter_list859); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal110_tree = (Object)adaptor.create(char_literal110);
					adaptor.addChild(root_0, char_literal110_tree);
					}

					pushFollow(FOLLOW_parameter_declaration_in_parameter_list861);
					parameter_declaration111=parameter_declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, parameter_declaration111.getTree());

					}
					break;

				default :
					break loop32;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 27, parameter_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "parameter_list"


	public static class parameter_declaration_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "parameter_declaration"
	// C.g:263:1: parameter_declaration : declaration_specifiers ( declarator | abstract_declarator )* ;
	public final CParser.parameter_declaration_return parameter_declaration() throws RecognitionException {
		CParser.parameter_declaration_return retval = new CParser.parameter_declaration_return();
		retval.start = input.LT(1);
		int parameter_declaration_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope declaration_specifiers112 =null;
		ParserRuleReturnScope declarator113 =null;
		ParserRuleReturnScope abstract_declarator114 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }

			// C.g:264:2: ( declaration_specifiers ( declarator | abstract_declarator )* )
			// C.g:264:4: declaration_specifiers ( declarator | abstract_declarator )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_declaration_specifiers_in_parameter_declaration874);
			declaration_specifiers112=declaration_specifiers();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration_specifiers112.getTree());

			// C.g:264:27: ( declarator | abstract_declarator )*
			loop33:
			while (true) {
				int alt33=3;
				switch ( input.LA(1) ) {
				case 32:
					{
					int LA33_4 = input.LA(2);
					if ( (synpred58_C()) ) {
						alt33=1;
					}
					else if ( (synpred59_C()) ) {
						alt33=2;
					}

					}
					break;
				case IDENTIFIER:
					{
					alt33=1;
					}
					break;
				case 30:
					{
					switch ( input.LA(2) ) {
					case 31:
					case 59:
					case 63:
					case 66:
					case 67:
					case 71:
					case 73:
					case 74:
					case 75:
					case 79:
					case 80:
					case 81:
					case 83:
					case 84:
					case 86:
					case 87:
					case 90:
					case 91:
					case 92:
					case 93:
						{
						alt33=2;
						}
						break;
					case 32:
						{
						int LA33_17 = input.LA(3);
						if ( (synpred58_C()) ) {
							alt33=1;
						}
						else if ( (synpred59_C()) ) {
							alt33=2;
						}

						}
						break;
					case IDENTIFIER:
						{
						int LA33_18 = input.LA(3);
						if ( (synpred58_C()) ) {
							alt33=1;
						}
						else if ( (synpred59_C()) ) {
							alt33=2;
						}

						}
						break;
					case 30:
						{
						int LA33_19 = input.LA(3);
						if ( (synpred58_C()) ) {
							alt33=1;
						}
						else if ( (synpred59_C()) ) {
							alt33=2;
						}

						}
						break;
					}
					}
					break;
				case 59:
					{
					alt33=2;
					}
					break;
				}
				switch (alt33) {
				case 1 :
					// C.g:264:28: declarator
					{
					pushFollow(FOLLOW_declarator_in_parameter_declaration877);
					declarator113=declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declarator113.getTree());

					}
					break;
				case 2 :
					// C.g:264:39: abstract_declarator
					{
					pushFollow(FOLLOW_abstract_declarator_in_parameter_declaration879);
					abstract_declarator114=abstract_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, abstract_declarator114.getTree());

					}
					break;

				default :
					break loop33;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 28, parameter_declaration_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "parameter_declaration"


	public static class identifier_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "identifier_list"
	// C.g:267:1: identifier_list : IDENTIFIER ( ',' IDENTIFIER )* ;
	public final CParser.identifier_list_return identifier_list() throws RecognitionException {
		CParser.identifier_list_return retval = new CParser.identifier_list_return();
		retval.start = input.LT(1);
		int identifier_list_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER115=null;
		Token char_literal116=null;
		Token IDENTIFIER117=null;

		Object IDENTIFIER115_tree=null;
		Object char_literal116_tree=null;
		Object IDENTIFIER117_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }

			// C.g:268:2: ( IDENTIFIER ( ',' IDENTIFIER )* )
			// C.g:268:4: IDENTIFIER ( ',' IDENTIFIER )*
			{
			root_0 = (Object)adaptor.nil();


			IDENTIFIER115=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier_list892); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENTIFIER115_tree = (Object)adaptor.create(IDENTIFIER115);
			adaptor.addChild(root_0, IDENTIFIER115_tree);
			}

			// C.g:268:15: ( ',' IDENTIFIER )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( (LA34_0==37) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// C.g:268:16: ',' IDENTIFIER
					{
					char_literal116=(Token)match(input,37,FOLLOW_37_in_identifier_list895); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal116_tree = (Object)adaptor.create(char_literal116);
					adaptor.addChild(root_0, char_literal116_tree);
					}

					IDENTIFIER117=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_identifier_list897); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER117_tree = (Object)adaptor.create(IDENTIFIER117);
					adaptor.addChild(root_0, IDENTIFIER117_tree);
					}

					}
					break;

				default :
					break loop34;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 29, identifier_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "identifier_list"


	public static class type_name_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "type_name"
	// C.g:271:1: type_name : specifier_qualifier_list ( abstract_declarator )? ;
	public final CParser.type_name_return type_name() throws RecognitionException {
		CParser.type_name_return retval = new CParser.type_name_return();
		retval.start = input.LT(1);
		int type_name_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope specifier_qualifier_list118 =null;
		ParserRuleReturnScope abstract_declarator119 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }

			// C.g:272:2: ( specifier_qualifier_list ( abstract_declarator )? )
			// C.g:272:4: specifier_qualifier_list ( abstract_declarator )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_specifier_qualifier_list_in_type_name910);
			specifier_qualifier_list118=specifier_qualifier_list();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, specifier_qualifier_list118.getTree());

			// C.g:272:29: ( abstract_declarator )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==30||LA35_0==32||LA35_0==59) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// C.g:272:29: abstract_declarator
					{
					pushFollow(FOLLOW_abstract_declarator_in_type_name912);
					abstract_declarator119=abstract_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, abstract_declarator119.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 30, type_name_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "type_name"


	public static class abstract_declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "abstract_declarator"
	// C.g:275:1: abstract_declarator : ( pointer ( direct_abstract_declarator )? | direct_abstract_declarator );
	public final CParser.abstract_declarator_return abstract_declarator() throws RecognitionException {
		CParser.abstract_declarator_return retval = new CParser.abstract_declarator_return();
		retval.start = input.LT(1);
		int abstract_declarator_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope pointer120 =null;
		ParserRuleReturnScope direct_abstract_declarator121 =null;
		ParserRuleReturnScope direct_abstract_declarator122 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }

			// C.g:276:2: ( pointer ( direct_abstract_declarator )? | direct_abstract_declarator )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==32) ) {
				alt37=1;
			}
			else if ( (LA37_0==30||LA37_0==59) ) {
				alt37=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// C.g:276:4: pointer ( direct_abstract_declarator )?
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_pointer_in_abstract_declarator924);
					pointer120=pointer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pointer120.getTree());

					// C.g:276:12: ( direct_abstract_declarator )?
					int alt36=2;
					int LA36_0 = input.LA(1);
					if ( (LA36_0==30) ) {
						switch ( input.LA(2) ) {
							case 31:
								{
								int LA36_8 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 32:
								{
								int LA36_9 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 30:
								{
								int LA36_10 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 59:
								{
								int LA36_11 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 63:
							case 74:
							case 81:
							case 86:
								{
								int LA36_12 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 92:
								{
								int LA36_13 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 66:
								{
								int LA36_14 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 83:
								{
								int LA36_15 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 79:
								{
								int LA36_16 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 80:
								{
								int LA36_17 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 75:
								{
								int LA36_18 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 71:
								{
								int LA36_19 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 84:
								{
								int LA36_20 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 91:
								{
								int LA36_21 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 87:
							case 90:
								{
								int LA36_22 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 73:
								{
								int LA36_23 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case IDENTIFIER:
								{
								int LA36_24 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 67:
							case 93:
								{
								int LA36_25 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
						}
					}
					else if ( (LA36_0==59) ) {
						switch ( input.LA(2) ) {
							case 60:
								{
								int LA36_26 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 30:
								{
								int LA36_27 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case IDENTIFIER:
								{
								int LA36_28 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case CHARACTER_LITERAL:
							case DECIMAL_LITERAL:
							case FLOATING_POINT_LITERAL:
							case HEX_LITERAL:
							case OCTAL_LITERAL:
							case STRING_LITERAL:
								{
								int LA36_29 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 35:
								{
								int LA36_30 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 39:
								{
								int LA36_31 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 23:
							case 28:
							case 32:
							case 34:
							case 38:
							case 100:
								{
								int LA36_32 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
							case 85:
								{
								int LA36_33 = input.LA(3);
								if ( (synpred62_C()) ) {
									alt36=1;
								}
								}
								break;
						}
					}
					switch (alt36) {
						case 1 :
							// C.g:276:12: direct_abstract_declarator
							{
							pushFollow(FOLLOW_direct_abstract_declarator_in_abstract_declarator926);
							direct_abstract_declarator121=direct_abstract_declarator();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, direct_abstract_declarator121.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// C.g:277:4: direct_abstract_declarator
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_direct_abstract_declarator_in_abstract_declarator932);
					direct_abstract_declarator122=direct_abstract_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, direct_abstract_declarator122.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 31, abstract_declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "abstract_declarator"


	public static class direct_abstract_declarator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "direct_abstract_declarator"
	// C.g:280:1: direct_abstract_declarator : ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )* ;
	public final CParser.direct_abstract_declarator_return direct_abstract_declarator() throws RecognitionException {
		CParser.direct_abstract_declarator_return retval = new CParser.direct_abstract_declarator_return();
		retval.start = input.LT(1);
		int direct_abstract_declarator_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal123=null;
		Token char_literal125=null;
		ParserRuleReturnScope abstract_declarator124 =null;
		ParserRuleReturnScope abstract_declarator_suffix126 =null;
		ParserRuleReturnScope abstract_declarator_suffix127 =null;

		Object char_literal123_tree=null;
		Object char_literal125_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }

			// C.g:281:2: ( ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )* )
			// C.g:281:4: ( '(' abstract_declarator ')' | abstract_declarator_suffix ) ( abstract_declarator_suffix )*
			{
			root_0 = (Object)adaptor.nil();


			// C.g:281:4: ( '(' abstract_declarator ')' | abstract_declarator_suffix )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==30) ) {
				int LA38_1 = input.LA(2);
				if ( (LA38_1==IDENTIFIER||LA38_1==31||LA38_1==63||(LA38_1 >= 66 && LA38_1 <= 67)||LA38_1==71||(LA38_1 >= 73 && LA38_1 <= 75)||(LA38_1 >= 79 && LA38_1 <= 81)||(LA38_1 >= 83 && LA38_1 <= 84)||(LA38_1 >= 86 && LA38_1 <= 87)||(LA38_1 >= 90 && LA38_1 <= 93)) ) {
					alt38=2;
				}
				else if ( (LA38_1==30||LA38_1==32||LA38_1==59) ) {
					alt38=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA38_0==59) ) {
				alt38=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// C.g:281:6: '(' abstract_declarator ')'
					{
					char_literal123=(Token)match(input,30,FOLLOW_30_in_direct_abstract_declarator945); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal123_tree = (Object)adaptor.create(char_literal123);
					adaptor.addChild(root_0, char_literal123_tree);
					}

					pushFollow(FOLLOW_abstract_declarator_in_direct_abstract_declarator947);
					abstract_declarator124=abstract_declarator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, abstract_declarator124.getTree());

					char_literal125=(Token)match(input,31,FOLLOW_31_in_direct_abstract_declarator949); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal125_tree = (Object)adaptor.create(char_literal125);
					adaptor.addChild(root_0, char_literal125_tree);
					}

					}
					break;
				case 2 :
					// C.g:281:36: abstract_declarator_suffix
					{
					pushFollow(FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator953);
					abstract_declarator_suffix126=abstract_declarator_suffix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, abstract_declarator_suffix126.getTree());

					}
					break;

			}

			// C.g:281:65: ( abstract_declarator_suffix )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( (LA39_0==30) ) {
					switch ( input.LA(2) ) {
					case 31:
						{
						int LA39_8 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case IDENTIFIER:
						{
						int LA39_10 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 63:
					case 74:
					case 81:
					case 86:
						{
						int LA39_13 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 92:
						{
						int LA39_14 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 66:
						{
						int LA39_15 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 83:
						{
						int LA39_16 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 79:
						{
						int LA39_17 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 80:
						{
						int LA39_18 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 75:
						{
						int LA39_19 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 71:
						{
						int LA39_20 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 84:
						{
						int LA39_21 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 91:
						{
						int LA39_22 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 87:
					case 90:
						{
						int LA39_23 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 73:
						{
						int LA39_24 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 67:
					case 93:
						{
						int LA39_25 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					}
				}
				else if ( (LA39_0==59) ) {
					switch ( input.LA(2) ) {
					case 60:
						{
						int LA39_26 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 30:
						{
						int LA39_27 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case IDENTIFIER:
						{
						int LA39_28 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case CHARACTER_LITERAL:
					case DECIMAL_LITERAL:
					case FLOATING_POINT_LITERAL:
					case HEX_LITERAL:
					case OCTAL_LITERAL:
					case STRING_LITERAL:
						{
						int LA39_29 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 35:
						{
						int LA39_30 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 39:
						{
						int LA39_31 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 23:
					case 28:
					case 32:
					case 34:
					case 38:
					case 100:
						{
						int LA39_32 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					case 85:
						{
						int LA39_33 = input.LA(3);
						if ( (synpred65_C()) ) {
							alt39=1;
						}

						}
						break;
					}
				}

				switch (alt39) {
				case 1 :
					// C.g:281:65: abstract_declarator_suffix
					{
					pushFollow(FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator957);
					abstract_declarator_suffix127=abstract_declarator_suffix();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, abstract_declarator_suffix127.getTree());

					}
					break;

				default :
					break loop39;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 32, direct_abstract_declarator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "direct_abstract_declarator"


	public static class abstract_declarator_suffix_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "abstract_declarator_suffix"
	// C.g:284:1: abstract_declarator_suffix : ( '[' ']' | '[' constant_expression ']' | '(' ')' | '(' parameter_type_list ')' );
	public final CParser.abstract_declarator_suffix_return abstract_declarator_suffix() throws RecognitionException {
		CParser.abstract_declarator_suffix_return retval = new CParser.abstract_declarator_suffix_return();
		retval.start = input.LT(1);
		int abstract_declarator_suffix_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal128=null;
		Token char_literal129=null;
		Token char_literal130=null;
		Token char_literal132=null;
		Token char_literal133=null;
		Token char_literal134=null;
		Token char_literal135=null;
		Token char_literal137=null;
		ParserRuleReturnScope constant_expression131 =null;
		ParserRuleReturnScope parameter_type_list136 =null;

		Object char_literal128_tree=null;
		Object char_literal129_tree=null;
		Object char_literal130_tree=null;
		Object char_literal132_tree=null;
		Object char_literal133_tree=null;
		Object char_literal134_tree=null;
		Object char_literal135_tree=null;
		Object char_literal137_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }

			// C.g:285:2: ( '[' ']' | '[' constant_expression ']' | '(' ')' | '(' parameter_type_list ')' )
			int alt40=4;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==59) ) {
				int LA40_1 = input.LA(2);
				if ( (LA40_1==60) ) {
					alt40=1;
				}
				else if ( (LA40_1==CHARACTER_LITERAL||LA40_1==DECIMAL_LITERAL||LA40_1==FLOATING_POINT_LITERAL||LA40_1==HEX_LITERAL||LA40_1==IDENTIFIER||LA40_1==OCTAL_LITERAL||LA40_1==STRING_LITERAL||LA40_1==23||LA40_1==28||LA40_1==30||LA40_1==32||(LA40_1 >= 34 && LA40_1 <= 35)||(LA40_1 >= 38 && LA40_1 <= 39)||LA40_1==85||LA40_1==100) ) {
					alt40=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA40_0==30) ) {
				int LA40_2 = input.LA(2);
				if ( (LA40_2==31) ) {
					alt40=3;
				}
				else if ( (LA40_2==IDENTIFIER||LA40_2==63||(LA40_2 >= 66 && LA40_2 <= 67)||LA40_2==71||(LA40_2 >= 73 && LA40_2 <= 75)||(LA40_2 >= 79 && LA40_2 <= 81)||(LA40_2 >= 83 && LA40_2 <= 84)||(LA40_2 >= 86 && LA40_2 <= 87)||(LA40_2 >= 90 && LA40_2 <= 93)) ) {
					alt40=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// C.g:285:4: '[' ']'
					{
					root_0 = (Object)adaptor.nil();


					char_literal128=(Token)match(input,59,FOLLOW_59_in_abstract_declarator_suffix969); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal128_tree = (Object)adaptor.create(char_literal128);
					adaptor.addChild(root_0, char_literal128_tree);
					}

					char_literal129=(Token)match(input,60,FOLLOW_60_in_abstract_declarator_suffix971); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal129_tree = (Object)adaptor.create(char_literal129);
					adaptor.addChild(root_0, char_literal129_tree);
					}

					}
					break;
				case 2 :
					// C.g:286:4: '[' constant_expression ']'
					{
					root_0 = (Object)adaptor.nil();


					char_literal130=(Token)match(input,59,FOLLOW_59_in_abstract_declarator_suffix976); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal130_tree = (Object)adaptor.create(char_literal130);
					adaptor.addChild(root_0, char_literal130_tree);
					}

					pushFollow(FOLLOW_constant_expression_in_abstract_declarator_suffix978);
					constant_expression131=constant_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression131.getTree());

					char_literal132=(Token)match(input,60,FOLLOW_60_in_abstract_declarator_suffix980); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal132_tree = (Object)adaptor.create(char_literal132);
					adaptor.addChild(root_0, char_literal132_tree);
					}

					}
					break;
				case 3 :
					// C.g:287:4: '(' ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal133=(Token)match(input,30,FOLLOW_30_in_abstract_declarator_suffix985); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal133_tree = (Object)adaptor.create(char_literal133);
					adaptor.addChild(root_0, char_literal133_tree);
					}

					char_literal134=(Token)match(input,31,FOLLOW_31_in_abstract_declarator_suffix987); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal134_tree = (Object)adaptor.create(char_literal134);
					adaptor.addChild(root_0, char_literal134_tree);
					}

					}
					break;
				case 4 :
					// C.g:288:4: '(' parameter_type_list ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal135=(Token)match(input,30,FOLLOW_30_in_abstract_declarator_suffix992); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal135_tree = (Object)adaptor.create(char_literal135);
					adaptor.addChild(root_0, char_literal135_tree);
					}

					pushFollow(FOLLOW_parameter_type_list_in_abstract_declarator_suffix994);
					parameter_type_list136=parameter_type_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, parameter_type_list136.getTree());

					char_literal137=(Token)match(input,31,FOLLOW_31_in_abstract_declarator_suffix996); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal137_tree = (Object)adaptor.create(char_literal137);
					adaptor.addChild(root_0, char_literal137_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 33, abstract_declarator_suffix_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "abstract_declarator_suffix"


	public static class initializer_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "initializer"
	// C.g:291:1: initializer : ( assignment_expression | '{' initializer_list ( ',' )? '}' );
	public final CParser.initializer_return initializer() throws RecognitionException {
		CParser.initializer_return retval = new CParser.initializer_return();
		retval.start = input.LT(1);
		int initializer_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal139=null;
		Token char_literal141=null;
		Token char_literal142=null;
		ParserRuleReturnScope assignment_expression138 =null;
		ParserRuleReturnScope initializer_list140 =null;

		Object char_literal139_tree=null;
		Object char_literal141_tree=null;
		Object char_literal142_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }

			// C.g:292:2: ( assignment_expression | '{' initializer_list ( ',' )? '}' )
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==CHARACTER_LITERAL||LA42_0==DECIMAL_LITERAL||LA42_0==FLOATING_POINT_LITERAL||LA42_0==HEX_LITERAL||LA42_0==IDENTIFIER||LA42_0==OCTAL_LITERAL||LA42_0==STRING_LITERAL||LA42_0==23||LA42_0==28||LA42_0==30||LA42_0==32||(LA42_0 >= 34 && LA42_0 <= 35)||(LA42_0 >= 38 && LA42_0 <= 39)||LA42_0==85||LA42_0==100) ) {
				alt42=1;
			}
			else if ( (LA42_0==95) ) {
				alt42=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 42, 0, input);
				throw nvae;
			}

			switch (alt42) {
				case 1 :
					// C.g:292:4: assignment_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_assignment_expression_in_initializer1008);
					assignment_expression138=assignment_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression138.getTree());

					}
					break;
				case 2 :
					// C.g:293:4: '{' initializer_list ( ',' )? '}'
					{
					root_0 = (Object)adaptor.nil();


					char_literal139=(Token)match(input,95,FOLLOW_95_in_initializer1013); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal139_tree = (Object)adaptor.create(char_literal139);
					adaptor.addChild(root_0, char_literal139_tree);
					}

					pushFollow(FOLLOW_initializer_list_in_initializer1015);
					initializer_list140=initializer_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, initializer_list140.getTree());

					// C.g:293:25: ( ',' )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==37) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// C.g:293:25: ','
							{
							char_literal141=(Token)match(input,37,FOLLOW_37_in_initializer1017); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal141_tree = (Object)adaptor.create(char_literal141);
							adaptor.addChild(root_0, char_literal141_tree);
							}

							}
							break;

					}

					char_literal142=(Token)match(input,99,FOLLOW_99_in_initializer1020); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal142_tree = (Object)adaptor.create(char_literal142);
					adaptor.addChild(root_0, char_literal142_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 34, initializer_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "initializer"


	public static class initializer_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "initializer_list"
	// C.g:296:1: initializer_list : initializer ( ',' initializer )* ;
	public final CParser.initializer_list_return initializer_list() throws RecognitionException {
		CParser.initializer_list_return retval = new CParser.initializer_list_return();
		retval.start = input.LT(1);
		int initializer_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal144=null;
		ParserRuleReturnScope initializer143 =null;
		ParserRuleReturnScope initializer145 =null;

		Object char_literal144_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }

			// C.g:297:2: ( initializer ( ',' initializer )* )
			// C.g:297:4: initializer ( ',' initializer )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_initializer_in_initializer_list1031);
			initializer143=initializer();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, initializer143.getTree());

			// C.g:297:16: ( ',' initializer )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==37) ) {
					int LA43_1 = input.LA(2);
					if ( (LA43_1==CHARACTER_LITERAL||LA43_1==DECIMAL_LITERAL||LA43_1==FLOATING_POINT_LITERAL||LA43_1==HEX_LITERAL||LA43_1==IDENTIFIER||LA43_1==OCTAL_LITERAL||LA43_1==STRING_LITERAL||LA43_1==23||LA43_1==28||LA43_1==30||LA43_1==32||(LA43_1 >= 34 && LA43_1 <= 35)||(LA43_1 >= 38 && LA43_1 <= 39)||LA43_1==85||LA43_1==95||LA43_1==100) ) {
						alt43=1;
					}

				}

				switch (alt43) {
				case 1 :
					// C.g:297:17: ',' initializer
					{
					char_literal144=(Token)match(input,37,FOLLOW_37_in_initializer_list1034); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal144_tree = (Object)adaptor.create(char_literal144);
					adaptor.addChild(root_0, char_literal144_tree);
					}

					pushFollow(FOLLOW_initializer_in_initializer_list1036);
					initializer145=initializer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, initializer145.getTree());

					}
					break;

				default :
					break loop43;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 35, initializer_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "initializer_list"


	public static class argument_expression_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "argument_expression_list"
	// C.g:302:1: argument_expression_list : assignment_expression ( ',' assignment_expression )* ;
	public final CParser.argument_expression_list_return argument_expression_list() throws RecognitionException {
		CParser.argument_expression_list_return retval = new CParser.argument_expression_list_return();
		retval.start = input.LT(1);
		int argument_expression_list_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal147=null;
		ParserRuleReturnScope assignment_expression146 =null;
		ParserRuleReturnScope assignment_expression148 =null;

		Object char_literal147_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }

			// C.g:303:2: ( assignment_expression ( ',' assignment_expression )* )
			// C.g:303:6: assignment_expression ( ',' assignment_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1053);
			assignment_expression146=assignment_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression146.getTree());

			// C.g:303:28: ( ',' assignment_expression )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==37) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// C.g:303:29: ',' assignment_expression
					{
					char_literal147=(Token)match(input,37,FOLLOW_37_in_argument_expression_list1056); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal147_tree = (Object)adaptor.create(char_literal147);
					adaptor.addChild(root_0, char_literal147_tree);
					}

					pushFollow(FOLLOW_assignment_expression_in_argument_expression_list1058);
					assignment_expression148=assignment_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression148.getTree());

					}
					break;

				default :
					break loop44;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 36, argument_expression_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "argument_expression_list"


	public static class additive_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "additive_expression"
	// C.g:306:1: additive_expression : ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )* ;
	public final CParser.additive_expression_return additive_expression() throws RecognitionException {
		CParser.additive_expression_return retval = new CParser.additive_expression_return();
		retval.start = input.LT(1);
		int additive_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal150=null;
		Token char_literal152=null;
		ParserRuleReturnScope multiplicative_expression149 =null;
		ParserRuleReturnScope multiplicative_expression151 =null;
		ParserRuleReturnScope multiplicative_expression153 =null;

		Object char_literal150_tree=null;
		Object char_literal152_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }

			// C.g:307:2: ( ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )* )
			// C.g:307:4: ( multiplicative_expression ) ( '+' multiplicative_expression | '-' multiplicative_expression )*
			{
			root_0 = (Object)adaptor.nil();


			// C.g:307:4: ( multiplicative_expression )
			// C.g:307:5: multiplicative_expression
			{
			pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1072);
			multiplicative_expression149=multiplicative_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicative_expression149.getTree());

			}

			// C.g:307:32: ( '+' multiplicative_expression | '-' multiplicative_expression )*
			loop45:
			while (true) {
				int alt45=3;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==34) ) {
					alt45=1;
				}
				else if ( (LA45_0==38) ) {
					alt45=2;
				}

				switch (alt45) {
				case 1 :
					// C.g:307:33: '+' multiplicative_expression
					{
					char_literal150=(Token)match(input,34,FOLLOW_34_in_additive_expression1076); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal150_tree = (Object)adaptor.create(char_literal150);
					adaptor.addChild(root_0, char_literal150_tree);
					}

					pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1078);
					multiplicative_expression151=multiplicative_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicative_expression151.getTree());

					}
					break;
				case 2 :
					// C.g:307:65: '-' multiplicative_expression
					{
					char_literal152=(Token)match(input,38,FOLLOW_38_in_additive_expression1082); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal152_tree = (Object)adaptor.create(char_literal152);
					adaptor.addChild(root_0, char_literal152_tree);
					}

					pushFollow(FOLLOW_multiplicative_expression_in_additive_expression1084);
					multiplicative_expression153=multiplicative_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicative_expression153.getTree());

					}
					break;

				default :
					break loop45;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 37, additive_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "additive_expression"


	public static class multiplicative_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "multiplicative_expression"
	// C.g:310:1: multiplicative_expression : ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )* ;
	public final CParser.multiplicative_expression_return multiplicative_expression() throws RecognitionException {
		CParser.multiplicative_expression_return retval = new CParser.multiplicative_expression_return();
		retval.start = input.LT(1);
		int multiplicative_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal155=null;
		Token char_literal157=null;
		Token char_literal159=null;
		ParserRuleReturnScope cast_expression154 =null;
		ParserRuleReturnScope cast_expression156 =null;
		ParserRuleReturnScope cast_expression158 =null;
		ParserRuleReturnScope cast_expression160 =null;

		Object char_literal155_tree=null;
		Object char_literal157_tree=null;
		Object char_literal159_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }

			// C.g:311:2: ( ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )* )
			// C.g:311:4: ( cast_expression ) ( '*' cast_expression | '/' cast_expression | '%' cast_expression )*
			{
			root_0 = (Object)adaptor.nil();


			// C.g:311:4: ( cast_expression )
			// C.g:311:5: cast_expression
			{
			pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1098);
			cast_expression154=cast_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression154.getTree());

			}

			// C.g:311:22: ( '*' cast_expression | '/' cast_expression | '%' cast_expression )*
			loop46:
			while (true) {
				int alt46=4;
				switch ( input.LA(1) ) {
				case 32:
					{
					alt46=1;
					}
					break;
				case 44:
					{
					alt46=2;
					}
					break;
				case 25:
					{
					alt46=3;
					}
					break;
				}
				switch (alt46) {
				case 1 :
					// C.g:311:23: '*' cast_expression
					{
					char_literal155=(Token)match(input,32,FOLLOW_32_in_multiplicative_expression1102); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal155_tree = (Object)adaptor.create(char_literal155);
					adaptor.addChild(root_0, char_literal155_tree);
					}

					pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1104);
					cast_expression156=cast_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression156.getTree());

					}
					break;
				case 2 :
					// C.g:311:45: '/' cast_expression
					{
					char_literal157=(Token)match(input,44,FOLLOW_44_in_multiplicative_expression1108); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal157_tree = (Object)adaptor.create(char_literal157);
					adaptor.addChild(root_0, char_literal157_tree);
					}

					pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1110);
					cast_expression158=cast_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression158.getTree());

					}
					break;
				case 3 :
					// C.g:311:67: '%' cast_expression
					{
					char_literal159=(Token)match(input,25,FOLLOW_25_in_multiplicative_expression1114); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal159_tree = (Object)adaptor.create(char_literal159);
					adaptor.addChild(root_0, char_literal159_tree);
					}

					pushFollow(FOLLOW_cast_expression_in_multiplicative_expression1116);
					cast_expression160=cast_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression160.getTree());

					}
					break;

				default :
					break loop46;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 38, multiplicative_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "multiplicative_expression"


	public static class cast_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "cast_expression"
	// C.g:314:1: cast_expression : ( '(' type_name ')' cast_expression | unary_expression );
	public final CParser.cast_expression_return cast_expression() throws RecognitionException {
		CParser.cast_expression_return retval = new CParser.cast_expression_return();
		retval.start = input.LT(1);
		int cast_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal161=null;
		Token char_literal163=null;
		ParserRuleReturnScope type_name162 =null;
		ParserRuleReturnScope cast_expression164 =null;
		ParserRuleReturnScope unary_expression165 =null;

		Object char_literal161_tree=null;
		Object char_literal163_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }

			// C.g:315:2: ( '(' type_name ')' cast_expression | unary_expression )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==30) ) {
				switch ( input.LA(2) ) {
				case 66:
				case 67:
				case 71:
				case 73:
				case 75:
				case 79:
				case 80:
				case 83:
				case 84:
				case 87:
				case 90:
				case 91:
				case 92:
				case 93:
					{
					alt47=1;
					}
					break;
				case IDENTIFIER:
					{
					int LA47_20 = input.LA(3);
					if ( (synpred78_C()) ) {
						alt47=1;
					}
					else if ( (true) ) {
						alt47=2;
					}

					}
					break;
				case CHARACTER_LITERAL:
				case DECIMAL_LITERAL:
				case FLOATING_POINT_LITERAL:
				case HEX_LITERAL:
				case OCTAL_LITERAL:
				case STRING_LITERAL:
				case 23:
				case 28:
				case 30:
				case 32:
				case 34:
				case 35:
				case 38:
				case 39:
				case 85:
				case 100:
					{
					alt47=2;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 47, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}
			else if ( (LA47_0==CHARACTER_LITERAL||LA47_0==DECIMAL_LITERAL||LA47_0==FLOATING_POINT_LITERAL||LA47_0==HEX_LITERAL||LA47_0==IDENTIFIER||LA47_0==OCTAL_LITERAL||LA47_0==STRING_LITERAL||LA47_0==23||LA47_0==28||LA47_0==32||(LA47_0 >= 34 && LA47_0 <= 35)||(LA47_0 >= 38 && LA47_0 <= 39)||LA47_0==85||LA47_0==100) ) {
				alt47=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// C.g:315:4: '(' type_name ')' cast_expression
					{
					root_0 = (Object)adaptor.nil();


					char_literal161=(Token)match(input,30,FOLLOW_30_in_cast_expression1129); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal161_tree = (Object)adaptor.create(char_literal161);
					adaptor.addChild(root_0, char_literal161_tree);
					}

					pushFollow(FOLLOW_type_name_in_cast_expression1131);
					type_name162=type_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_name162.getTree());

					char_literal163=(Token)match(input,31,FOLLOW_31_in_cast_expression1133); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal163_tree = (Object)adaptor.create(char_literal163);
					adaptor.addChild(root_0, char_literal163_tree);
					}

					pushFollow(FOLLOW_cast_expression_in_cast_expression1135);
					cast_expression164=cast_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression164.getTree());

					}
					break;
				case 2 :
					// C.g:316:4: unary_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_unary_expression_in_cast_expression1140);
					unary_expression165=unary_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression165.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 39, cast_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "cast_expression"


	public static class unary_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unary_expression"
	// C.g:319:1: unary_expression : ( postfix_expression | '++' unary_expression | '--' unary_expression | unary_operator cast_expression | 'sizeof' unary_expression | 'sizeof' '(' type_name ')' );
	public final CParser.unary_expression_return unary_expression() throws RecognitionException {
		CParser.unary_expression_return retval = new CParser.unary_expression_return();
		retval.start = input.LT(1);
		int unary_expression_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal167=null;
		Token string_literal169=null;
		Token string_literal173=null;
		Token string_literal175=null;
		Token char_literal176=null;
		Token char_literal178=null;
		ParserRuleReturnScope postfix_expression166 =null;
		ParserRuleReturnScope unary_expression168 =null;
		ParserRuleReturnScope unary_expression170 =null;
		ParserRuleReturnScope unary_operator171 =null;
		ParserRuleReturnScope cast_expression172 =null;
		ParserRuleReturnScope unary_expression174 =null;
		ParserRuleReturnScope type_name177 =null;

		Object string_literal167_tree=null;
		Object string_literal169_tree=null;
		Object string_literal173_tree=null;
		Object string_literal175_tree=null;
		Object char_literal176_tree=null;
		Object char_literal178_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }

			// C.g:320:2: ( postfix_expression | '++' unary_expression | '--' unary_expression | unary_operator cast_expression | 'sizeof' unary_expression | 'sizeof' '(' type_name ')' )
			int alt48=6;
			switch ( input.LA(1) ) {
			case CHARACTER_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case HEX_LITERAL:
			case IDENTIFIER:
			case OCTAL_LITERAL:
			case STRING_LITERAL:
			case 30:
				{
				alt48=1;
				}
				break;
			case 35:
				{
				alt48=2;
				}
				break;
			case 39:
				{
				alt48=3;
				}
				break;
			case 23:
			case 28:
			case 32:
			case 34:
			case 38:
			case 100:
				{
				alt48=4;
				}
				break;
			case 85:
				{
				int LA48_7 = input.LA(2);
				if ( (LA48_7==30) ) {
					int LA48_8 = input.LA(3);
					if ( (synpred83_C()) ) {
						alt48=5;
					}
					else if ( (true) ) {
						alt48=6;
					}

				}
				else if ( (LA48_7==CHARACTER_LITERAL||LA48_7==DECIMAL_LITERAL||LA48_7==FLOATING_POINT_LITERAL||LA48_7==HEX_LITERAL||LA48_7==IDENTIFIER||LA48_7==OCTAL_LITERAL||LA48_7==STRING_LITERAL||LA48_7==23||LA48_7==28||LA48_7==32||(LA48_7 >= 34 && LA48_7 <= 35)||(LA48_7 >= 38 && LA48_7 <= 39)||LA48_7==85||LA48_7==100) ) {
					alt48=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 48, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// C.g:320:4: postfix_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_postfix_expression_in_unary_expression1151);
					postfix_expression166=postfix_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, postfix_expression166.getTree());

					}
					break;
				case 2 :
					// C.g:321:4: '++' unary_expression
					{
					root_0 = (Object)adaptor.nil();


					string_literal167=(Token)match(input,35,FOLLOW_35_in_unary_expression1156); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal167_tree = (Object)adaptor.create(string_literal167);
					adaptor.addChild(root_0, string_literal167_tree);
					}

					pushFollow(FOLLOW_unary_expression_in_unary_expression1158);
					unary_expression168=unary_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression168.getTree());

					}
					break;
				case 3 :
					// C.g:322:4: '--' unary_expression
					{
					root_0 = (Object)adaptor.nil();


					string_literal169=(Token)match(input,39,FOLLOW_39_in_unary_expression1163); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal169_tree = (Object)adaptor.create(string_literal169);
					adaptor.addChild(root_0, string_literal169_tree);
					}

					pushFollow(FOLLOW_unary_expression_in_unary_expression1165);
					unary_expression170=unary_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression170.getTree());

					}
					break;
				case 4 :
					// C.g:323:4: unary_operator cast_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_unary_operator_in_unary_expression1170);
					unary_operator171=unary_operator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_operator171.getTree());

					pushFollow(FOLLOW_cast_expression_in_unary_expression1172);
					cast_expression172=cast_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cast_expression172.getTree());

					}
					break;
				case 5 :
					// C.g:324:4: 'sizeof' unary_expression
					{
					root_0 = (Object)adaptor.nil();


					string_literal173=(Token)match(input,85,FOLLOW_85_in_unary_expression1177); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal173_tree = (Object)adaptor.create(string_literal173);
					adaptor.addChild(root_0, string_literal173_tree);
					}

					pushFollow(FOLLOW_unary_expression_in_unary_expression1179);
					unary_expression174=unary_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression174.getTree());

					}
					break;
				case 6 :
					// C.g:325:4: 'sizeof' '(' type_name ')'
					{
					root_0 = (Object)adaptor.nil();


					string_literal175=(Token)match(input,85,FOLLOW_85_in_unary_expression1184); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal175_tree = (Object)adaptor.create(string_literal175);
					adaptor.addChild(root_0, string_literal175_tree);
					}

					char_literal176=(Token)match(input,30,FOLLOW_30_in_unary_expression1186); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal176_tree = (Object)adaptor.create(char_literal176);
					adaptor.addChild(root_0, char_literal176_tree);
					}

					pushFollow(FOLLOW_type_name_in_unary_expression1188);
					type_name177=type_name();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, type_name177.getTree());

					char_literal178=(Token)match(input,31,FOLLOW_31_in_unary_expression1190); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal178_tree = (Object)adaptor.create(char_literal178);
					adaptor.addChild(root_0, char_literal178_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 40, unary_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "unary_expression"


	public static class postfix_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "postfix_expression"
	// C.g:328:1: postfix_expression : primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )* ;
	public final CParser.postfix_expression_return postfix_expression() throws RecognitionException {
		CParser.postfix_expression_return retval = new CParser.postfix_expression_return();
		retval.start = input.LT(1);
		int postfix_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal180=null;
		Token char_literal182=null;
		Token char_literal183=null;
		Token char_literal184=null;
		Token char_literal185=null;
		Token char_literal187=null;
		Token char_literal188=null;
		Token IDENTIFIER189=null;
		Token string_literal190=null;
		Token IDENTIFIER191=null;
		Token string_literal192=null;
		Token string_literal193=null;
		ParserRuleReturnScope primary_expression179 =null;
		ParserRuleReturnScope expression181 =null;
		ParserRuleReturnScope argument_expression_list186 =null;

		Object char_literal180_tree=null;
		Object char_literal182_tree=null;
		Object char_literal183_tree=null;
		Object char_literal184_tree=null;
		Object char_literal185_tree=null;
		Object char_literal187_tree=null;
		Object char_literal188_tree=null;
		Object IDENTIFIER189_tree=null;
		Object string_literal190_tree=null;
		Object IDENTIFIER191_tree=null;
		Object string_literal192_tree=null;
		Object string_literal193_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }

			// C.g:329:2: ( primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )* )
			// C.g:329:6: primary_expression ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_primary_expression_in_postfix_expression1203);
			primary_expression179=primary_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, primary_expression179.getTree());

			// C.g:330:9: ( '[' expression ']' | '(' ')' | '(' argument_expression_list ')' | '.' IDENTIFIER | '->' IDENTIFIER | '++' | '--' )*
			loop49:
			while (true) {
				int alt49=8;
				switch ( input.LA(1) ) {
				case 59:
					{
					alt49=1;
					}
					break;
				case 30:
					{
					int LA49_24 = input.LA(2);
					if ( (LA49_24==31) ) {
						alt49=2;
					}
					else if ( (LA49_24==CHARACTER_LITERAL||LA49_24==DECIMAL_LITERAL||LA49_24==FLOATING_POINT_LITERAL||LA49_24==HEX_LITERAL||LA49_24==IDENTIFIER||LA49_24==OCTAL_LITERAL||LA49_24==STRING_LITERAL||LA49_24==23||LA49_24==28||LA49_24==30||LA49_24==32||(LA49_24 >= 34 && LA49_24 <= 35)||(LA49_24 >= 38 && LA49_24 <= 39)||LA49_24==85||LA49_24==100) ) {
						alt49=3;
					}

					}
					break;
				case 42:
					{
					alt49=4;
					}
					break;
				case 41:
					{
					alt49=5;
					}
					break;
				case 35:
					{
					alt49=6;
					}
					break;
				case 39:
					{
					alt49=7;
					}
					break;
				}
				switch (alt49) {
				case 1 :
					// C.g:330:13: '[' expression ']'
					{
					char_literal180=(Token)match(input,59,FOLLOW_59_in_postfix_expression1217); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal180_tree = (Object)adaptor.create(char_literal180);
					adaptor.addChild(root_0, char_literal180_tree);
					}

					pushFollow(FOLLOW_expression_in_postfix_expression1219);
					expression181=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression181.getTree());

					char_literal182=(Token)match(input,60,FOLLOW_60_in_postfix_expression1221); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal182_tree = (Object)adaptor.create(char_literal182);
					adaptor.addChild(root_0, char_literal182_tree);
					}

					}
					break;
				case 2 :
					// C.g:331:13: '(' ')'
					{
					char_literal183=(Token)match(input,30,FOLLOW_30_in_postfix_expression1235); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal183_tree = (Object)adaptor.create(char_literal183);
					adaptor.addChild(root_0, char_literal183_tree);
					}

					char_literal184=(Token)match(input,31,FOLLOW_31_in_postfix_expression1237); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal184_tree = (Object)adaptor.create(char_literal184);
					adaptor.addChild(root_0, char_literal184_tree);
					}

					}
					break;
				case 3 :
					// C.g:332:13: '(' argument_expression_list ')'
					{
					char_literal185=(Token)match(input,30,FOLLOW_30_in_postfix_expression1251); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal185_tree = (Object)adaptor.create(char_literal185);
					adaptor.addChild(root_0, char_literal185_tree);
					}

					pushFollow(FOLLOW_argument_expression_list_in_postfix_expression1253);
					argument_expression_list186=argument_expression_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, argument_expression_list186.getTree());

					char_literal187=(Token)match(input,31,FOLLOW_31_in_postfix_expression1255); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal187_tree = (Object)adaptor.create(char_literal187);
					adaptor.addChild(root_0, char_literal187_tree);
					}

					}
					break;
				case 4 :
					// C.g:333:13: '.' IDENTIFIER
					{
					char_literal188=(Token)match(input,42,FOLLOW_42_in_postfix_expression1269); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal188_tree = (Object)adaptor.create(char_literal188);
					adaptor.addChild(root_0, char_literal188_tree);
					}

					IDENTIFIER189=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfix_expression1271); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER189_tree = (Object)adaptor.create(IDENTIFIER189);
					adaptor.addChild(root_0, IDENTIFIER189_tree);
					}

					}
					break;
				case 5 :
					// C.g:334:13: '->' IDENTIFIER
					{
					string_literal190=(Token)match(input,41,FOLLOW_41_in_postfix_expression1285); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal190_tree = (Object)adaptor.create(string_literal190);
					adaptor.addChild(root_0, string_literal190_tree);
					}

					IDENTIFIER191=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfix_expression1287); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER191_tree = (Object)adaptor.create(IDENTIFIER191);
					adaptor.addChild(root_0, IDENTIFIER191_tree);
					}

					}
					break;
				case 6 :
					// C.g:335:13: '++'
					{
					string_literal192=(Token)match(input,35,FOLLOW_35_in_postfix_expression1301); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal192_tree = (Object)adaptor.create(string_literal192);
					adaptor.addChild(root_0, string_literal192_tree);
					}

					}
					break;
				case 7 :
					// C.g:336:13: '--'
					{
					string_literal193=(Token)match(input,39,FOLLOW_39_in_postfix_expression1315); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal193_tree = (Object)adaptor.create(string_literal193);
					adaptor.addChild(root_0, string_literal193_tree);
					}

					}
					break;

				default :
					break loop49;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 41, postfix_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "postfix_expression"


	public static class unary_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "unary_operator"
	// C.g:340:1: unary_operator : ( '&' | '*' | '+' | '-' | '~' | '!' );
	public final CParser.unary_operator_return unary_operator() throws RecognitionException {
		CParser.unary_operator_return retval = new CParser.unary_operator_return();
		retval.start = input.LT(1);
		int unary_operator_StartIndex = input.index();

		Object root_0 = null;

		Token set194=null;

		Object set194_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 42) ) { return retval; }

			// C.g:341:2: ( '&' | '*' | '+' | '-' | '~' | '!' )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set194=input.LT(1);
			if ( input.LA(1)==23||input.LA(1)==28||input.LA(1)==32||input.LA(1)==34||input.LA(1)==38||input.LA(1)==100 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set194));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 42, unary_operator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "unary_operator"


	public static class primary_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "primary_expression"
	// C.g:349:1: primary_expression : ( IDENTIFIER | constant | '(' expression ')' );
	public final CParser.primary_expression_return primary_expression() throws RecognitionException {
		CParser.primary_expression_return retval = new CParser.primary_expression_return();
		retval.start = input.LT(1);
		int primary_expression_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER195=null;
		Token char_literal197=null;
		Token char_literal199=null;
		ParserRuleReturnScope constant196 =null;
		ParserRuleReturnScope expression198 =null;

		Object IDENTIFIER195_tree=null;
		Object char_literal197_tree=null;
		Object char_literal199_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 43) ) { return retval; }

			// C.g:350:2: ( IDENTIFIER | constant | '(' expression ')' )
			int alt50=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt50=1;
				}
				break;
			case CHARACTER_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case STRING_LITERAL:
				{
				alt50=2;
				}
				break;
			case 30:
				{
				alt50=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}
			switch (alt50) {
				case 1 :
					// C.g:350:4: IDENTIFIER
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER195=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primary_expression1373); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER195_tree = (Object)adaptor.create(IDENTIFIER195);
					adaptor.addChild(root_0, IDENTIFIER195_tree);
					}

					}
					break;
				case 2 :
					// C.g:351:4: constant
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_constant_in_primary_expression1378);
					constant196=constant();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant196.getTree());

					}
					break;
				case 3 :
					// C.g:352:4: '(' expression ')'
					{
					root_0 = (Object)adaptor.nil();


					char_literal197=(Token)match(input,30,FOLLOW_30_in_primary_expression1383); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal197_tree = (Object)adaptor.create(char_literal197);
					adaptor.addChild(root_0, char_literal197_tree);
					}

					pushFollow(FOLLOW_expression_in_primary_expression1385);
					expression198=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression198.getTree());

					char_literal199=(Token)match(input,31,FOLLOW_31_in_primary_expression1387); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal199_tree = (Object)adaptor.create(char_literal199);
					adaptor.addChild(root_0, char_literal199_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 43, primary_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "primary_expression"


	public static class constant_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constant"
	// C.g:355:1: constant : ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL );
	public final CParser.constant_return constant() throws RecognitionException {
		CParser.constant_return retval = new CParser.constant_return();
		retval.start = input.LT(1);
		int constant_StartIndex = input.index();

		Object root_0 = null;

		Token set200=null;

		Object set200_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 44) ) { return retval; }

			// C.g:356:5: ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set200=input.LT(1);
			if ( input.LA(1)==CHARACTER_LITERAL||input.LA(1)==DECIMAL_LITERAL||input.LA(1)==FLOATING_POINT_LITERAL||input.LA(1)==HEX_LITERAL||input.LA(1)==OCTAL_LITERAL||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set200));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 44, constant_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constant"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// C.g:366:1: expression : assignment_expression ( ',' assignment_expression )* ;
	public final CParser.expression_return expression() throws RecognitionException {
		CParser.expression_return retval = new CParser.expression_return();
		retval.start = input.LT(1);
		int expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal202=null;
		ParserRuleReturnScope assignment_expression201 =null;
		ParserRuleReturnScope assignment_expression203 =null;

		Object char_literal202_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 45) ) { return retval; }

			// C.g:367:2: ( assignment_expression ( ',' assignment_expression )* )
			// C.g:367:4: assignment_expression ( ',' assignment_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_assignment_expression_in_expression1462);
			assignment_expression201=assignment_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression201.getTree());

			// C.g:367:26: ( ',' assignment_expression )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==37) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// C.g:367:27: ',' assignment_expression
					{
					char_literal202=(Token)match(input,37,FOLLOW_37_in_expression1465); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal202_tree = (Object)adaptor.create(char_literal202);
					adaptor.addChild(root_0, char_literal202_tree);
					}

					pushFollow(FOLLOW_assignment_expression_in_expression1467);
					assignment_expression203=assignment_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression203.getTree());

					}
					break;

				default :
					break loop51;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 45, expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class constant_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "constant_expression"
	// C.g:370:1: constant_expression : conditional_expression ;
	public final CParser.constant_expression_return constant_expression() throws RecognitionException {
		CParser.constant_expression_return retval = new CParser.constant_expression_return();
		retval.start = input.LT(1);
		int constant_expression_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope conditional_expression204 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 46) ) { return retval; }

			// C.g:371:2: ( conditional_expression )
			// C.g:371:4: conditional_expression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_conditional_expression_in_constant_expression1480);
			conditional_expression204=conditional_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional_expression204.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 46, constant_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "constant_expression"


	public static class assignment_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_expression"
	// C.g:374:1: assignment_expression : ( lvalue assignment_operator assignment_expression | conditional_expression );
	public final CParser.assignment_expression_return assignment_expression() throws RecognitionException {
		CParser.assignment_expression_return retval = new CParser.assignment_expression_return();
		retval.start = input.LT(1);
		int assignment_expression_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope lvalue205 =null;
		ParserRuleReturnScope assignment_operator206 =null;
		ParserRuleReturnScope assignment_expression207 =null;
		ParserRuleReturnScope conditional_expression208 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 47) ) { return retval; }

			// C.g:375:2: ( lvalue assignment_operator assignment_expression | conditional_expression )
			int alt52=2;
			alt52 = dfa52.predict(input);
			switch (alt52) {
				case 1 :
					// C.g:375:4: lvalue assignment_operator assignment_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_lvalue_in_assignment_expression1491);
					lvalue205=lvalue();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lvalue205.getTree());

					pushFollow(FOLLOW_assignment_operator_in_assignment_expression1493);
					assignment_operator206=assignment_operator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_operator206.getTree());

					pushFollow(FOLLOW_assignment_expression_in_assignment_expression1495);
					assignment_expression207=assignment_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, assignment_expression207.getTree());

					}
					break;
				case 2 :
					// C.g:376:4: conditional_expression
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_conditional_expression_in_assignment_expression1500);
					conditional_expression208=conditional_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional_expression208.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 47, assignment_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "assignment_expression"


	public static class lvalue_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lvalue"
	// C.g:379:1: lvalue : unary_expression ;
	public final CParser.lvalue_return lvalue() throws RecognitionException {
		CParser.lvalue_return retval = new CParser.lvalue_return();
		retval.start = input.LT(1);
		int lvalue_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope unary_expression209 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 48) ) { return retval; }

			// C.g:380:2: ( unary_expression )
			// C.g:380:4: unary_expression
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_unary_expression_in_lvalue1512);
			unary_expression209=unary_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unary_expression209.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 48, lvalue_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "lvalue"


	public static class assignment_operator_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "assignment_operator"
	// C.g:383:1: assignment_operator : ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' );
	public final CParser.assignment_operator_return assignment_operator() throws RecognitionException {
		CParser.assignment_operator_return retval = new CParser.assignment_operator_return();
		retval.start = input.LT(1);
		int assignment_operator_StartIndex = input.index();

		Object root_0 = null;

		Token set210=null;

		Object set210_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 49) ) { return retval; }

			// C.g:384:2: ( '=' | '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|=' )
			// C.g:
			{
			root_0 = (Object)adaptor.nil();


			set210=input.LT(1);
			if ( input.LA(1)==26||input.LA(1)==29||input.LA(1)==33||input.LA(1)==36||input.LA(1)==40||input.LA(1)==45||input.LA(1)==50||input.LA(1)==52||input.LA(1)==57||input.LA(1)==62||input.LA(1)==97 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set210));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 49, assignment_operator_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "assignment_operator"


	public static class conditional_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "conditional_expression"
	// C.g:397:1: conditional_expression : logical_or_expression ( '?' expression ':' conditional_expression )? ;
	public final CParser.conditional_expression_return conditional_expression() throws RecognitionException {
		CParser.conditional_expression_return retval = new CParser.conditional_expression_return();
		retval.start = input.LT(1);
		int conditional_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal212=null;
		Token char_literal214=null;
		ParserRuleReturnScope logical_or_expression211 =null;
		ParserRuleReturnScope expression213 =null;
		ParserRuleReturnScope conditional_expression215 =null;

		Object char_literal212_tree=null;
		Object char_literal214_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 50) ) { return retval; }

			// C.g:398:2: ( logical_or_expression ( '?' expression ':' conditional_expression )? )
			// C.g:398:4: logical_or_expression ( '?' expression ':' conditional_expression )?
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_logical_or_expression_in_conditional_expression1584);
			logical_or_expression211=logical_or_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_or_expression211.getTree());

			// C.g:398:26: ( '?' expression ':' conditional_expression )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==58) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// C.g:398:27: '?' expression ':' conditional_expression
					{
					char_literal212=(Token)match(input,58,FOLLOW_58_in_conditional_expression1587); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal212_tree = (Object)adaptor.create(char_literal212);
					adaptor.addChild(root_0, char_literal212_tree);
					}

					pushFollow(FOLLOW_expression_in_conditional_expression1589);
					expression213=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression213.getTree());

					char_literal214=(Token)match(input,46,FOLLOW_46_in_conditional_expression1591); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (Object)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}

					pushFollow(FOLLOW_conditional_expression_in_conditional_expression1593);
					conditional_expression215=conditional_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, conditional_expression215.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 50, conditional_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "conditional_expression"


	public static class logical_or_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "logical_or_expression"
	// C.g:401:1: logical_or_expression : logical_and_expression ( '||' logical_and_expression )* ;
	public final CParser.logical_or_expression_return logical_or_expression() throws RecognitionException {
		CParser.logical_or_expression_return retval = new CParser.logical_or_expression_return();
		retval.start = input.LT(1);
		int logical_or_expression_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal217=null;
		ParserRuleReturnScope logical_and_expression216 =null;
		ParserRuleReturnScope logical_and_expression218 =null;

		Object string_literal217_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 51) ) { return retval; }

			// C.g:402:2: ( logical_and_expression ( '||' logical_and_expression )* )
			// C.g:402:4: logical_and_expression ( '||' logical_and_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1606);
			logical_and_expression216=logical_and_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_and_expression216.getTree());

			// C.g:402:27: ( '||' logical_and_expression )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==98) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// C.g:402:28: '||' logical_and_expression
					{
					string_literal217=(Token)match(input,98,FOLLOW_98_in_logical_or_expression1609); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal217_tree = (Object)adaptor.create(string_literal217);
					adaptor.addChild(root_0, string_literal217_tree);
					}

					pushFollow(FOLLOW_logical_and_expression_in_logical_or_expression1611);
					logical_and_expression218=logical_and_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_and_expression218.getTree());

					}
					break;

				default :
					break loop54;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 51, logical_or_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "logical_or_expression"


	public static class logical_and_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "logical_and_expression"
	// C.g:405:1: logical_and_expression : inclusive_or_expression ( '&&' inclusive_or_expression )* ;
	public final CParser.logical_and_expression_return logical_and_expression() throws RecognitionException {
		CParser.logical_and_expression_return retval = new CParser.logical_and_expression_return();
		retval.start = input.LT(1);
		int logical_and_expression_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal220=null;
		ParserRuleReturnScope inclusive_or_expression219 =null;
		ParserRuleReturnScope inclusive_or_expression221 =null;

		Object string_literal220_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 52) ) { return retval; }

			// C.g:406:2: ( inclusive_or_expression ( '&&' inclusive_or_expression )* )
			// C.g:406:4: inclusive_or_expression ( '&&' inclusive_or_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1624);
			inclusive_or_expression219=inclusive_or_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusive_or_expression219.getTree());

			// C.g:406:28: ( '&&' inclusive_or_expression )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==27) ) {
					alt55=1;
				}

				switch (alt55) {
				case 1 :
					// C.g:406:29: '&&' inclusive_or_expression
					{
					string_literal220=(Token)match(input,27,FOLLOW_27_in_logical_and_expression1627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal220_tree = (Object)adaptor.create(string_literal220);
					adaptor.addChild(root_0, string_literal220_tree);
					}

					pushFollow(FOLLOW_inclusive_or_expression_in_logical_and_expression1629);
					inclusive_or_expression221=inclusive_or_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusive_or_expression221.getTree());

					}
					break;

				default :
					break loop55;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 52, logical_and_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "logical_and_expression"


	public static class inclusive_or_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inclusive_or_expression"
	// C.g:409:1: inclusive_or_expression : exclusive_or_expression ( '|' exclusive_or_expression )* ;
	public final CParser.inclusive_or_expression_return inclusive_or_expression() throws RecognitionException {
		CParser.inclusive_or_expression_return retval = new CParser.inclusive_or_expression_return();
		retval.start = input.LT(1);
		int inclusive_or_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal223=null;
		ParserRuleReturnScope exclusive_or_expression222 =null;
		ParserRuleReturnScope exclusive_or_expression224 =null;

		Object char_literal223_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 53) ) { return retval; }

			// C.g:410:2: ( exclusive_or_expression ( '|' exclusive_or_expression )* )
			// C.g:410:4: exclusive_or_expression ( '|' exclusive_or_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1642);
			exclusive_or_expression222=exclusive_or_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusive_or_expression222.getTree());

			// C.g:410:28: ( '|' exclusive_or_expression )*
			loop56:
			while (true) {
				int alt56=2;
				int LA56_0 = input.LA(1);
				if ( (LA56_0==96) ) {
					alt56=1;
				}

				switch (alt56) {
				case 1 :
					// C.g:410:29: '|' exclusive_or_expression
					{
					char_literal223=(Token)match(input,96,FOLLOW_96_in_inclusive_or_expression1645); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal223_tree = (Object)adaptor.create(char_literal223);
					adaptor.addChild(root_0, char_literal223_tree);
					}

					pushFollow(FOLLOW_exclusive_or_expression_in_inclusive_or_expression1647);
					exclusive_or_expression224=exclusive_or_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusive_or_expression224.getTree());

					}
					break;

				default :
					break loop56;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 53, inclusive_or_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "inclusive_or_expression"


	public static class exclusive_or_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exclusive_or_expression"
	// C.g:413:1: exclusive_or_expression : and_expression ( '^' and_expression )* ;
	public final CParser.exclusive_or_expression_return exclusive_or_expression() throws RecognitionException {
		CParser.exclusive_or_expression_return retval = new CParser.exclusive_or_expression_return();
		retval.start = input.LT(1);
		int exclusive_or_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal226=null;
		ParserRuleReturnScope and_expression225 =null;
		ParserRuleReturnScope and_expression227 =null;

		Object char_literal226_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 54) ) { return retval; }

			// C.g:414:2: ( and_expression ( '^' and_expression )* )
			// C.g:414:4: and_expression ( '^' and_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_and_expression_in_exclusive_or_expression1660);
			and_expression225=and_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expression225.getTree());

			// C.g:414:19: ( '^' and_expression )*
			loop57:
			while (true) {
				int alt57=2;
				int LA57_0 = input.LA(1);
				if ( (LA57_0==61) ) {
					alt57=1;
				}

				switch (alt57) {
				case 1 :
					// C.g:414:20: '^' and_expression
					{
					char_literal226=(Token)match(input,61,FOLLOW_61_in_exclusive_or_expression1663); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal226_tree = (Object)adaptor.create(char_literal226);
					adaptor.addChild(root_0, char_literal226_tree);
					}

					pushFollow(FOLLOW_and_expression_in_exclusive_or_expression1665);
					and_expression227=and_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, and_expression227.getTree());

					}
					break;

				default :
					break loop57;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 54, exclusive_or_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "exclusive_or_expression"


	public static class and_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "and_expression"
	// C.g:417:1: and_expression : equality_expression ( '&' equality_expression )* ;
	public final CParser.and_expression_return and_expression() throws RecognitionException {
		CParser.and_expression_return retval = new CParser.and_expression_return();
		retval.start = input.LT(1);
		int and_expression_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal229=null;
		ParserRuleReturnScope equality_expression228 =null;
		ParserRuleReturnScope equality_expression230 =null;

		Object char_literal229_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 55) ) { return retval; }

			// C.g:418:2: ( equality_expression ( '&' equality_expression )* )
			// C.g:418:4: equality_expression ( '&' equality_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_equality_expression_in_and_expression1678);
			equality_expression228=equality_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, equality_expression228.getTree());

			// C.g:418:24: ( '&' equality_expression )*
			loop58:
			while (true) {
				int alt58=2;
				int LA58_0 = input.LA(1);
				if ( (LA58_0==28) ) {
					alt58=1;
				}

				switch (alt58) {
				case 1 :
					// C.g:418:25: '&' equality_expression
					{
					char_literal229=(Token)match(input,28,FOLLOW_28_in_and_expression1681); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal229_tree = (Object)adaptor.create(char_literal229);
					adaptor.addChild(root_0, char_literal229_tree);
					}

					pushFollow(FOLLOW_equality_expression_in_and_expression1683);
					equality_expression230=equality_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, equality_expression230.getTree());

					}
					break;

				default :
					break loop58;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 55, and_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "and_expression"


	public static class equality_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "equality_expression"
	// C.g:420:1: equality_expression : relational_expression ( ( '==' | '!=' ) relational_expression )* ;
	public final CParser.equality_expression_return equality_expression() throws RecognitionException {
		CParser.equality_expression_return retval = new CParser.equality_expression_return();
		retval.start = input.LT(1);
		int equality_expression_StartIndex = input.index();

		Object root_0 = null;

		Token set232=null;
		ParserRuleReturnScope relational_expression231 =null;
		ParserRuleReturnScope relational_expression233 =null;

		Object set232_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 56) ) { return retval; }

			// C.g:421:2: ( relational_expression ( ( '==' | '!=' ) relational_expression )* )
			// C.g:421:4: relational_expression ( ( '==' | '!=' ) relational_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_relational_expression_in_equality_expression1695);
			relational_expression231=relational_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, relational_expression231.getTree());

			// C.g:421:26: ( ( '==' | '!=' ) relational_expression )*
			loop59:
			while (true) {
				int alt59=2;
				int LA59_0 = input.LA(1);
				if ( (LA59_0==24||LA59_0==53) ) {
					alt59=1;
				}

				switch (alt59) {
				case 1 :
					// C.g:421:27: ( '==' | '!=' ) relational_expression
					{
					set232=input.LT(1);
					if ( input.LA(1)==24||input.LA(1)==53 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set232));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_relational_expression_in_equality_expression1704);
					relational_expression233=relational_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, relational_expression233.getTree());

					}
					break;

				default :
					break loop59;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 56, equality_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "equality_expression"


	public static class relational_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "relational_expression"
	// C.g:424:1: relational_expression : shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )* ;
	public final CParser.relational_expression_return relational_expression() throws RecognitionException {
		CParser.relational_expression_return retval = new CParser.relational_expression_return();
		retval.start = input.LT(1);
		int relational_expression_StartIndex = input.index();

		Object root_0 = null;

		Token set235=null;
		ParserRuleReturnScope shift_expression234 =null;
		ParserRuleReturnScope shift_expression236 =null;

		Object set235_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 57) ) { return retval; }

			// C.g:425:2: ( shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )* )
			// C.g:425:4: shift_expression ( ( '<' | '>' | '<=' | '>=' ) shift_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_shift_expression_in_relational_expression1717);
			shift_expression234=shift_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, shift_expression234.getTree());

			// C.g:425:21: ( ( '<' | '>' | '<=' | '>=' ) shift_expression )*
			loop60:
			while (true) {
				int alt60=2;
				int LA60_0 = input.LA(1);
				if ( (LA60_0==48||LA60_0==51||(LA60_0 >= 54 && LA60_0 <= 55)) ) {
					alt60=1;
				}

				switch (alt60) {
				case 1 :
					// C.g:425:22: ( '<' | '>' | '<=' | '>=' ) shift_expression
					{
					set235=input.LT(1);
					if ( input.LA(1)==48||input.LA(1)==51||(input.LA(1) >= 54 && input.LA(1) <= 55) ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set235));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_shift_expression_in_relational_expression1730);
					shift_expression236=shift_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, shift_expression236.getTree());

					}
					break;

				default :
					break loop60;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 57, relational_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "relational_expression"


	public static class shift_expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "shift_expression"
	// C.g:428:1: shift_expression : additive_expression ( ( '<<' | '>>' ) additive_expression )* ;
	public final CParser.shift_expression_return shift_expression() throws RecognitionException {
		CParser.shift_expression_return retval = new CParser.shift_expression_return();
		retval.start = input.LT(1);
		int shift_expression_StartIndex = input.index();

		Object root_0 = null;

		Token set238=null;
		ParserRuleReturnScope additive_expression237 =null;
		ParserRuleReturnScope additive_expression239 =null;

		Object set238_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 58) ) { return retval; }

			// C.g:429:2: ( additive_expression ( ( '<<' | '>>' ) additive_expression )* )
			// C.g:429:4: additive_expression ( ( '<<' | '>>' ) additive_expression )*
			{
			root_0 = (Object)adaptor.nil();


			pushFollow(FOLLOW_additive_expression_in_shift_expression1743);
			additive_expression237=additive_expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, additive_expression237.getTree());

			// C.g:429:24: ( ( '<<' | '>>' ) additive_expression )*
			loop61:
			while (true) {
				int alt61=2;
				int LA61_0 = input.LA(1);
				if ( (LA61_0==49||LA61_0==56) ) {
					alt61=1;
				}

				switch (alt61) {
				case 1 :
					// C.g:429:25: ( '<<' | '>>' ) additive_expression
					{
					set238=input.LT(1);
					if ( input.LA(1)==49||input.LA(1)==56 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set238));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_additive_expression_in_shift_expression1752);
					additive_expression239=additive_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, additive_expression239.getTree());

					}
					break;

				default :
					break loop61;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 58, shift_expression_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "shift_expression"


	public static class statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// C.g:434:1: statement : ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement );
	public final CParser.statement_return statement() throws RecognitionException {
		CParser.statement_return retval = new CParser.statement_return();
		retval.start = input.LT(1);
		int statement_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope labeled_statement240 =null;
		ParserRuleReturnScope compound_statement241 =null;
		ParserRuleReturnScope expression_statement242 =null;
		ParserRuleReturnScope selection_statement243 =null;
		ParserRuleReturnScope iteration_statement244 =null;
		ParserRuleReturnScope jump_statement245 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 59) ) { return retval; }

			// C.g:435:2: ( labeled_statement | compound_statement | expression_statement | selection_statement | iteration_statement | jump_statement )
			int alt62=6;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				int LA62_1 = input.LA(2);
				if ( (LA62_1==46) ) {
					alt62=1;
				}
				else if ( ((LA62_1 >= 24 && LA62_1 <= 30)||(LA62_1 >= 32 && LA62_1 <= 42)||(LA62_1 >= 44 && LA62_1 <= 45)||(LA62_1 >= 47 && LA62_1 <= 59)||(LA62_1 >= 61 && LA62_1 <= 62)||(LA62_1 >= 96 && LA62_1 <= 98)) ) {
					alt62=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 62, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 65:
			case 69:
				{
				alt62=1;
				}
				break;
			case 95:
				{
				alt62=2;
				}
				break;
			case CHARACTER_LITERAL:
			case DECIMAL_LITERAL:
			case FLOATING_POINT_LITERAL:
			case HEX_LITERAL:
			case OCTAL_LITERAL:
			case STRING_LITERAL:
			case 23:
			case 28:
			case 30:
			case 32:
			case 34:
			case 35:
			case 38:
			case 39:
			case 47:
			case 85:
			case 100:
				{
				alt62=3;
				}
				break;
			case 78:
			case 88:
				{
				alt62=4;
				}
				break;
			case 70:
			case 76:
			case 94:
				{
				alt62=5;
				}
				break;
			case 64:
			case 68:
			case 77:
			case 82:
				{
				alt62=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 62, 0, input);
				throw nvae;
			}
			switch (alt62) {
				case 1 :
					// C.g:435:4: labeled_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_labeled_statement_in_statement1767);
					labeled_statement240=labeled_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, labeled_statement240.getTree());

					}
					break;
				case 2 :
					// C.g:436:4: compound_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_compound_statement_in_statement1772);
					compound_statement241=compound_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_statement241.getTree());

					}
					break;
				case 3 :
					// C.g:437:4: expression_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_statement_in_statement1777);
					expression_statement242=expression_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_statement242.getTree());

					}
					break;
				case 4 :
					// C.g:438:4: selection_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_selection_statement_in_statement1782);
					selection_statement243=selection_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, selection_statement243.getTree());

					}
					break;
				case 5 :
					// C.g:439:4: iteration_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_iteration_statement_in_statement1787);
					iteration_statement244=iteration_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, iteration_statement244.getTree());

					}
					break;
				case 6 :
					// C.g:440:4: jump_statement
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_jump_statement_in_statement1792);
					jump_statement245=jump_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, jump_statement245.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 59, statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class labeled_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "labeled_statement"
	// C.g:443:1: labeled_statement : ( IDENTIFIER ':' statement | 'case' constant_expression ':' statement | 'default' ':' statement );
	public final CParser.labeled_statement_return labeled_statement() throws RecognitionException {
		CParser.labeled_statement_return retval = new CParser.labeled_statement_return();
		retval.start = input.LT(1);
		int labeled_statement_StartIndex = input.index();

		Object root_0 = null;

		Token IDENTIFIER246=null;
		Token char_literal247=null;
		Token string_literal249=null;
		Token char_literal251=null;
		Token string_literal253=null;
		Token char_literal254=null;
		ParserRuleReturnScope statement248 =null;
		ParserRuleReturnScope constant_expression250 =null;
		ParserRuleReturnScope statement252 =null;
		ParserRuleReturnScope statement255 =null;

		Object IDENTIFIER246_tree=null;
		Object char_literal247_tree=null;
		Object string_literal249_tree=null;
		Object char_literal251_tree=null;
		Object string_literal253_tree=null;
		Object char_literal254_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 60) ) { return retval; }

			// C.g:444:2: ( IDENTIFIER ':' statement | 'case' constant_expression ':' statement | 'default' ':' statement )
			int alt63=3;
			switch ( input.LA(1) ) {
			case IDENTIFIER:
				{
				alt63=1;
				}
				break;
			case 65:
				{
				alt63=2;
				}
				break;
			case 69:
				{
				alt63=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}
			switch (alt63) {
				case 1 :
					// C.g:444:4: IDENTIFIER ':' statement
					{
					root_0 = (Object)adaptor.nil();


					IDENTIFIER246=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_labeled_statement1803); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER246_tree = (Object)adaptor.create(IDENTIFIER246);
					adaptor.addChild(root_0, IDENTIFIER246_tree);
					}

					char_literal247=(Token)match(input,46,FOLLOW_46_in_labeled_statement1805); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal247_tree = (Object)adaptor.create(char_literal247);
					adaptor.addChild(root_0, char_literal247_tree);
					}

					pushFollow(FOLLOW_statement_in_labeled_statement1807);
					statement248=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement248.getTree());

					}
					break;
				case 2 :
					// C.g:445:4: 'case' constant_expression ':' statement
					{
					root_0 = (Object)adaptor.nil();


					string_literal249=(Token)match(input,65,FOLLOW_65_in_labeled_statement1812); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal249_tree = (Object)adaptor.create(string_literal249);
					adaptor.addChild(root_0, string_literal249_tree);
					}

					pushFollow(FOLLOW_constant_expression_in_labeled_statement1814);
					constant_expression250=constant_expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constant_expression250.getTree());

					char_literal251=(Token)match(input,46,FOLLOW_46_in_labeled_statement1816); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal251_tree = (Object)adaptor.create(char_literal251);
					adaptor.addChild(root_0, char_literal251_tree);
					}

					pushFollow(FOLLOW_statement_in_labeled_statement1818);
					statement252=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement252.getTree());

					}
					break;
				case 3 :
					// C.g:446:4: 'default' ':' statement
					{
					root_0 = (Object)adaptor.nil();


					string_literal253=(Token)match(input,69,FOLLOW_69_in_labeled_statement1823); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal253_tree = (Object)adaptor.create(string_literal253);
					adaptor.addChild(root_0, string_literal253_tree);
					}

					char_literal254=(Token)match(input,46,FOLLOW_46_in_labeled_statement1825); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal254_tree = (Object)adaptor.create(char_literal254);
					adaptor.addChild(root_0, char_literal254_tree);
					}

					pushFollow(FOLLOW_statement_in_labeled_statement1827);
					statement255=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement255.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 60, labeled_statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "labeled_statement"


	public static class compound_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "compound_statement"
	// C.g:449:1: compound_statement : '{' ( declaration )* ( statement_list )? '}' ;
	public final CParser.compound_statement_return compound_statement() throws RecognitionException {
		Symbols_stack.push(new Symbols_scope());

		CParser.compound_statement_return retval = new CParser.compound_statement_return();
		retval.start = input.LT(1);
		int compound_statement_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal256=null;
		Token char_literal259=null;
		ParserRuleReturnScope declaration257 =null;
		ParserRuleReturnScope statement_list258 =null;

		Object char_literal256_tree=null;
		Object char_literal259_tree=null;


		  Symbols_stack.peek().types = new HashSet();

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 61) ) { return retval; }

			// C.g:454:2: ( '{' ( declaration )* ( statement_list )? '}' )
			// C.g:454:4: '{' ( declaration )* ( statement_list )? '}'
			{
			root_0 = (Object)adaptor.nil();


			char_literal256=(Token)match(input,95,FOLLOW_95_in_compound_statement1849); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal256_tree = (Object)adaptor.create(char_literal256);
			adaptor.addChild(root_0, char_literal256_tree);
			}

			// C.g:454:8: ( declaration )*
			loop64:
			while (true) {
				int alt64=2;
				alt64 = dfa64.predict(input);
				switch (alt64) {
				case 1 :
					// C.g:454:8: declaration
					{
					pushFollow(FOLLOW_declaration_in_compound_statement1851);
					declaration257=declaration();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, declaration257.getTree());

					}
					break;

				default :
					break loop64;
				}
			}

			// C.g:454:21: ( statement_list )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==CHARACTER_LITERAL||LA65_0==DECIMAL_LITERAL||LA65_0==FLOATING_POINT_LITERAL||LA65_0==HEX_LITERAL||LA65_0==IDENTIFIER||LA65_0==OCTAL_LITERAL||LA65_0==STRING_LITERAL||LA65_0==23||LA65_0==28||LA65_0==30||LA65_0==32||(LA65_0 >= 34 && LA65_0 <= 35)||(LA65_0 >= 38 && LA65_0 <= 39)||LA65_0==47||(LA65_0 >= 64 && LA65_0 <= 65)||(LA65_0 >= 68 && LA65_0 <= 70)||(LA65_0 >= 76 && LA65_0 <= 78)||LA65_0==82||LA65_0==85||LA65_0==88||(LA65_0 >= 94 && LA65_0 <= 95)||LA65_0==100) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// C.g:454:21: statement_list
					{
					pushFollow(FOLLOW_statement_list_in_compound_statement1854);
					statement_list258=statement_list();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement_list258.getTree());

					}
					break;

			}

			char_literal259=(Token)match(input,99,FOLLOW_99_in_compound_statement1857); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal259_tree = (Object)adaptor.create(char_literal259);
			adaptor.addChild(root_0, char_literal259_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 61, compound_statement_StartIndex); }

			Symbols_stack.pop();

		}
		return retval;
	}
	// $ANTLR end "compound_statement"


	public static class statement_list_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "statement_list"
	// C.g:457:1: statement_list : ( statement )+ ;
	public final CParser.statement_list_return statement_list() throws RecognitionException {
		CParser.statement_list_return retval = new CParser.statement_list_return();
		retval.start = input.LT(1);
		int statement_list_StartIndex = input.index();

		Object root_0 = null;

		ParserRuleReturnScope statement260 =null;


		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 62) ) { return retval; }

			// C.g:458:2: ( ( statement )+ )
			// C.g:458:4: ( statement )+
			{
			root_0 = (Object)adaptor.nil();


			// C.g:458:4: ( statement )+
			int cnt66=0;
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( (LA66_0==CHARACTER_LITERAL||LA66_0==DECIMAL_LITERAL||LA66_0==FLOATING_POINT_LITERAL||LA66_0==HEX_LITERAL||LA66_0==IDENTIFIER||LA66_0==OCTAL_LITERAL||LA66_0==STRING_LITERAL||LA66_0==23||LA66_0==28||LA66_0==30||LA66_0==32||(LA66_0 >= 34 && LA66_0 <= 35)||(LA66_0 >= 38 && LA66_0 <= 39)||LA66_0==47||(LA66_0 >= 64 && LA66_0 <= 65)||(LA66_0 >= 68 && LA66_0 <= 70)||(LA66_0 >= 76 && LA66_0 <= 78)||LA66_0==82||LA66_0==85||LA66_0==88||(LA66_0 >= 94 && LA66_0 <= 95)||LA66_0==100) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// C.g:458:4: statement
					{
					pushFollow(FOLLOW_statement_in_statement_list1868);
					statement260=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement260.getTree());

					}
					break;

				default :
					if ( cnt66 >= 1 ) break loop66;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(66, input);
					throw eee;
				}
				cnt66++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 62, statement_list_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "statement_list"


	public static class expression_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression_statement"
	// C.g:461:1: expression_statement : ( ';' | expression ';' );
	public final CParser.expression_statement_return expression_statement() throws RecognitionException {
		CParser.expression_statement_return retval = new CParser.expression_statement_return();
		retval.start = input.LT(1);
		int expression_statement_StartIndex = input.index();

		Object root_0 = null;

		Token char_literal261=null;
		Token char_literal263=null;
		ParserRuleReturnScope expression262 =null;

		Object char_literal261_tree=null;
		Object char_literal263_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 63) ) { return retval; }

			// C.g:462:2: ( ';' | expression ';' )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==47) ) {
				alt67=1;
			}
			else if ( (LA67_0==CHARACTER_LITERAL||LA67_0==DECIMAL_LITERAL||LA67_0==FLOATING_POINT_LITERAL||LA67_0==HEX_LITERAL||LA67_0==IDENTIFIER||LA67_0==OCTAL_LITERAL||LA67_0==STRING_LITERAL||LA67_0==23||LA67_0==28||LA67_0==30||LA67_0==32||(LA67_0 >= 34 && LA67_0 <= 35)||(LA67_0 >= 38 && LA67_0 <= 39)||LA67_0==85||LA67_0==100) ) {
				alt67=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// C.g:462:4: ';'
					{
					root_0 = (Object)adaptor.nil();


					char_literal261=(Token)match(input,47,FOLLOW_47_in_expression_statement1880); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal261_tree = (Object)adaptor.create(char_literal261);
					adaptor.addChild(root_0, char_literal261_tree);
					}

					}
					break;
				case 2 :
					// C.g:463:4: expression ';'
					{
					root_0 = (Object)adaptor.nil();


					pushFollow(FOLLOW_expression_in_expression_statement1885);
					expression262=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression262.getTree());

					char_literal263=(Token)match(input,47,FOLLOW_47_in_expression_statement1887); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal263_tree = (Object)adaptor.create(char_literal263);
					adaptor.addChild(root_0, char_literal263_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 63, expression_statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "expression_statement"


	public static class selection_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "selection_statement"
	// C.g:466:1: selection_statement : ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? | 'switch' '(' expression ')' statement );
	public final CParser.selection_statement_return selection_statement() throws RecognitionException {
		CParser.selection_statement_return retval = new CParser.selection_statement_return();
		retval.start = input.LT(1);
		int selection_statement_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal264=null;
		Token char_literal265=null;
		Token char_literal267=null;
		Token string_literal269=null;
		Token string_literal271=null;
		Token char_literal272=null;
		Token char_literal274=null;
		ParserRuleReturnScope expression266 =null;
		ParserRuleReturnScope statement268 =null;
		ParserRuleReturnScope statement270 =null;
		ParserRuleReturnScope expression273 =null;
		ParserRuleReturnScope statement275 =null;

		Object string_literal264_tree=null;
		Object char_literal265_tree=null;
		Object char_literal267_tree=null;
		Object string_literal269_tree=null;
		Object string_literal271_tree=null;
		Object char_literal272_tree=null;
		Object char_literal274_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 64) ) { return retval; }

			// C.g:467:2: ( 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )? | 'switch' '(' expression ')' statement )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==78) ) {
				alt69=1;
			}
			else if ( (LA69_0==88) ) {
				alt69=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 69, 0, input);
				throw nvae;
			}

			switch (alt69) {
				case 1 :
					// C.g:467:4: 'if' '(' expression ')' statement ( options {k=1; backtrack=false; } : 'else' statement )?
					{
					root_0 = (Object)adaptor.nil();


					string_literal264=(Token)match(input,78,FOLLOW_78_in_selection_statement1898); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal264_tree = (Object)adaptor.create(string_literal264);
					adaptor.addChild(root_0, string_literal264_tree);
					}

					char_literal265=(Token)match(input,30,FOLLOW_30_in_selection_statement1900); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal265_tree = (Object)adaptor.create(char_literal265);
					adaptor.addChild(root_0, char_literal265_tree);
					}

					pushFollow(FOLLOW_expression_in_selection_statement1902);
					expression266=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression266.getTree());

					char_literal267=(Token)match(input,31,FOLLOW_31_in_selection_statement1904); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal267_tree = (Object)adaptor.create(char_literal267);
					adaptor.addChild(root_0, char_literal267_tree);
					}

					pushFollow(FOLLOW_statement_in_selection_statement1906);
					statement268=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement268.getTree());

					// C.g:467:38: ( options {k=1; backtrack=false; } : 'else' statement )?
					int alt68=2;
					int LA68_0 = input.LA(1);
					if ( (LA68_0==72) ) {
						int LA68_1 = input.LA(2);
						if ( (true) ) {
							alt68=1;
						}
					}
					switch (alt68) {
						case 1 :
							// C.g:467:71: 'else' statement
							{
							string_literal269=(Token)match(input,72,FOLLOW_72_in_selection_statement1921); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							string_literal269_tree = (Object)adaptor.create(string_literal269);
							adaptor.addChild(root_0, string_literal269_tree);
							}

							pushFollow(FOLLOW_statement_in_selection_statement1923);
							statement270=statement();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, statement270.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// C.g:468:4: 'switch' '(' expression ')' statement
					{
					root_0 = (Object)adaptor.nil();


					string_literal271=(Token)match(input,88,FOLLOW_88_in_selection_statement1930); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal271_tree = (Object)adaptor.create(string_literal271);
					adaptor.addChild(root_0, string_literal271_tree);
					}

					char_literal272=(Token)match(input,30,FOLLOW_30_in_selection_statement1932); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal272_tree = (Object)adaptor.create(char_literal272);
					adaptor.addChild(root_0, char_literal272_tree);
					}

					pushFollow(FOLLOW_expression_in_selection_statement1934);
					expression273=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression273.getTree());

					char_literal274=(Token)match(input,31,FOLLOW_31_in_selection_statement1936); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal274_tree = (Object)adaptor.create(char_literal274);
					adaptor.addChild(root_0, char_literal274_tree);
					}

					pushFollow(FOLLOW_statement_in_selection_statement1938);
					statement275=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement275.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 64, selection_statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "selection_statement"


	public static class iteration_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "iteration_statement"
	// C.g:471:1: iteration_statement : ( 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' expression_statement expression_statement ( expression )? ')' statement );
	public final CParser.iteration_statement_return iteration_statement() throws RecognitionException {
		CParser.iteration_statement_return retval = new CParser.iteration_statement_return();
		retval.start = input.LT(1);
		int iteration_statement_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal276=null;
		Token char_literal277=null;
		Token char_literal279=null;
		Token string_literal281=null;
		Token string_literal283=null;
		Token char_literal284=null;
		Token char_literal286=null;
		Token char_literal287=null;
		Token string_literal288=null;
		Token char_literal289=null;
		Token char_literal293=null;
		ParserRuleReturnScope expression278 =null;
		ParserRuleReturnScope statement280 =null;
		ParserRuleReturnScope statement282 =null;
		ParserRuleReturnScope expression285 =null;
		ParserRuleReturnScope expression_statement290 =null;
		ParserRuleReturnScope expression_statement291 =null;
		ParserRuleReturnScope expression292 =null;
		ParserRuleReturnScope statement294 =null;

		Object string_literal276_tree=null;
		Object char_literal277_tree=null;
		Object char_literal279_tree=null;
		Object string_literal281_tree=null;
		Object string_literal283_tree=null;
		Object char_literal284_tree=null;
		Object char_literal286_tree=null;
		Object char_literal287_tree=null;
		Object string_literal288_tree=null;
		Object char_literal289_tree=null;
		Object char_literal293_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 65) ) { return retval; }

			// C.g:472:2: ( 'while' '(' expression ')' statement | 'do' statement 'while' '(' expression ')' ';' | 'for' '(' expression_statement expression_statement ( expression )? ')' statement )
			int alt71=3;
			switch ( input.LA(1) ) {
			case 94:
				{
				alt71=1;
				}
				break;
			case 70:
				{
				alt71=2;
				}
				break;
			case 76:
				{
				alt71=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 71, 0, input);
				throw nvae;
			}
			switch (alt71) {
				case 1 :
					// C.g:472:4: 'while' '(' expression ')' statement
					{
					root_0 = (Object)adaptor.nil();


					string_literal276=(Token)match(input,94,FOLLOW_94_in_iteration_statement1949); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal276_tree = (Object)adaptor.create(string_literal276);
					adaptor.addChild(root_0, string_literal276_tree);
					}

					char_literal277=(Token)match(input,30,FOLLOW_30_in_iteration_statement1951); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal277_tree = (Object)adaptor.create(char_literal277);
					adaptor.addChild(root_0, char_literal277_tree);
					}

					pushFollow(FOLLOW_expression_in_iteration_statement1953);
					expression278=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression278.getTree());

					char_literal279=(Token)match(input,31,FOLLOW_31_in_iteration_statement1955); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal279_tree = (Object)adaptor.create(char_literal279);
					adaptor.addChild(root_0, char_literal279_tree);
					}

					pushFollow(FOLLOW_statement_in_iteration_statement1957);
					statement280=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement280.getTree());

					}
					break;
				case 2 :
					// C.g:473:4: 'do' statement 'while' '(' expression ')' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal281=(Token)match(input,70,FOLLOW_70_in_iteration_statement1962); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal281_tree = (Object)adaptor.create(string_literal281);
					adaptor.addChild(root_0, string_literal281_tree);
					}

					pushFollow(FOLLOW_statement_in_iteration_statement1964);
					statement282=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement282.getTree());

					string_literal283=(Token)match(input,94,FOLLOW_94_in_iteration_statement1966); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal283_tree = (Object)adaptor.create(string_literal283);
					adaptor.addChild(root_0, string_literal283_tree);
					}

					char_literal284=(Token)match(input,30,FOLLOW_30_in_iteration_statement1968); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal284_tree = (Object)adaptor.create(char_literal284);
					adaptor.addChild(root_0, char_literal284_tree);
					}

					pushFollow(FOLLOW_expression_in_iteration_statement1970);
					expression285=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression285.getTree());

					char_literal286=(Token)match(input,31,FOLLOW_31_in_iteration_statement1972); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal286_tree = (Object)adaptor.create(char_literal286);
					adaptor.addChild(root_0, char_literal286_tree);
					}

					char_literal287=(Token)match(input,47,FOLLOW_47_in_iteration_statement1974); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal287_tree = (Object)adaptor.create(char_literal287);
					adaptor.addChild(root_0, char_literal287_tree);
					}

					}
					break;
				case 3 :
					// C.g:474:4: 'for' '(' expression_statement expression_statement ( expression )? ')' statement
					{
					root_0 = (Object)adaptor.nil();


					string_literal288=(Token)match(input,76,FOLLOW_76_in_iteration_statement1979); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal288_tree = (Object)adaptor.create(string_literal288);
					adaptor.addChild(root_0, string_literal288_tree);
					}

					char_literal289=(Token)match(input,30,FOLLOW_30_in_iteration_statement1981); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal289_tree = (Object)adaptor.create(char_literal289);
					adaptor.addChild(root_0, char_literal289_tree);
					}

					pushFollow(FOLLOW_expression_statement_in_iteration_statement1983);
					expression_statement290=expression_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_statement290.getTree());

					pushFollow(FOLLOW_expression_statement_in_iteration_statement1985);
					expression_statement291=expression_statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression_statement291.getTree());

					// C.g:474:56: ( expression )?
					int alt70=2;
					int LA70_0 = input.LA(1);
					if ( (LA70_0==CHARACTER_LITERAL||LA70_0==DECIMAL_LITERAL||LA70_0==FLOATING_POINT_LITERAL||LA70_0==HEX_LITERAL||LA70_0==IDENTIFIER||LA70_0==OCTAL_LITERAL||LA70_0==STRING_LITERAL||LA70_0==23||LA70_0==28||LA70_0==30||LA70_0==32||(LA70_0 >= 34 && LA70_0 <= 35)||(LA70_0 >= 38 && LA70_0 <= 39)||LA70_0==85||LA70_0==100) ) {
						alt70=1;
					}
					switch (alt70) {
						case 1 :
							// C.g:474:56: expression
							{
							pushFollow(FOLLOW_expression_in_iteration_statement1987);
							expression292=expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expression292.getTree());

							}
							break;

					}

					char_literal293=(Token)match(input,31,FOLLOW_31_in_iteration_statement1990); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal293_tree = (Object)adaptor.create(char_literal293);
					adaptor.addChild(root_0, char_literal293_tree);
					}

					pushFollow(FOLLOW_statement_in_iteration_statement1992);
					statement294=statement();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, statement294.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 65, iteration_statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "iteration_statement"


	public static class jump_statement_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "jump_statement"
	// C.g:477:1: jump_statement : ( 'goto' IDENTIFIER ';' | 'continue' ';' | 'break' ';' | 'return' ';' | 'return' expression ';' );
	public final CParser.jump_statement_return jump_statement() throws RecognitionException {
		CParser.jump_statement_return retval = new CParser.jump_statement_return();
		retval.start = input.LT(1);
		int jump_statement_StartIndex = input.index();

		Object root_0 = null;

		Token string_literal295=null;
		Token IDENTIFIER296=null;
		Token char_literal297=null;
		Token string_literal298=null;
		Token char_literal299=null;
		Token string_literal300=null;
		Token char_literal301=null;
		Token string_literal302=null;
		Token char_literal303=null;
		Token string_literal304=null;
		Token char_literal306=null;
		ParserRuleReturnScope expression305 =null;

		Object string_literal295_tree=null;
		Object IDENTIFIER296_tree=null;
		Object char_literal297_tree=null;
		Object string_literal298_tree=null;
		Object char_literal299_tree=null;
		Object string_literal300_tree=null;
		Object char_literal301_tree=null;
		Object string_literal302_tree=null;
		Object char_literal303_tree=null;
		Object string_literal304_tree=null;
		Object char_literal306_tree=null;

		try {
			if ( state.backtracking>0 && alreadyParsedRule(input, 66) ) { return retval; }

			// C.g:478:2: ( 'goto' IDENTIFIER ';' | 'continue' ';' | 'break' ';' | 'return' ';' | 'return' expression ';' )
			int alt72=5;
			switch ( input.LA(1) ) {
			case 77:
				{
				alt72=1;
				}
				break;
			case 68:
				{
				alt72=2;
				}
				break;
			case 64:
				{
				alt72=3;
				}
				break;
			case 82:
				{
				int LA72_4 = input.LA(2);
				if ( (LA72_4==47) ) {
					alt72=4;
				}
				else if ( (LA72_4==CHARACTER_LITERAL||LA72_4==DECIMAL_LITERAL||LA72_4==FLOATING_POINT_LITERAL||LA72_4==HEX_LITERAL||LA72_4==IDENTIFIER||LA72_4==OCTAL_LITERAL||LA72_4==STRING_LITERAL||LA72_4==23||LA72_4==28||LA72_4==30||LA72_4==32||(LA72_4 >= 34 && LA72_4 <= 35)||(LA72_4 >= 38 && LA72_4 <= 39)||LA72_4==85||LA72_4==100) ) {
					alt72=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 72, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}
			switch (alt72) {
				case 1 :
					// C.g:478:4: 'goto' IDENTIFIER ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal295=(Token)match(input,77,FOLLOW_77_in_jump_statement2003); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal295_tree = (Object)adaptor.create(string_literal295);
					adaptor.addChild(root_0, string_literal295_tree);
					}

					IDENTIFIER296=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_jump_statement2005); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENTIFIER296_tree = (Object)adaptor.create(IDENTIFIER296);
					adaptor.addChild(root_0, IDENTIFIER296_tree);
					}

					char_literal297=(Token)match(input,47,FOLLOW_47_in_jump_statement2007); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal297_tree = (Object)adaptor.create(char_literal297);
					adaptor.addChild(root_0, char_literal297_tree);
					}

					}
					break;
				case 2 :
					// C.g:479:4: 'continue' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal298=(Token)match(input,68,FOLLOW_68_in_jump_statement2012); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal298_tree = (Object)adaptor.create(string_literal298);
					adaptor.addChild(root_0, string_literal298_tree);
					}

					char_literal299=(Token)match(input,47,FOLLOW_47_in_jump_statement2014); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal299_tree = (Object)adaptor.create(char_literal299);
					adaptor.addChild(root_0, char_literal299_tree);
					}

					}
					break;
				case 3 :
					// C.g:480:4: 'break' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal300=(Token)match(input,64,FOLLOW_64_in_jump_statement2019); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal300_tree = (Object)adaptor.create(string_literal300);
					adaptor.addChild(root_0, string_literal300_tree);
					}

					char_literal301=(Token)match(input,47,FOLLOW_47_in_jump_statement2021); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal301_tree = (Object)adaptor.create(char_literal301);
					adaptor.addChild(root_0, char_literal301_tree);
					}

					}
					break;
				case 4 :
					// C.g:481:4: 'return' ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal302=(Token)match(input,82,FOLLOW_82_in_jump_statement2026); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal302_tree = (Object)adaptor.create(string_literal302);
					adaptor.addChild(root_0, string_literal302_tree);
					}

					char_literal303=(Token)match(input,47,FOLLOW_47_in_jump_statement2028); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal303_tree = (Object)adaptor.create(char_literal303);
					adaptor.addChild(root_0, char_literal303_tree);
					}

					}
					break;
				case 5 :
					// C.g:482:4: 'return' expression ';'
					{
					root_0 = (Object)adaptor.nil();


					string_literal304=(Token)match(input,82,FOLLOW_82_in_jump_statement2033); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					string_literal304_tree = (Object)adaptor.create(string_literal304);
					adaptor.addChild(root_0, string_literal304_tree);
					}

					pushFollow(FOLLOW_expression_in_jump_statement2035);
					expression305=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expression305.getTree());

					char_literal306=(Token)match(input,47,FOLLOW_47_in_jump_statement2037); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal306_tree = (Object)adaptor.create(char_literal306);
					adaptor.addChild(root_0, char_literal306_tree);
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if ( state.backtracking>0 ) { memoize(input, 66, jump_statement_StartIndex); }

		}
		return retval;
	}
	// $ANTLR end "jump_statement"

	// $ANTLR start synpred2_C
	public final void synpred2_C_fragment() throws RecognitionException {
		// C.g:98:6: ( declaration_specifiers )
		// C.g:98:6: declaration_specifiers
		{
		pushFollow(FOLLOW_declaration_specifiers_in_synpred2_C108);
		declaration_specifiers();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_C

	// $ANTLR start synpred4_C
	public final void synpred4_C_fragment() throws RecognitionException {
		// C.g:98:4: ( ( declaration_specifiers )? declarator ( declaration )* '{' )
		// C.g:98:6: ( declaration_specifiers )? declarator ( declaration )* '{'
		{
		// C.g:98:6: ( declaration_specifiers )?
		int alt73=2;
		int LA73_0 = input.LA(1);
		if ( (LA73_0==63||(LA73_0 >= 66 && LA73_0 <= 67)||LA73_0==71||(LA73_0 >= 73 && LA73_0 <= 75)||(LA73_0 >= 79 && LA73_0 <= 81)||(LA73_0 >= 83 && LA73_0 <= 84)||(LA73_0 >= 86 && LA73_0 <= 87)||(LA73_0 >= 90 && LA73_0 <= 93)) ) {
			alt73=1;
		}
		else if ( (LA73_0==IDENTIFIER) ) {
			switch ( input.LA(2) ) {
				case 32:
					{
					alt73=1;
					}
					break;
				case IDENTIFIER:
					{
					int LA73_18 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 30:
					{
					int LA73_19 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 63:
				case 74:
				case 81:
				case 86:
					{
					int LA73_20 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 92:
					{
					int LA73_21 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 66:
					{
					int LA73_22 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 83:
					{
					int LA73_23 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 79:
					{
					int LA73_24 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 80:
					{
					int LA73_25 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 75:
					{
					int LA73_26 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 71:
					{
					int LA73_27 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 84:
					{
					int LA73_28 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 91:
					{
					int LA73_29 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 87:
				case 90:
					{
					int LA73_30 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 73:
					{
					int LA73_31 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
				case 67:
				case 93:
					{
					int LA73_32 = input.LA(3);
					if ( ((synpred2_C()&&(isTypeName(input.LT(1).getText())))) ) {
						alt73=1;
					}
					}
					break;
			}
		}
		switch (alt73) {
			case 1 :
				// C.g:98:6: declaration_specifiers
				{
				pushFollow(FOLLOW_declaration_specifiers_in_synpred4_C108);
				declaration_specifiers();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_declarator_in_synpred4_C111);
		declarator();
		state._fsp--;
		if (state.failed) return;

		// C.g:98:41: ( declaration )*
		loop74:
		while (true) {
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==IDENTIFIER||LA74_0==63||(LA74_0 >= 66 && LA74_0 <= 67)||LA74_0==71||(LA74_0 >= 73 && LA74_0 <= 75)||(LA74_0 >= 79 && LA74_0 <= 81)||(LA74_0 >= 83 && LA74_0 <= 84)||(LA74_0 >= 86 && LA74_0 <= 87)||(LA74_0 >= 89 && LA74_0 <= 93)) ) {
				alt74=1;
			}

			switch (alt74) {
			case 1 :
				// C.g:98:41: declaration
				{
				pushFollow(FOLLOW_declaration_in_synpred4_C113);
				declaration();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				break loop74;
			}
		}

		match(input,95,FOLLOW_95_in_synpred4_C116); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_C

	// $ANTLR start synpred5_C
	public final void synpred5_C_fragment() throws RecognitionException {
		// C.g:107:4: ( declaration_specifiers )
		// C.g:107:4: declaration_specifiers
		{
		pushFollow(FOLLOW_declaration_specifiers_in_synpred5_C148);
		declaration_specifiers();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_C

	// $ANTLR start synpred8_C
	public final void synpred8_C_fragment() throws RecognitionException {
		// C.g:120:14: ( declaration_specifiers )
		// C.g:120:14: declaration_specifiers
		{
		pushFollow(FOLLOW_declaration_specifiers_in_synpred8_C197);
		declaration_specifiers();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred8_C

	// $ANTLR start synpred12_C
	public final void synpred12_C_fragment() throws RecognitionException {
		// C.g:127:7: ( type_specifier )
		// C.g:127:7: type_specifier
		{
		pushFollow(FOLLOW_type_specifier_in_synpred12_C243);
		type_specifier();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred12_C

	// $ANTLR start synpred35_C
	public final void synpred35_C_fragment() throws RecognitionException {
		// C.g:191:23: ( type_specifier )
		// C.g:191:23: type_specifier
		{
		pushFollow(FOLLOW_type_specifier_in_synpred35_C523);
		type_specifier();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred35_C

	// $ANTLR start synpred45_C
	public final void synpred45_C_fragment() throws RecognitionException {
		// C.g:224:4: ( ( pointer )? direct_declarator )
		// C.g:224:4: ( pointer )? direct_declarator
		{
		// C.g:224:4: ( pointer )?
		int alt79=2;
		int LA79_0 = input.LA(1);
		if ( (LA79_0==32) ) {
			alt79=1;
		}
		switch (alt79) {
			case 1 :
				// C.g:224:4: pointer
				{
				pushFollow(FOLLOW_pointer_in_synpred45_C676);
				pointer();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		pushFollow(FOLLOW_direct_declarator_in_synpred45_C679);
		direct_declarator();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred45_C

	// $ANTLR start synpred47_C
	public final void synpred47_C_fragment() throws RecognitionException {
		// C.g:238:9: ( declarator_suffix )
		// C.g:238:9: declarator_suffix
		{
		pushFollow(FOLLOW_declarator_suffix_in_synpred47_C728);
		declarator_suffix();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred47_C

	// $ANTLR start synpred50_C
	public final void synpred50_C_fragment() throws RecognitionException {
		// C.g:244:9: ( '(' parameter_type_list ')' )
		// C.g:244:9: '(' parameter_type_list ')'
		{
		match(input,30,FOLLOW_30_in_synpred50_C768); if (state.failed) return;

		pushFollow(FOLLOW_parameter_type_list_in_synpred50_C770);
		parameter_type_list();
		state._fsp--;
		if (state.failed) return;

		match(input,31,FOLLOW_31_in_synpred50_C772); if (state.failed) return;

		}

	}
	// $ANTLR end synpred50_C

	// $ANTLR start synpred51_C
	public final void synpred51_C_fragment() throws RecognitionException {
		// C.g:245:9: ( '(' identifier_list ')' )
		// C.g:245:9: '(' identifier_list ')'
		{
		match(input,30,FOLLOW_30_in_synpred51_C782); if (state.failed) return;

		pushFollow(FOLLOW_identifier_list_in_synpred51_C784);
		identifier_list();
		state._fsp--;
		if (state.failed) return;

		match(input,31,FOLLOW_31_in_synpred51_C786); if (state.failed) return;

		}

	}
	// $ANTLR end synpred51_C

	// $ANTLR start synpred52_C
	public final void synpred52_C_fragment() throws RecognitionException {
		// C.g:250:8: ( type_qualifier )
		// C.g:250:8: type_qualifier
		{
		pushFollow(FOLLOW_type_qualifier_in_synpred52_C811);
		type_qualifier();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred52_C

	// $ANTLR start synpred53_C
	public final void synpred53_C_fragment() throws RecognitionException {
		// C.g:250:24: ( pointer )
		// C.g:250:24: pointer
		{
		pushFollow(FOLLOW_pointer_in_synpred53_C814);
		pointer();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred53_C

	// $ANTLR start synpred54_C
	public final void synpred54_C_fragment() throws RecognitionException {
		// C.g:250:4: ( '*' ( type_qualifier )+ ( pointer )? )
		// C.g:250:4: '*' ( type_qualifier )+ ( pointer )?
		{
		match(input,32,FOLLOW_32_in_synpred54_C809); if (state.failed) return;

		// C.g:250:8: ( type_qualifier )+
		int cnt80=0;
		loop80:
		while (true) {
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==67||LA80_0==93) ) {
				alt80=1;
			}

			switch (alt80) {
			case 1 :
				// C.g:250:8: type_qualifier
				{
				pushFollow(FOLLOW_type_qualifier_in_synpred54_C811);
				type_qualifier();
				state._fsp--;
				if (state.failed) return;

				}
				break;

			default :
				if ( cnt80 >= 1 ) break loop80;
				if (state.backtracking>0) {state.failed=true; return;}
				EarlyExitException eee = new EarlyExitException(80, input);
				throw eee;
			}
			cnt80++;
		}

		// C.g:250:24: ( pointer )?
		int alt81=2;
		int LA81_0 = input.LA(1);
		if ( (LA81_0==32) ) {
			alt81=1;
		}
		switch (alt81) {
			case 1 :
				// C.g:250:24: pointer
				{
				pushFollow(FOLLOW_pointer_in_synpred54_C814);
				pointer();
				state._fsp--;
				if (state.failed) return;

				}
				break;

		}

		}

	}
	// $ANTLR end synpred54_C

	// $ANTLR start synpred55_C
	public final void synpred55_C_fragment() throws RecognitionException {
		// C.g:251:4: ( '*' pointer )
		// C.g:251:4: '*' pointer
		{
		match(input,32,FOLLOW_32_in_synpred55_C820); if (state.failed) return;

		pushFollow(FOLLOW_pointer_in_synpred55_C822);
		pointer();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred55_C

	// $ANTLR start synpred58_C
	public final void synpred58_C_fragment() throws RecognitionException {
		// C.g:264:28: ( declarator )
		// C.g:264:28: declarator
		{
		pushFollow(FOLLOW_declarator_in_synpred58_C877);
		declarator();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred58_C

	// $ANTLR start synpred59_C
	public final void synpred59_C_fragment() throws RecognitionException {
		// C.g:264:39: ( abstract_declarator )
		// C.g:264:39: abstract_declarator
		{
		pushFollow(FOLLOW_abstract_declarator_in_synpred59_C879);
		abstract_declarator();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred59_C

	// $ANTLR start synpred62_C
	public final void synpred62_C_fragment() throws RecognitionException {
		// C.g:276:12: ( direct_abstract_declarator )
		// C.g:276:12: direct_abstract_declarator
		{
		pushFollow(FOLLOW_direct_abstract_declarator_in_synpred62_C926);
		direct_abstract_declarator();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred62_C

	// $ANTLR start synpred65_C
	public final void synpred65_C_fragment() throws RecognitionException {
		// C.g:281:65: ( abstract_declarator_suffix )
		// C.g:281:65: abstract_declarator_suffix
		{
		pushFollow(FOLLOW_abstract_declarator_suffix_in_synpred65_C957);
		abstract_declarator_suffix();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred65_C

	// $ANTLR start synpred78_C
	public final void synpred78_C_fragment() throws RecognitionException {
		// C.g:315:4: ( '(' type_name ')' cast_expression )
		// C.g:315:4: '(' type_name ')' cast_expression
		{
		match(input,30,FOLLOW_30_in_synpred78_C1129); if (state.failed) return;

		pushFollow(FOLLOW_type_name_in_synpred78_C1131);
		type_name();
		state._fsp--;
		if (state.failed) return;

		match(input,31,FOLLOW_31_in_synpred78_C1133); if (state.failed) return;

		pushFollow(FOLLOW_cast_expression_in_synpred78_C1135);
		cast_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred78_C

	// $ANTLR start synpred83_C
	public final void synpred83_C_fragment() throws RecognitionException {
		// C.g:324:4: ( 'sizeof' unary_expression )
		// C.g:324:4: 'sizeof' unary_expression
		{
		match(input,85,FOLLOW_85_in_synpred83_C1177); if (state.failed) return;

		pushFollow(FOLLOW_unary_expression_in_synpred83_C1179);
		unary_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred83_C

	// $ANTLR start synpred104_C
	public final void synpred104_C_fragment() throws RecognitionException {
		// C.g:375:4: ( lvalue assignment_operator assignment_expression )
		// C.g:375:4: lvalue assignment_operator assignment_expression
		{
		pushFollow(FOLLOW_lvalue_in_synpred104_C1491);
		lvalue();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_assignment_operator_in_synpred104_C1493);
		assignment_operator();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_assignment_expression_in_synpred104_C1495);
		assignment_expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred104_C

	// $ANTLR start synpred136_C
	public final void synpred136_C_fragment() throws RecognitionException {
		// C.g:454:8: ( declaration )
		// C.g:454:8: declaration
		{
		pushFollow(FOLLOW_declaration_in_synpred136_C1851);
		declaration();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred136_C

	// Delegated rules

	public final boolean synpred65_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred65_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred47_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred47_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred136_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred136_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred50_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred50_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred62_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred62_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred35_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred35_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred104_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred104_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred55_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred55_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred45_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred45_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred51_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred51_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred54_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred54_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred78_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred78_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred59_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred59_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred58_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred58_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred52_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred52_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred83_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred83_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred53_C() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred53_C_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA52 dfa52 = new DFA52(this);
	protected DFA64 dfa64 = new DFA64(this);
	static final String DFA52_eotS =
		"\157\uffff";
	static final String DFA52_eofS =
		"\1\uffff\2\17\154\uffff";
	static final String DFA52_minS =
		"\1\4\2\30\5\4\6\0\26\uffff\6\0\26\uffff\7\0\14\uffff\34\0";
	static final String DFA52_maxS =
		"\1\144\2\143\5\144\6\0\26\uffff\6\0\26\uffff\7\0\14\uffff\34\0";
	static final String DFA52_acceptS =
		"\16\uffff\1\1\1\2\137\uffff";
	static final String DFA52_specialS =
		"\10\uffff\1\0\1\1\1\2\1\3\1\4\1\5\26\uffff\1\6\1\7\1\10\1\11\1\12\1\13"+
		"\26\uffff\1\14\1\15\1\16\1\17\1\20\1\21\1\22\14\uffff\1\23\1\24\1\25\1"+
		"\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1"+
		"\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56}>";
	static final String[] DFA52_transitionS = {
			"\1\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\1\4\uffff\1\2\1\uffff"+
			"\1\2\2\uffff\1\6\4\uffff\1\6\1\uffff\1\3\1\uffff\1\6\1\uffff\1\6\1\4"+
			"\2\uffff\1\6\1\5\55\uffff\1\7\16\uffff\1\6",
			"\2\17\1\16\2\17\1\16\1\11\2\17\1\16\1\17\1\14\1\16\2\17\1\15\1\16\1"+
			"\13\1\12\1\uffff\1\17\1\16\4\17\1\16\1\17\1\16\4\17\1\16\1\17\1\10\2"+
			"\17\1\16\41\uffff\1\17\1\16\2\17",
			"\2\17\1\16\2\17\1\16\1\45\2\17\1\16\1\17\1\50\1\16\2\17\1\51\1\16\1"+
			"\47\1\46\1\uffff\1\17\1\16\4\17\1\16\1\17\1\16\4\17\1\16\1\17\1\44\2"+
			"\17\1\16\41\uffff\1\17\1\16\2\17",
			"\1\101\1\uffff\1\101\2\uffff\1\101\1\uffff\1\101\1\uffff\1\100\4\uffff"+
			"\1\101\1\uffff\1\101\2\uffff\1\105\4\uffff\1\105\1\uffff\1\102\1\uffff"+
			"\1\105\1\uffff\1\105\1\103\2\uffff\1\105\1\104\32\uffff\2\17\3\uffff"+
			"\1\17\1\uffff\1\17\1\uffff\1\17\3\uffff\2\17\2\uffff\2\17\1\106\1\uffff"+
			"\1\17\2\uffff\4\17\6\uffff\1\105",
			"\1\124\1\uffff\1\124\2\uffff\1\124\1\uffff\1\124\1\uffff\1\123\4\uffff"+
			"\1\124\1\uffff\1\124\2\uffff\1\130\4\uffff\1\130\1\uffff\1\125\1\uffff"+
			"\1\130\1\uffff\1\130\1\126\2\uffff\1\130\1\127\55\uffff\1\131\16\uffff"+
			"\1\130",
			"\1\133\1\uffff\1\133\2\uffff\1\133\1\uffff\1\133\1\uffff\1\132\4\uffff"+
			"\1\133\1\uffff\1\133\2\uffff\1\137\4\uffff\1\137\1\uffff\1\134\1\uffff"+
			"\1\137\1\uffff\1\137\1\135\2\uffff\1\137\1\136\55\uffff\1\140\16\uffff"+
			"\1\137",
			"\1\143\1\uffff\1\143\2\uffff\1\143\1\uffff\1\143\1\uffff\1\142\4\uffff"+
			"\1\143\1\uffff\1\143\2\uffff\1\146\4\uffff\1\146\1\uffff\1\141\1\uffff"+
			"\1\146\1\uffff\1\146\1\144\2\uffff\1\146\1\145\55\uffff\1\147\16\uffff"+
			"\1\146",
			"\1\152\1\uffff\1\152\2\uffff\1\152\1\uffff\1\152\1\uffff\1\151\4\uffff"+
			"\1\152\1\uffff\1\152\2\uffff\1\155\4\uffff\1\155\1\uffff\1\150\1\uffff"+
			"\1\155\1\uffff\1\155\1\153\2\uffff\1\155\1\154\55\uffff\1\156\16\uffff"+
			"\1\155",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff"
	};

	static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
	static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
	static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
	static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
	static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
	static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
	static final short[][] DFA52_transition;

	static {
		int numStates = DFA52_transitionS.length;
		DFA52_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
		}
	}

	protected class DFA52 extends DFA {

		public DFA52(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 52;
			this.eot = DFA52_eot;
			this.eof = DFA52_eof;
			this.min = DFA52_min;
			this.max = DFA52_max;
			this.accept = DFA52_accept;
			this.special = DFA52_special;
			this.transition = DFA52_transition;
		}
		@Override
		public String getDescription() {
			return "374:1: assignment_expression : ( lvalue assignment_operator assignment_expression | conditional_expression );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA52_8 = input.LA(1);
						 
						int index52_8 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_8);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA52_9 = input.LA(1);
						 
						int index52_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_9);
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA52_10 = input.LA(1);
						 
						int index52_10 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_10);
						if ( s>=0 ) return s;
						break;
					case 3 : 
						int LA52_11 = input.LA(1);
						 
						int index52_11 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_11);
						if ( s>=0 ) return s;
						break;
					case 4 : 
						int LA52_12 = input.LA(1);
						 
						int index52_12 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_12);
						if ( s>=0 ) return s;
						break;
					case 5 : 
						int LA52_13 = input.LA(1);
						 
						int index52_13 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_13);
						if ( s>=0 ) return s;
						break;
					case 6 : 
						int LA52_36 = input.LA(1);
						 
						int index52_36 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_36);
						if ( s>=0 ) return s;
						break;
					case 7 : 
						int LA52_37 = input.LA(1);
						 
						int index52_37 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_37);
						if ( s>=0 ) return s;
						break;
					case 8 : 
						int LA52_38 = input.LA(1);
						 
						int index52_38 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_38);
						if ( s>=0 ) return s;
						break;
					case 9 : 
						int LA52_39 = input.LA(1);
						 
						int index52_39 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_39);
						if ( s>=0 ) return s;
						break;
					case 10 : 
						int LA52_40 = input.LA(1);
						 
						int index52_40 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_40);
						if ( s>=0 ) return s;
						break;
					case 11 : 
						int LA52_41 = input.LA(1);
						 
						int index52_41 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_41);
						if ( s>=0 ) return s;
						break;
					case 12 : 
						int LA52_64 = input.LA(1);
						 
						int index52_64 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_64);
						if ( s>=0 ) return s;
						break;
					case 13 : 
						int LA52_65 = input.LA(1);
						 
						int index52_65 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_65);
						if ( s>=0 ) return s;
						break;
					case 14 : 
						int LA52_66 = input.LA(1);
						 
						int index52_66 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_66);
						if ( s>=0 ) return s;
						break;
					case 15 : 
						int LA52_67 = input.LA(1);
						 
						int index52_67 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_67);
						if ( s>=0 ) return s;
						break;
					case 16 : 
						int LA52_68 = input.LA(1);
						 
						int index52_68 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_68);
						if ( s>=0 ) return s;
						break;
					case 17 : 
						int LA52_69 = input.LA(1);
						 
						int index52_69 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_69);
						if ( s>=0 ) return s;
						break;
					case 18 : 
						int LA52_70 = input.LA(1);
						 
						int index52_70 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_70);
						if ( s>=0 ) return s;
						break;
					case 19 : 
						int LA52_83 = input.LA(1);
						 
						int index52_83 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_83);
						if ( s>=0 ) return s;
						break;
					case 20 : 
						int LA52_84 = input.LA(1);
						 
						int index52_84 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_84);
						if ( s>=0 ) return s;
						break;
					case 21 : 
						int LA52_85 = input.LA(1);
						 
						int index52_85 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_85);
						if ( s>=0 ) return s;
						break;
					case 22 : 
						int LA52_86 = input.LA(1);
						 
						int index52_86 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_86);
						if ( s>=0 ) return s;
						break;
					case 23 : 
						int LA52_87 = input.LA(1);
						 
						int index52_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_87);
						if ( s>=0 ) return s;
						break;
					case 24 : 
						int LA52_88 = input.LA(1);
						 
						int index52_88 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_88);
						if ( s>=0 ) return s;
						break;
					case 25 : 
						int LA52_89 = input.LA(1);
						 
						int index52_89 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_89);
						if ( s>=0 ) return s;
						break;
					case 26 : 
						int LA52_90 = input.LA(1);
						 
						int index52_90 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_90);
						if ( s>=0 ) return s;
						break;
					case 27 : 
						int LA52_91 = input.LA(1);
						 
						int index52_91 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_91);
						if ( s>=0 ) return s;
						break;
					case 28 : 
						int LA52_92 = input.LA(1);
						 
						int index52_92 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_92);
						if ( s>=0 ) return s;
						break;
					case 29 : 
						int LA52_93 = input.LA(1);
						 
						int index52_93 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_93);
						if ( s>=0 ) return s;
						break;
					case 30 : 
						int LA52_94 = input.LA(1);
						 
						int index52_94 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_94);
						if ( s>=0 ) return s;
						break;
					case 31 : 
						int LA52_95 = input.LA(1);
						 
						int index52_95 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_95);
						if ( s>=0 ) return s;
						break;
					case 32 : 
						int LA52_96 = input.LA(1);
						 
						int index52_96 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_96);
						if ( s>=0 ) return s;
						break;
					case 33 : 
						int LA52_97 = input.LA(1);
						 
						int index52_97 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_97);
						if ( s>=0 ) return s;
						break;
					case 34 : 
						int LA52_98 = input.LA(1);
						 
						int index52_98 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_98);
						if ( s>=0 ) return s;
						break;
					case 35 : 
						int LA52_99 = input.LA(1);
						 
						int index52_99 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_99);
						if ( s>=0 ) return s;
						break;
					case 36 : 
						int LA52_100 = input.LA(1);
						 
						int index52_100 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_100);
						if ( s>=0 ) return s;
						break;
					case 37 : 
						int LA52_101 = input.LA(1);
						 
						int index52_101 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_101);
						if ( s>=0 ) return s;
						break;
					case 38 : 
						int LA52_102 = input.LA(1);
						 
						int index52_102 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_102);
						if ( s>=0 ) return s;
						break;
					case 39 : 
						int LA52_103 = input.LA(1);
						 
						int index52_103 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_103);
						if ( s>=0 ) return s;
						break;
					case 40 : 
						int LA52_104 = input.LA(1);
						 
						int index52_104 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_104);
						if ( s>=0 ) return s;
						break;
					case 41 : 
						int LA52_105 = input.LA(1);
						 
						int index52_105 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_105);
						if ( s>=0 ) return s;
						break;
					case 42 : 
						int LA52_106 = input.LA(1);
						 
						int index52_106 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_106);
						if ( s>=0 ) return s;
						break;
					case 43 : 
						int LA52_107 = input.LA(1);
						 
						int index52_107 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_107);
						if ( s>=0 ) return s;
						break;
					case 44 : 
						int LA52_108 = input.LA(1);
						 
						int index52_108 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_108);
						if ( s>=0 ) return s;
						break;
					case 45 : 
						int LA52_109 = input.LA(1);
						 
						int index52_109 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_109);
						if ( s>=0 ) return s;
						break;
					case 46 : 
						int LA52_110 = input.LA(1);
						 
						int index52_110 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred104_C()) ) {s = 14;}
						else if ( (true) ) {s = 15;}
						 
						input.seek(index52_110);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 52, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA64_eotS =
		"\112\uffff";
	static final String DFA64_eofS =
		"\112\uffff";
	static final String DFA64_minS =
		"\1\4\1\15\44\uffff\1\0\5\uffff\1\0\16\uffff\1\0\16\uffff";
	static final String DFA64_maxS =
		"\1\144\1\142\44\uffff\1\0\5\uffff\1\0\16\uffff\1\0\16\uffff";
	static final String DFA64_acceptS =
		"\2\uffff\1\2\23\uffff\1\1\63\uffff";
	static final String DFA64_specialS =
		"\46\uffff\1\0\5\uffff\1\1\16\uffff\1\2\16\uffff}>";
	static final String[] DFA64_transitionS = {
			"\1\2\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\1\4\uffff\1\2\1\uffff"+
			"\1\2\2\uffff\1\2\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\2\2\2\uffff"+
			"\2\2\7\uffff\1\2\17\uffff\1\26\2\2\2\26\3\2\1\26\1\uffff\3\26\3\2\3\26"+
			"\1\2\2\26\1\2\2\26\1\2\5\26\2\2\3\uffff\2\2",
			"\1\26\12\uffff\6\2\1\46\1\uffff\1\54\12\2\1\uffff\3\2\1\73\14\2\1\uffff"+
			"\2\2\1\26\2\uffff\2\26\3\uffff\1\26\1\uffff\3\26\3\uffff\3\26\1\uffff"+
			"\2\26\1\uffff\2\26\2\uffff\4\26\2\uffff\3\2",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA64_eot = DFA.unpackEncodedString(DFA64_eotS);
	static final short[] DFA64_eof = DFA.unpackEncodedString(DFA64_eofS);
	static final char[] DFA64_min = DFA.unpackEncodedStringToUnsignedChars(DFA64_minS);
	static final char[] DFA64_max = DFA.unpackEncodedStringToUnsignedChars(DFA64_maxS);
	static final short[] DFA64_accept = DFA.unpackEncodedString(DFA64_acceptS);
	static final short[] DFA64_special = DFA.unpackEncodedString(DFA64_specialS);
	static final short[][] DFA64_transition;

	static {
		int numStates = DFA64_transitionS.length;
		DFA64_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA64_transition[i] = DFA.unpackEncodedString(DFA64_transitionS[i]);
		}
	}

	protected class DFA64 extends DFA {

		public DFA64(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 64;
			this.eot = DFA64_eot;
			this.eof = DFA64_eof;
			this.min = DFA64_min;
			this.max = DFA64_max;
			this.accept = DFA64_accept;
			this.special = DFA64_special;
			this.transition = DFA64_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 454:8: ( declaration )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA64_38 = input.LA(1);
						 
						int index64_38 = input.index();
						input.rewind();
						s = -1;
						if ( (((isTypeName(input.LT(1).getText()))&&synpred136_C())) ) {s = 22;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index64_38);
						if ( s>=0 ) return s;
						break;
					case 1 : 
						int LA64_44 = input.LA(1);
						 
						int index64_44 = input.index();
						input.rewind();
						s = -1;
						if ( (((isTypeName(input.LT(1).getText()))&&synpred136_C())) ) {s = 22;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index64_44);
						if ( s>=0 ) return s;
						break;
					case 2 : 
						int LA64_59 = input.LA(1);
						 
						int index64_59 = input.index();
						input.rewind();
						s = -1;
						if ( (((isTypeName(input.LT(1).getText()))&&synpred136_C())) ) {s = 22;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index64_59);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 64, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_external_declaration_in_translation_unit85 = new BitSet(new long[]{0x8000000140002002L,0x000000003EDB8E8CL});
	public static final BitSet FOLLOW_function_definition_in_external_declaration121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_external_declaration126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_function_definition148 = new BitSet(new long[]{0x0000000140002000L});
	public static final BitSet FOLLOW_declarator_in_function_definition151 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
	public static final BitSet FOLLOW_declaration_in_function_definition157 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
	public static final BitSet FOLLOW_compound_statement_in_function_definition160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_statement_in_function_definition167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_89_in_declaration195 = new BitSet(new long[]{0x8000000140002000L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_declaration_specifiers_in_declaration197 = new BitSet(new long[]{0x0000000140002000L});
	public static final BitSet FOLLOW_init_declarator_list_in_declaration205 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_declaration207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_declaration213 = new BitSet(new long[]{0x0000800140002000L});
	public static final BitSet FOLLOW_init_declarator_list_in_declaration215 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_declaration218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_storage_class_specifier_in_declaration_specifiers235 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_type_specifier_in_declaration_specifiers243 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_type_qualifier_in_declaration_specifiers257 = new BitSet(new long[]{0x8000000000002002L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_init_declarator_in_init_declarator_list279 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_init_declarator_list282 = new BitSet(new long[]{0x0000000140002000L});
	public static final BitSet FOLLOW_init_declarator_in_init_declarator_list284 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_declarator_in_init_declarator297 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_52_in_init_declarator300 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
	public static final BitSet FOLLOW_initializer_in_init_declarator302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_92_in_type_specifier341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_66_in_type_specifier346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_type_specifier351 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_type_specifier356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_80_in_type_specifier361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_75_in_type_specifier366 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_type_specifier371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_type_specifier376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_type_specifier381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_struct_or_union_specifier_in_type_specifier386 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enum_specifier_in_type_specifier391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_id_in_type_specifier396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_type_id414 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_struct_or_union_in_struct_or_union_specifier447 = new BitSet(new long[]{0x0000000000002000L,0x0000000080000000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_specifier449 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_struct_or_union_specifier452 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_struct_declaration_list_in_struct_or_union_specifier454 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_struct_or_union_specifier456 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_struct_or_union_in_struct_or_union_specifier461 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_struct_or_union_specifier463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_struct_declaration_in_struct_declaration_list490 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_specifier_qualifier_list_in_struct_declaration502 = new BitSet(new long[]{0x0000400140002000L});
	public static final BitSet FOLLOW_struct_declarator_list_in_struct_declaration504 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_struct_declaration506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_qualifier_in_specifier_qualifier_list519 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_type_specifier_in_specifier_qualifier_list523 = new BitSet(new long[]{0x0000000000002002L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list537 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_struct_declarator_list540 = new BitSet(new long[]{0x0000400140002000L});
	public static final BitSet FOLLOW_struct_declarator_in_struct_declarator_list542 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_declarator_in_struct_declarator555 = new BitSet(new long[]{0x0000400000000002L});
	public static final BitSet FOLLOW_46_in_struct_declarator558 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_struct_declarator560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_46_in_struct_declarator567 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_struct_declarator569 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_enum_specifier587 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_enum_specifier589 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_enumerator_list_in_enum_specifier591 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_enum_specifier593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_enum_specifier598 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_enum_specifier600 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_enum_specifier602 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_enumerator_list_in_enum_specifier604 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_enum_specifier606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_73_in_enum_specifier611 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_enum_specifier613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enumerator_in_enumerator_list624 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_enumerator_list627 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_enumerator_in_enumerator_list629 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_enumerator642 = new BitSet(new long[]{0x0010000000000002L});
	public static final BitSet FOLLOW_52_in_enumerator645 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_enumerator647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointer_in_declarator676 = new BitSet(new long[]{0x0000000040002000L});
	public static final BitSet FOLLOW_direct_declarator_in_declarator679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointer_in_declarator684 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_direct_declarator699 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_30_in_direct_declarator710 = new BitSet(new long[]{0x0000000140002000L});
	public static final BitSet FOLLOW_declarator_in_direct_declarator712 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_direct_declarator714 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_declarator_suffix_in_direct_declarator728 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_59_in_declarator_suffix742 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_declarator_suffix744 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_declarator_suffix746 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_declarator_suffix756 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_declarator_suffix758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_declarator_suffix768 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_parameter_type_list_in_declarator_suffix770 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_declarator_suffix772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_declarator_suffix782 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_identifier_list_in_declarator_suffix784 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_declarator_suffix786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_declarator_suffix796 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_declarator_suffix798 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_pointer809 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000008L});
	public static final BitSet FOLLOW_type_qualifier_in_pointer811 = new BitSet(new long[]{0x0000000100000002L,0x0000000020000008L});
	public static final BitSet FOLLOW_pointer_in_pointer814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_pointer820 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_pointer_in_pointer822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_pointer827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_list_in_parameter_type_list838 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_parameter_type_list841 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_parameter_type_list843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parameter_declaration_in_parameter_list856 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_parameter_list859 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_parameter_declaration_in_parameter_list861 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_parameter_declaration874 = new BitSet(new long[]{0x0800000140002002L});
	public static final BitSet FOLLOW_declarator_in_parameter_declaration877 = new BitSet(new long[]{0x0800000140002002L});
	public static final BitSet FOLLOW_abstract_declarator_in_parameter_declaration879 = new BitSet(new long[]{0x0800000140002002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_identifier_list892 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_identifier_list895 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_identifier_list897 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_specifier_qualifier_list_in_type_name910 = new BitSet(new long[]{0x0800000140000002L});
	public static final BitSet FOLLOW_abstract_declarator_in_type_name912 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointer_in_abstract_declarator924 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_direct_abstract_declarator_in_abstract_declarator926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_direct_abstract_declarator_in_abstract_declarator932 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_direct_abstract_declarator945 = new BitSet(new long[]{0x0800000140000000L});
	public static final BitSet FOLLOW_abstract_declarator_in_direct_abstract_declarator947 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_direct_abstract_declarator949 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator953 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_abstract_declarator_suffix_in_direct_abstract_declarator957 = new BitSet(new long[]{0x0800000040000002L});
	public static final BitSet FOLLOW_59_in_abstract_declarator_suffix969 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_abstract_declarator_suffix971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_59_in_abstract_declarator_suffix976 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_abstract_declarator_suffix978 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_abstract_declarator_suffix980 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_abstract_declarator_suffix985 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_abstract_declarator_suffix987 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_abstract_declarator_suffix992 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_parameter_type_list_in_abstract_declarator_suffix994 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_abstract_declarator_suffix996 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_expression_in_initializer1008 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_95_in_initializer1013 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
	public static final BitSet FOLLOW_initializer_list_in_initializer1015 = new BitSet(new long[]{0x0000002000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_37_in_initializer1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_initializer1020 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_initializer_in_initializer_list1031 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_initializer_list1034 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001080200000L});
	public static final BitSet FOLLOW_initializer_in_initializer_list1036 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1053 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_argument_expression_list1056 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_assignment_expression_in_argument_expression_list1058 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1072 = new BitSet(new long[]{0x0000004400000002L});
	public static final BitSet FOLLOW_34_in_additive_expression1076 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1078 = new BitSet(new long[]{0x0000004400000002L});
	public static final BitSet FOLLOW_38_in_additive_expression1082 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_multiplicative_expression_in_additive_expression1084 = new BitSet(new long[]{0x0000004400000002L});
	public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1098 = new BitSet(new long[]{0x0000100102000002L});
	public static final BitSet FOLLOW_32_in_multiplicative_expression1102 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1104 = new BitSet(new long[]{0x0000100102000002L});
	public static final BitSet FOLLOW_44_in_multiplicative_expression1108 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1110 = new BitSet(new long[]{0x0000100102000002L});
	public static final BitSet FOLLOW_25_in_multiplicative_expression1114 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_multiplicative_expression1116 = new BitSet(new long[]{0x0000100102000002L});
	public static final BitSet FOLLOW_30_in_cast_expression1129 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_type_name_in_cast_expression1131 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_cast_expression1133 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_cast_expression1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_expression_in_cast_expression1140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_postfix_expression_in_unary_expression1151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_unary_expression1156 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_unary_expression_in_unary_expression1158 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_unary_expression1163 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_unary_expression_in_unary_expression1165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_operator_in_unary_expression1170 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_unary_expression1172 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_unary_expression1177 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_unary_expression_in_unary_expression1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_unary_expression1184 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_unary_expression1186 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_type_name_in_unary_expression1188 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_unary_expression1190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_expression_in_postfix_expression1203 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_59_in_postfix_expression1217 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_postfix_expression1219 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_60_in_postfix_expression1221 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_30_in_postfix_expression1235 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_postfix_expression1237 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_30_in_postfix_expression1251 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_argument_expression_list_in_postfix_expression1253 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_postfix_expression1255 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_42_in_postfix_expression1269 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_postfix_expression1271 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_41_in_postfix_expression1285 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_postfix_expression1287 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_35_in_postfix_expression1301 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_39_in_postfix_expression1315 = new BitSet(new long[]{0x0800068840000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_primary_expression1373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constant_in_primary_expression1378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_primary_expression1383 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_primary_expression1385 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_primary_expression1387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_expression_in_expression1462 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_37_in_expression1465 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_assignment_expression_in_expression1467 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_conditional_expression_in_constant_expression1480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_assignment_expression1491 = new BitSet(new long[]{0x4214211224000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_assignment_operator_in_assignment_expression1493 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_assignment_expression_in_assignment_expression1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditional_expression_in_assignment_expression1500 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_expression_in_lvalue1512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_or_expression_in_conditional_expression1584 = new BitSet(new long[]{0x0400000000000002L});
	public static final BitSet FOLLOW_58_in_conditional_expression1587 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_conditional_expression1589 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_conditional_expression1591 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_conditional_expression_in_conditional_expression1593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1606 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_98_in_logical_or_expression1609 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_logical_and_expression_in_logical_or_expression1611 = new BitSet(new long[]{0x0000000000000002L,0x0000000400000000L});
	public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1624 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_27_in_logical_and_expression1627 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_inclusive_or_expression_in_logical_and_expression1629 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1642 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
	public static final BitSet FOLLOW_96_in_inclusive_or_expression1645 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_exclusive_or_expression_in_inclusive_or_expression1647 = new BitSet(new long[]{0x0000000000000002L,0x0000000100000000L});
	public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression1660 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_61_in_exclusive_or_expression1663 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_and_expression_in_exclusive_or_expression1665 = new BitSet(new long[]{0x2000000000000002L});
	public static final BitSet FOLLOW_equality_expression_in_and_expression1678 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_and_expression1681 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_equality_expression_in_and_expression1683 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_relational_expression_in_equality_expression1695 = new BitSet(new long[]{0x0020000001000002L});
	public static final BitSet FOLLOW_set_in_equality_expression1698 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_relational_expression_in_equality_expression1704 = new BitSet(new long[]{0x0020000001000002L});
	public static final BitSet FOLLOW_shift_expression_in_relational_expression1717 = new BitSet(new long[]{0x00C9000000000002L});
	public static final BitSet FOLLOW_set_in_relational_expression1720 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_shift_expression_in_relational_expression1730 = new BitSet(new long[]{0x00C9000000000002L});
	public static final BitSet FOLLOW_additive_expression_in_shift_expression1743 = new BitSet(new long[]{0x0102000000000002L});
	public static final BitSet FOLLOW_set_in_shift_expression1746 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_additive_expression_in_shift_expression1752 = new BitSet(new long[]{0x0102000000000002L});
	public static final BitSet FOLLOW_labeled_statement_in_statement1767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_compound_statement_in_statement1772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_statement_in_statement1777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selection_statement_in_statement1782 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_iteration_statement_in_statement1787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_jump_statement_in_statement1792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_labeled_statement1803 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_labeled_statement1805 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_labeled_statement1807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_65_in_labeled_statement1812 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_constant_expression_in_labeled_statement1814 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_labeled_statement1816 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_labeled_statement1818 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_69_in_labeled_statement1823 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_labeled_statement1825 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_labeled_statement1827 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_95_in_compound_statement1849 = new BitSet(new long[]{0x800080CD50942A50L,0x00000018FFFFFEFFL});
	public static final BitSet FOLLOW_declaration_in_compound_statement1851 = new BitSet(new long[]{0x800080CD50942A50L,0x00000018FFFFFEFFL});
	public static final BitSet FOLLOW_statement_list_in_compound_statement1854 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_compound_statement1857 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_statement_in_statement_list1868 = new BitSet(new long[]{0x000080CD50942A52L,0x00000010C1247073L});
	public static final BitSet FOLLOW_47_in_expression_statement1880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_expression_statement1885 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_expression_statement1887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_selection_statement1898 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_selection_statement1900 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_selection_statement1902 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_selection_statement1904 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_selection_statement1906 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
	public static final BitSet FOLLOW_72_in_selection_statement1921 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_selection_statement1923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_selection_statement1930 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_selection_statement1932 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_selection_statement1934 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_selection_statement1936 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_selection_statement1938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_94_in_iteration_statement1949 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_iteration_statement1951 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_iteration_statement1953 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_iteration_statement1955 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_iteration_statement1957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_70_in_iteration_statement1962 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_iteration_statement1964 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_94_in_iteration_statement1966 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_iteration_statement1968 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_iteration_statement1970 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_iteration_statement1972 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_iteration_statement1974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_iteration_statement1979 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_iteration_statement1981 = new BitSet(new long[]{0x000080CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_statement_in_iteration_statement1983 = new BitSet(new long[]{0x000080CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_statement_in_iteration_statement1985 = new BitSet(new long[]{0x000000CDD0942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_iteration_statement1987 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_iteration_statement1990 = new BitSet(new long[]{0x000080CD50942A50L,0x00000010C1247073L});
	public static final BitSet FOLLOW_statement_in_iteration_statement1992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_jump_statement2003 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_IDENTIFIER_in_jump_statement2005 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_jump_statement2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_68_in_jump_statement2012 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_jump_statement2014 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_64_in_jump_statement2019 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_jump_statement2021 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_jump_statement2026 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_jump_statement2028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_jump_statement2033 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_expression_in_jump_statement2035 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_jump_statement2037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_synpred2_C108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_synpred4_C108 = new BitSet(new long[]{0x0000000140002000L});
	public static final BitSet FOLLOW_declarator_in_synpred4_C111 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
	public static final BitSet FOLLOW_declaration_in_synpred4_C113 = new BitSet(new long[]{0x8000000000002000L,0x00000000BEDB8E8CL});
	public static final BitSet FOLLOW_95_in_synpred4_C116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_synpred5_C148 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_specifiers_in_synpred8_C197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_specifier_in_synpred12_C243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_specifier_in_synpred35_C523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointer_in_synpred45_C676 = new BitSet(new long[]{0x0000000040002000L});
	public static final BitSet FOLLOW_direct_declarator_in_synpred45_C679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarator_suffix_in_synpred47_C728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred50_C768 = new BitSet(new long[]{0x8000000000002000L,0x000000003CDB8E8CL});
	public static final BitSet FOLLOW_parameter_type_list_in_synpred50_C770 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred50_C772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred51_C782 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_identifier_list_in_synpred51_C784 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred51_C786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_type_qualifier_in_synpred52_C811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pointer_in_synpred53_C814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_synpred54_C809 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000008L});
	public static final BitSet FOLLOW_type_qualifier_in_synpred54_C811 = new BitSet(new long[]{0x0000000100000002L,0x0000000020000008L});
	public static final BitSet FOLLOW_pointer_in_synpred54_C814 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_synpred55_C820 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_pointer_in_synpred55_C822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declarator_in_synpred58_C877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abstract_declarator_in_synpred59_C879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_direct_abstract_declarator_in_synpred62_C926 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abstract_declarator_suffix_in_synpred65_C957 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_synpred78_C1129 = new BitSet(new long[]{0x0000000000002000L,0x000000003C998A8CL});
	public static final BitSet FOLLOW_type_name_in_synpred78_C1131 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_synpred78_C1133 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_cast_expression_in_synpred78_C1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_85_in_synpred83_C1177 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_unary_expression_in_synpred83_C1179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lvalue_in_synpred104_C1491 = new BitSet(new long[]{0x4214211224000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_assignment_operator_in_synpred104_C1493 = new BitSet(new long[]{0x000000CD50942A50L,0x0000001000200000L});
	public static final BitSet FOLLOW_assignment_expression_in_synpred104_C1495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_synpred136_C1851 = new BitSet(new long[]{0x0000000000000002L});
}
