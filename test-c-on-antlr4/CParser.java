// Generated from C.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Auto=15, Break=16, Case=17, 
		Char=18, Const=19, Continue=20, Default=21, Do=22, Double=23, Else=24, 
		Enum=25, Extern=26, Float=27, For=28, Goto=29, If=30, Inline=31, Int=32, 
		Long=33, Register=34, Restrict=35, Return=36, Short=37, Signed=38, Sizeof=39, 
		Static=40, Struct=41, Switch=42, Typedef=43, Union=44, Unsigned=45, Void=46, 
		Volatile=47, While=48, Alignas=49, Alignof=50, Atomic=51, Bool=52, Complex=53, 
		Generic=54, Imaginary=55, Noreturn=56, StaticAssert=57, ThreadLocal=58, 
		LeftParen=59, RightParen=60, LeftBracket=61, RightBracket=62, LeftBrace=63, 
		RightBrace=64, Less=65, LessEqual=66, Greater=67, GreaterEqual=68, LeftShift=69, 
		RightShift=70, Plus=71, PlusPlus=72, Minus=73, MinusMinus=74, Star=75, 
		Div=76, Mod=77, And=78, Or=79, AndAnd=80, OrOr=81, Caret=82, Not=83, Tilde=84, 
		Question=85, Colon=86, Semi=87, Comma=88, Assign=89, StarAssign=90, DivAssign=91, 
		ModAssign=92, PlusAssign=93, MinusAssign=94, LeftShiftAssign=95, RightShiftAssign=96, 
		AndAssign=97, XorAssign=98, OrAssign=99, Equal=100, NotEqual=101, Arrow=102, 
		Dot=103, Ellipsis=104, Identifier=105, Constant=106, StringLiteral=107, 
		LineDirective=108, PragmaDirective=109, Whitespace=110, Newline=111, BlockComment=112, 
		LineComment=113;
	public static final int
		RULE_primaryExpression = 0, RULE_genericSelection = 1, RULE_genericAssocList = 2, 
		RULE_genericAssociation = 3, RULE_postfixExpression = 4, RULE_argumentExpressionList = 5, 
		RULE_unaryExpression = 6, RULE_unaryOperator = 7, RULE_castExpression = 8, 
		RULE_multiplicativeExpression = 9, RULE_additiveExpression = 10, RULE_shiftExpression = 11, 
		RULE_relationalExpression = 12, RULE_equalityExpression = 13, RULE_andExpression = 14, 
		RULE_exclusiveOrExpression = 15, RULE_inclusiveOrExpression = 16, RULE_logicalAndExpression = 17, 
		RULE_logicalOrExpression = 18, RULE_conditionalExpression = 19, RULE_assignmentExpression = 20, 
		RULE_assignmentOperator = 21, RULE_expression = 22, RULE_constantExpression = 23, 
		RULE_declaration = 24, RULE_declarationSpecifiers = 25, RULE_declarationSpecifiers2 = 26, 
		RULE_declarationSpecifier = 27, RULE_initDeclaratorList = 28, RULE_initDeclarator = 29, 
		RULE_storageClassSpecifier = 30, RULE_typeSpecifier = 31, RULE_structOrUnionSpecifier = 32, 
		RULE_structOrUnion = 33, RULE_structDeclarationList = 34, RULE_structDeclaration = 35, 
		RULE_specifierQualifierList = 36, RULE_structDeclaratorList = 37, RULE_structDeclarator = 38, 
		RULE_enumSpecifier = 39, RULE_enumeratorList = 40, RULE_enumerator = 41, 
		RULE_enumerationConstant = 42, RULE_atomicTypeSpecifier = 43, RULE_typeQualifier = 44, 
		RULE_functionSpecifier = 45, RULE_alignmentSpecifier = 46, RULE_declarator = 47, 
		RULE_directDeclarator = 48, RULE_gccDeclaratorExtension = 49, RULE_gccAttributeSpecifier = 50, 
		RULE_gccAttributeList = 51, RULE_gccAttribute = 52, RULE_nestedParenthesesBlock = 53, 
		RULE_pointer = 54, RULE_typeQualifierList = 55, RULE_parameterTypeList = 56, 
		RULE_parameterList = 57, RULE_parameterDeclaration = 58, RULE_identifierList = 59, 
		RULE_typeName = 60, RULE_abstractDeclarator = 61, RULE_directAbstractDeclarator = 62, 
		RULE_typedefName = 63, RULE_initializer = 64, RULE_initializerList = 65, 
		RULE_designation = 66, RULE_designatorList = 67, RULE_designator = 68, 
		RULE_staticAssertDeclaration = 69, RULE_statement = 70, RULE_labeledStatement = 71, 
		RULE_compoundStatement = 72, RULE_blockItemList = 73, RULE_blockItem = 74, 
		RULE_expressionStatement = 75, RULE_selectionStatement = 76, RULE_iterationStatement = 77, 
		RULE_jumpStatement = 78, RULE_compilationUnit = 79, RULE_translationUnit = 80, 
		RULE_externalDeclaration = 81, RULE_functionDefinition = 82, RULE_declarationList = 83;
	public static final String[] ruleNames = {
		"primaryExpression", "genericSelection", "genericAssocList", "genericAssociation", 
		"postfixExpression", "argumentExpressionList", "unaryExpression", "unaryOperator", 
		"castExpression", "multiplicativeExpression", "additiveExpression", "shiftExpression", 
		"relationalExpression", "equalityExpression", "andExpression", "exclusiveOrExpression", 
		"inclusiveOrExpression", "logicalAndExpression", "logicalOrExpression", 
		"conditionalExpression", "assignmentExpression", "assignmentOperator", 
		"expression", "constantExpression", "declaration", "declarationSpecifiers", 
		"declarationSpecifiers2", "declarationSpecifier", "initDeclaratorList", 
		"initDeclarator", "storageClassSpecifier", "typeSpecifier", "structOrUnionSpecifier", 
		"structOrUnion", "structDeclarationList", "structDeclaration", "specifierQualifierList", 
		"structDeclaratorList", "structDeclarator", "enumSpecifier", "enumeratorList", 
		"enumerator", "enumerationConstant", "atomicTypeSpecifier", "typeQualifier", 
		"functionSpecifier", "alignmentSpecifier", "declarator", "directDeclarator", 
		"gccDeclaratorExtension", "gccAttributeSpecifier", "gccAttributeList", 
		"gccAttribute", "nestedParenthesesBlock", "pointer", "typeQualifierList", 
		"parameterTypeList", "parameterList", "parameterDeclaration", "identifierList", 
		"typeName", "abstractDeclarator", "directAbstractDeclarator", "typedefName", 
		"initializer", "initializerList", "designation", "designatorList", "designator", 
		"staticAssertDeclaration", "statement", "labeledStatement", "compoundStatement", 
		"blockItemList", "blockItem", "expressionStatement", "selectionStatement", 
		"iterationStatement", "jumpStatement", "compilationUnit", "translationUnit", 
		"externalDeclaration", "functionDefinition", "declarationList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'__extension__'", "'__builtin_va_arg'", "'__builtin_offsetof'", 
		"'__m128'", "'__m128d'", "'__m128i'", "'__typeof__'", "'__inline__'", 
		"'__stdcall'", "'__declspec'", "'__asm'", "'__attribute__'", "'__asm__'", 
		"'__volatile__'", "'auto'", "'break'", "'case'", "'char'", "'const'", 
		"'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", "'extern'", 
		"'float'", "'for'", "'goto'", "'if'", "'inline'", "'int'", "'long'", "'register'", 
		"'restrict'", "'return'", "'short'", "'signed'", "'sizeof'", "'static'", 
		"'struct'", "'switch'", "'typedef'", "'union'", "'unsigned'", "'void'", 
		"'volatile'", "'while'", "'_Alignas'", "'_Alignof'", "'_Atomic'", "'_Bool'", 
		"'_Complex'", "'_Generic'", "'_Imaginary'", "'_Noreturn'", "'_Static_assert'", 
		"'_Thread_local'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", 
		"'>'", "'>='", "'<<'", "'>>'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", 
		"'%'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", "'~'", "'?'", "':'", 
		"';'", "','", "'='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", 
		"'>>='", "'&='", "'^='", "'|='", "'=='", "'!='", "'->'", "'.'", "'...'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "Auto", "Break", "Case", "Char", "Const", "Continue", 
		"Default", "Do", "Double", "Else", "Enum", "Extern", "Float", "For", "Goto", 
		"If", "Inline", "Int", "Long", "Register", "Restrict", "Return", "Short", 
		"Signed", "Sizeof", "Static", "Struct", "Switch", "Typedef", "Union", 
		"Unsigned", "Void", "Volatile", "While", "Alignas", "Alignof", "Atomic", 
		"Bool", "Complex", "Generic", "Imaginary", "Noreturn", "StaticAssert", 
		"ThreadLocal", "LeftParen", "RightParen", "LeftBracket", "RightBracket", 
		"LeftBrace", "RightBrace", "Less", "LessEqual", "Greater", "GreaterEqual", 
		"LeftShift", "RightShift", "Plus", "PlusPlus", "Minus", "MinusMinus", 
		"Star", "Div", "Mod", "And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", 
		"Question", "Colon", "Semi", "Comma", "Assign", "StarAssign", "DivAssign", 
		"ModAssign", "PlusAssign", "MinusAssign", "LeftShiftAssign", "RightShiftAssign", 
		"AndAssign", "XorAssign", "OrAssign", "Equal", "NotEqual", "Arrow", "Dot", 
		"Ellipsis", "Identifier", "Constant", "StringLiteral", "LineDirective", 
		"PragmaDirective", "Whitespace", "Newline", "BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private final Scope typeDefScope = new Scope();

	public CParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(CParser.Constant, 0); }
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GenericSelectionContext genericSelection() {
			return getRuleContext(GenericSelectionContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPrimaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPrimaryExpression(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_primaryExpression);
		int _la;
		try {
			int _alt;
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(Constant);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(170);
						match(StringLiteral);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(173); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				match(LeftParen);
				setState(176);
				expression(0);
				setState(177);
				match(RightParen);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(179);
				genericSelection();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(180);
					match(T__0);
					}
				}

				setState(183);
				match(LeftParen);
				setState(184);
				compoundStatement();
				setState(185);
				match(RightParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(T__1);
				setState(188);
				match(LeftParen);
				setState(189);
				unaryExpression();
				setState(190);
				match(Comma);
				setState(191);
				typeName();
				setState(192);
				match(RightParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(194);
				match(T__2);
				setState(195);
				match(LeftParen);
				setState(196);
				typeName();
				setState(197);
				match(Comma);
				setState(198);
				unaryExpression();
				setState(199);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericSelectionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public GenericAssocListContext genericAssocList() {
			return getRuleContext(GenericAssocListContext.class,0);
		}
		public GenericSelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericSelection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGenericSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGenericSelection(this);
		}
	}

	public final GenericSelectionContext genericSelection() throws RecognitionException {
		GenericSelectionContext _localctx = new GenericSelectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_genericSelection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(Generic);
			setState(204);
			match(LeftParen);
			setState(205);
			assignmentExpression();
			setState(206);
			match(Comma);
			setState(207);
			genericAssocList(0);
			setState(208);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GenericAssocListContext extends ParserRuleContext {
		public GenericAssociationContext genericAssociation() {
			return getRuleContext(GenericAssociationContext.class,0);
		}
		public GenericAssocListContext genericAssocList() {
			return getRuleContext(GenericAssocListContext.class,0);
		}
		public GenericAssocListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericAssocList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGenericAssocList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGenericAssocList(this);
		}
	}

	public final GenericAssocListContext genericAssocList() throws RecognitionException {
		return genericAssocList(0);
	}

	private GenericAssocListContext genericAssocList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GenericAssocListContext _localctx = new GenericAssocListContext(_ctx, _parentState);
		GenericAssocListContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_genericAssocList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(211);
			genericAssociation();
			}
			_ctx.stop = _input.LT(-1);
			setState(218);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GenericAssocListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_genericAssocList);
					setState(213);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(214);
					match(Comma);
					setState(215);
					genericAssociation();
					}
					} 
				}
				setState(220);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GenericAssociationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public GenericAssociationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericAssociation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGenericAssociation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGenericAssociation(this);
		}
	}

	public final GenericAssociationContext genericAssociation() throws RecognitionException {
		GenericAssociationContext _localctx = new GenericAssociationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_genericAssociation);
		try {
			setState(228);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				typeName();
				setState(222);
				match(Colon);
				setState(223);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
				match(Default);
				setState(226);
				match(Colon);
				setState(227);
				assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		return postfixExpression(0);
	}

	private PostfixExpressionContext postfixExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, _parentState);
		PostfixExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_postfixExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(231);
				primaryExpression();
				}
				break;
			case 2:
				{
				setState(232);
				match(LeftParen);
				setState(233);
				typeName();
				setState(234);
				match(RightParen);
				setState(235);
				match(LeftBrace);
				setState(236);
				initializerList(0);
				setState(237);
				match(RightBrace);
				}
				break;
			case 3:
				{
				setState(239);
				match(LeftParen);
				setState(240);
				typeName();
				setState(241);
				match(RightParen);
				setState(242);
				match(LeftBrace);
				setState(243);
				initializerList(0);
				setState(244);
				match(Comma);
				setState(245);
				match(RightBrace);
				}
				break;
			case 4:
				{
				setState(247);
				match(T__0);
				setState(248);
				match(LeftParen);
				setState(249);
				typeName();
				setState(250);
				match(RightParen);
				setState(251);
				match(LeftBrace);
				setState(252);
				initializerList(0);
				setState(253);
				match(RightBrace);
				}
				break;
			case 5:
				{
				setState(255);
				match(T__0);
				setState(256);
				match(LeftParen);
				setState(257);
				typeName();
				setState(258);
				match(RightParen);
				setState(259);
				match(LeftBrace);
				setState(260);
				initializerList(0);
				setState(261);
				match(Comma);
				setState(262);
				match(RightBrace);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(287);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(266);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(267);
						match(LeftBracket);
						setState(268);
						expression(0);
						setState(269);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(271);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(272);
						match(LeftParen);
						setState(274);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(273);
							argumentExpressionList(0);
							}
						}

						setState(276);
						match(RightParen);
						}
						break;
					case 3:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(277);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(278);
						match(Dot);
						setState(279);
						match(Identifier);
						}
						break;
					case 4:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(280);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(281);
						match(Arrow);
						setState(282);
						match(Identifier);
						}
						break;
					case 5:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(283);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(284);
						match(PlusPlus);
						}
						break;
					case 6:
						{
						_localctx = new PostfixExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfixExpression);
						setState(285);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(286);
						match(MinusMinus);
						}
						break;
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentExpressionListContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public ArgumentExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterArgumentExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitArgumentExpressionList(this);
		}
	}

	public final ArgumentExpressionListContext argumentExpressionList() throws RecognitionException {
		return argumentExpressionList(0);
	}

	private ArgumentExpressionListContext argumentExpressionList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentExpressionListContext _localctx = new ArgumentExpressionListContext(_ctx, _parentState);
		ArgumentExpressionListContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_argumentExpressionList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(293);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentExpressionListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_argumentExpressionList);
					setState(295);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(296);
					match(Comma);
					setState(297);
					assignmentExpression();
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unaryExpression);
		try {
			setState(325);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				postfixExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(PlusPlus);
				setState(305);
				unaryExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(MinusMinus);
				setState(307);
				unaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				unaryOperator();
				setState(309);
				castExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(311);
				match(Sizeof);
				setState(312);
				unaryExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(313);
				match(Sizeof);
				setState(314);
				match(LeftParen);
				setState(315);
				typeName();
				setState(316);
				match(RightParen);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(318);
				match(Alignof);
				setState(319);
				match(LeftParen);
				setState(320);
				typeName();
				setState(321);
				match(RightParen);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(323);
				match(AndAnd);
				setState(324);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_la = _input.LA(1);
			if ( !(((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (Minus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_castExpression);
		try {
			setState(341);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				unaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(330);
				match(LeftParen);
				setState(331);
				typeName();
				setState(332);
				match(RightParen);
				setState(333);
				castExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(335);
				match(T__0);
				setState(336);
				match(LeftParen);
				setState(337);
				typeName();
				setState(338);
				match(RightParen);
				setState(339);
				castExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitMultiplicativeExpression(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(344);
			castExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(355);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(346);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(347);
						match(Star);
						setState(348);
						castExpression();
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(349);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(350);
						match(Div);
						setState(351);
						castExpression();
						}
						break;
					case 3:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(352);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(353);
						match(Mod);
						setState(354);
						castExpression();
						}
						break;
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAdditiveExpression(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(361);
			multiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(371);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(369);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(363);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(364);
						match(Plus);
						setState(365);
						multiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(366);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(367);
						match(Minus);
						setState(368);
						multiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ShiftExpressionContext extends ParserRuleContext {
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitShiftExpression(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		return shiftExpression(0);
	}

	private ShiftExpressionContext shiftExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, _parentState);
		ShiftExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_shiftExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(375);
			additiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(383);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(377);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(378);
						match(LeftShift);
						setState(379);
						additiveExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new ShiftExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_shiftExpression);
						setState(380);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(381);
						match(RightShift);
						setState(382);
						additiveExpression(0);
						}
						break;
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public ShiftExpressionContext shiftExpression() {
			return getRuleContext(ShiftExpressionContext.class,0);
		}
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterRelationalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitRelationalExpression(this);
		}
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(389);
			shiftExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(405);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(403);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(391);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(392);
						match(Less);
						setState(393);
						shiftExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(394);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(395);
						match(Greater);
						setState(396);
						shiftExpression(0);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(397);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(398);
						match(LessEqual);
						setState(399);
						shiftExpression(0);
						}
						break;
					case 4:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(400);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(401);
						match(GreaterEqual);
						setState(402);
						shiftExpression(0);
						}
						break;
					}
					} 
				}
				setState(407);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEqualityExpression(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(409);
			relationalExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(419);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(417);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(411);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(412);
						match(Equal);
						setState(413);
						relationalExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new EqualityExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
						setState(414);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(415);
						match(NotEqual);
						setState(416);
						relationalExpression(0);
						}
						break;
					}
					} 
				}
				setState(421);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndExpressionContext extends ParserRuleContext {
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAndExpression(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		return andExpression(0);
	}

	private AndExpressionContext andExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, _parentState);
		AndExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_andExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(423);
			equalityExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_andExpression);
					setState(425);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(426);
					match(And);
					setState(427);
					equalityExpression(0);
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExclusiveOrExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public ExclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExclusiveOrExpression(this);
		}
	}

	public final ExclusiveOrExpressionContext exclusiveOrExpression() throws RecognitionException {
		return exclusiveOrExpression(0);
	}

	private ExclusiveOrExpressionContext exclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExclusiveOrExpressionContext _localctx = new ExclusiveOrExpressionContext(_ctx, _parentState);
		ExclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_exclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(434);
			andExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusiveOrExpression);
					setState(436);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(437);
					match(Caret);
					setState(438);
					andExpression(0);
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InclusiveOrExpressionContext extends ParserRuleContext {
		public ExclusiveOrExpressionContext exclusiveOrExpression() {
			return getRuleContext(ExclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public InclusiveOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInclusiveOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInclusiveOrExpression(this);
		}
	}

	public final InclusiveOrExpressionContext inclusiveOrExpression() throws RecognitionException {
		return inclusiveOrExpression(0);
	}

	private InclusiveOrExpressionContext inclusiveOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InclusiveOrExpressionContext _localctx = new InclusiveOrExpressionContext(_ctx, _parentState);
		InclusiveOrExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_inclusiveOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(445);
			exclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InclusiveOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusiveOrExpression);
					setState(447);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(448);
					match(Or);
					setState(449);
					exclusiveOrExpression(0);
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalAndExpressionContext extends ParserRuleContext {
		public InclusiveOrExpressionContext inclusiveOrExpression() {
			return getRuleContext(InclusiveOrExpressionContext.class,0);
		}
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalAndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLogicalAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLogicalAndExpression(this);
		}
	}

	public final LogicalAndExpressionContext logicalAndExpression() throws RecognitionException {
		return logicalAndExpression(0);
	}

	private LogicalAndExpressionContext logicalAndExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalAndExpressionContext _localctx = new LogicalAndExpressionContext(_ctx, _parentState);
		LogicalAndExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_logicalAndExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(456);
			inclusiveOrExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(463);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalAndExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalAndExpression);
					setState(458);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(459);
					match(AndAnd);
					setState(460);
					inclusiveOrExpression(0);
					}
					} 
				}
				setState(465);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LogicalOrExpressionContext extends ParserRuleContext {
		public LogicalAndExpressionContext logicalAndExpression() {
			return getRuleContext(LogicalAndExpressionContext.class,0);
		}
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public LogicalOrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLogicalOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLogicalOrExpression(this);
		}
	}

	public final LogicalOrExpressionContext logicalOrExpression() throws RecognitionException {
		return logicalOrExpression(0);
	}

	private LogicalOrExpressionContext logicalOrExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalOrExpressionContext _localctx = new LogicalOrExpressionContext(_ctx, _parentState);
		LogicalOrExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_logicalOrExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(467);
			logicalAndExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(474);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalOrExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalOrExpression);
					setState(469);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(470);
					match(OrOr);
					setState(471);
					logicalAndExpression(0);
					}
					} 
				}
				setState(476);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionalExpressionContext extends ParserRuleContext {
		public LogicalOrExpressionContext logicalOrExpression() {
			return getRuleContext(LogicalOrExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitConditionalExpression(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditionalExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			logicalOrExpression(0);
			setState(483);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(478);
				match(Question);
				setState(479);
				expression(0);
				setState(480);
				match(Colon);
				setState(481);
				conditionalExpression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assignmentExpression);
		try {
			setState(490);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				conditionalExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(486);
				unaryExpression();
				setState(487);
				assignmentOperator();
				setState(488);
				assignmentExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			_la = _input.LA(1);
			if ( !(((((_la - 89)) & ~0x3f) == 0 && ((1L << (_la - 89)) & ((1L << (Assign - 89)) | (1L << (StarAssign - 89)) | (1L << (DivAssign - 89)) | (1L << (ModAssign - 89)) | (1L << (PlusAssign - 89)) | (1L << (MinusAssign - 89)) | (1L << (LeftShiftAssign - 89)) | (1L << (RightShiftAssign - 89)) | (1L << (AndAssign - 89)) | (1L << (XorAssign - 89)) | (1L << (OrAssign - 89)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(495);
			assignmentExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(502);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(497);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(498);
					match(Comma);
					setState(499);
					assignmentExpression();
					}
					} 
				}
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ConstantExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterConstantExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitConstantExpression(this);
		}
	}

	public final ConstantExpressionContext constantExpression() throws RecognitionException {
		ConstantExpressionContext _localctx = new ConstantExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constantExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			conditionalExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_declaration);
		 typeDefScope.setTypedef(false); 
		int _la;
		try {
			setState(514);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				declarationSpecifiers();
				setState(509);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)) | (1L << (Identifier - 59)))) != 0)) {
					{
					setState(508);
					initDeclaratorList(0);
					}
				}

				setState(511);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(513);
				staticAssertDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiersContext extends ParserRuleContext {
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarationSpecifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarationSpecifiers(this);
		}
	}

	public final DeclarationSpecifiersContext declarationSpecifiers() throws RecognitionException {
		DeclarationSpecifiersContext _localctx = new DeclarationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_declarationSpecifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(517); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(516);
					declarationSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(519); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifiers2Context extends ParserRuleContext {
		public List<DeclarationSpecifierContext> declarationSpecifier() {
			return getRuleContexts(DeclarationSpecifierContext.class);
		}
		public DeclarationSpecifierContext declarationSpecifier(int i) {
			return getRuleContext(DeclarationSpecifierContext.class,i);
		}
		public DeclarationSpecifiers2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifiers2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarationSpecifiers2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarationSpecifiers2(this);
		}
	}

	public final DeclarationSpecifiers2Context declarationSpecifiers2() throws RecognitionException {
		DeclarationSpecifiers2Context _localctx = new DeclarationSpecifiers2Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_declarationSpecifiers2);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(522); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(521);
					declarationSpecifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(524); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationSpecifierContext extends ParserRuleContext {
		public StorageClassSpecifierContext storageClassSpecifier() {
			return getRuleContext(StorageClassSpecifierContext.class,0);
		}
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public FunctionSpecifierContext functionSpecifier() {
			return getRuleContext(FunctionSpecifierContext.class,0);
		}
		public AlignmentSpecifierContext alignmentSpecifier() {
			return getRuleContext(AlignmentSpecifierContext.class,0);
		}
		public DeclarationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarationSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarationSpecifier(this);
		}
	}

	public final DeclarationSpecifierContext declarationSpecifier() throws RecognitionException {
		DeclarationSpecifierContext _localctx = new DeclarationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_declarationSpecifier);
		try {
			setState(531);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(526);
				storageClassSpecifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(527);
				typeSpecifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(528);
				typeQualifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(529);
				functionSpecifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(530);
				alignmentSpecifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitDeclaratorListContext extends ParserRuleContext {
		public InitDeclaratorContext initDeclarator() {
			return getRuleContext(InitDeclaratorContext.class,0);
		}
		public InitDeclaratorListContext initDeclaratorList() {
			return getRuleContext(InitDeclaratorListContext.class,0);
		}
		public InitDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInitDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInitDeclaratorList(this);
		}
	}

	public final InitDeclaratorListContext initDeclaratorList() throws RecognitionException {
		return initDeclaratorList(0);
	}

	private InitDeclaratorListContext initDeclaratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitDeclaratorListContext _localctx = new InitDeclaratorListContext(_ctx, _parentState);
		InitDeclaratorListContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_initDeclaratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(534);
			initDeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(541);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitDeclaratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initDeclaratorList);
					setState(536);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(537);
					match(Comma);
					setState(538);
					initDeclarator();
					}
					} 
				}
				setState(543);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class InitDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public InitDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInitDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInitDeclarator(this);
		}
	}

	public final InitDeclaratorContext initDeclarator() throws RecognitionException {
		InitDeclaratorContext _localctx = new InitDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_initDeclarator);
		try {
			setState(549);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(545);
				declarator();
				setState(546);
				match(Assign);
				setState(547);
				initializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageClassSpecifierContext extends ParserRuleContext {
		public StorageClassSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageClassSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStorageClassSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStorageClassSpecifier(this);
		}
	}

	public final StorageClassSpecifierContext storageClassSpecifier() throws RecognitionException {
		StorageClassSpecifierContext _localctx = new StorageClassSpecifierContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_storageClassSpecifier);
		try {
			setState(558);
			switch (_input.LA(1)) {
			case Typedef:
				enterOuterAlt(_localctx, 1);
				{
				setState(551);
				match(Typedef);
				 typeDefScope.setTypedef(true); 
				}
				break;
			case Extern:
				enterOuterAlt(_localctx, 2);
				{
				setState(553);
				match(Extern);
				}
				break;
			case Static:
				enterOuterAlt(_localctx, 3);
				{
				setState(554);
				match(Static);
				}
				break;
			case ThreadLocal:
				enterOuterAlt(_localctx, 4);
				{
				setState(555);
				match(ThreadLocal);
				}
				break;
			case Auto:
				enterOuterAlt(_localctx, 5);
				{
				setState(556);
				match(Auto);
				}
				break;
			case Register:
				enterOuterAlt(_localctx, 6);
				{
				setState(557);
				match(Register);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecifierContext extends ParserRuleContext {
		public AtomicTypeSpecifierContext atomicTypeSpecifier() {
			return getRuleContext(AtomicTypeSpecifierContext.class,0);
		}
		public StructOrUnionSpecifierContext structOrUnionSpecifier() {
			return getRuleContext(StructOrUnionSpecifierContext.class,0);
		}
		public EnumSpecifierContext enumSpecifier() {
			return getRuleContext(EnumSpecifierContext.class,0);
		}
		public TypedefNameContext typedefName() {
			return getRuleContext(TypedefNameContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTypeSpecifier(this);
		}
	}

	public final TypeSpecifierContext typeSpecifier() throws RecognitionException {
		TypeSpecifierContext _localctx = new TypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_typeSpecifier);
		int _la;
		try {
			setState(574);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(560);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << Char) | (1L << Double) | (1L << Float) | (1L << Int) | (1L << Long) | (1L << Short) | (1L << Signed) | (1L << Unsigned) | (1L << Void) | (1L << Bool) | (1L << Complex))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(561);
				match(T__0);
				setState(562);
				match(LeftParen);
				setState(563);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(564);
				match(RightParen);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(565);
				atomicTypeSpecifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(566);
				structOrUnionSpecifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(567);
				enumSpecifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(568);
				typedefName();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(569);
				match(T__6);
				setState(570);
				match(LeftParen);
				setState(571);
				constantExpression();
				setState(572);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructOrUnionSpecifierContext extends ParserRuleContext {
		public StructOrUnionContext structOrUnion() {
			return getRuleContext(StructOrUnionContext.class,0);
		}
		public StructDeclarationListContext structDeclarationList() {
			return getRuleContext(StructDeclarationListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public StructOrUnionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnionSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructOrUnionSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructOrUnionSpecifier(this);
		}
	}

	public final StructOrUnionSpecifierContext structOrUnionSpecifier() throws RecognitionException {
		StructOrUnionSpecifierContext _localctx = new StructOrUnionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_structOrUnionSpecifier);
		int _la;
		try {
			setState(587);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				structOrUnion();
				setState(578);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(577);
					match(Identifier);
					}
				}

				setState(580);
				match(LeftBrace);
				setState(581);
				structDeclarationList(0);
				setState(582);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(584);
				structOrUnion();
				setState(585);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructOrUnionContext extends ParserRuleContext {
		public StructOrUnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structOrUnion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructOrUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructOrUnion(this);
		}
	}

	public final StructOrUnionContext structOrUnion() throws RecognitionException {
		StructOrUnionContext _localctx = new StructOrUnionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_structOrUnion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			_la = _input.LA(1);
			if ( !(_la==Struct || _la==Union) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationListContext extends ParserRuleContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public StructDeclarationListContext structDeclarationList() {
			return getRuleContext(StructDeclarationListContext.class,0);
		}
		public StructDeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructDeclarationList(this);
		}
	}

	public final StructDeclarationListContext structDeclarationList() throws RecognitionException {
		return structDeclarationList(0);
	}

	private StructDeclarationListContext structDeclarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StructDeclarationListContext _localctx = new StructDeclarationListContext(_ctx, _parentState);
		StructDeclarationListContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_structDeclarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(592);
			structDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(598);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructDeclarationListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_structDeclarationList);
					setState(594);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(595);
					structDeclaration();
					}
					} 
				}
				setState(600);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public StructDeclaratorListContext structDeclaratorList() {
			return getRuleContext(StructDeclaratorListContext.class,0);
		}
		public StaticAssertDeclarationContext staticAssertDeclaration() {
			return getRuleContext(StaticAssertDeclarationContext.class,0);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructDeclaration(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_structDeclaration);
		int _la;
		try {
			setState(608);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(601);
				specifierQualifierList();
				setState(603);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)) | (1L << (Colon - 59)) | (1L << (Identifier - 59)))) != 0)) {
					{
					setState(602);
					structDeclaratorList(0);
					}
				}

				setState(605);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(607);
				staticAssertDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpecifierQualifierListContext extends ParserRuleContext {
		public TypeSpecifierContext typeSpecifier() {
			return getRuleContext(TypeSpecifierContext.class,0);
		}
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public SpecifierQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specifierQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterSpecifierQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitSpecifierQualifierList(this);
		}
	}

	public final SpecifierQualifierListContext specifierQualifierList() throws RecognitionException {
		SpecifierQualifierListContext _localctx = new SpecifierQualifierListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_specifierQualifierList);
		try {
			setState(618);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(610);
				typeSpecifier();
				setState(612);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(611);
					specifierQualifierList();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(614);
				typeQualifier();
				setState(616);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(615);
					specifierQualifierList();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclaratorListContext extends ParserRuleContext {
		public StructDeclaratorContext structDeclarator() {
			return getRuleContext(StructDeclaratorContext.class,0);
		}
		public StructDeclaratorListContext structDeclaratorList() {
			return getRuleContext(StructDeclaratorListContext.class,0);
		}
		public StructDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructDeclaratorList(this);
		}
	}

	public final StructDeclaratorListContext structDeclaratorList() throws RecognitionException {
		return structDeclaratorList(0);
	}

	private StructDeclaratorListContext structDeclaratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StructDeclaratorListContext _localctx = new StructDeclaratorListContext(_ctx, _parentState);
		StructDeclaratorListContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_structDeclaratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(621);
			structDeclarator();
			}
			_ctx.stop = _input.LT(-1);
			setState(628);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructDeclaratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_structDeclaratorList);
					setState(623);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(624);
					match(Comma);
					setState(625);
					structDeclarator();
					}
					} 
				}
				setState(630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StructDeclaratorContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public StructDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStructDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStructDeclarator(this);
		}
	}

	public final StructDeclaratorContext structDeclarator() throws RecognitionException {
		StructDeclaratorContext _localctx = new StructDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_structDeclarator);
		int _la;
		try {
			setState(637);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(631);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(633);
				_la = _input.LA(1);
				if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)) | (1L << (Identifier - 59)))) != 0)) {
					{
					setState(632);
					declarator();
					}
				}

				setState(635);
				match(Colon);
				setState(636);
				constantExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumSpecifierContext extends ParserRuleContext {
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public EnumSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEnumSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEnumSpecifier(this);
		}
	}

	public final EnumSpecifierContext enumSpecifier() throws RecognitionException {
		EnumSpecifierContext _localctx = new EnumSpecifierContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_enumSpecifier);
		int _la;
		try {
			setState(658);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(639);
				match(Enum);
				setState(641);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(640);
					match(Identifier);
					}
				}

				setState(643);
				match(LeftBrace);
				setState(644);
				enumeratorList(0);
				setState(645);
				match(RightBrace);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				match(Enum);
				setState(649);
				_la = _input.LA(1);
				if (_la==Identifier) {
					{
					setState(648);
					match(Identifier);
					}
				}

				setState(651);
				match(LeftBrace);
				setState(652);
				enumeratorList(0);
				setState(653);
				match(Comma);
				setState(654);
				match(RightBrace);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(656);
				match(Enum);
				setState(657);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumeratorListContext extends ParserRuleContext {
		public EnumeratorContext enumerator() {
			return getRuleContext(EnumeratorContext.class,0);
		}
		public EnumeratorListContext enumeratorList() {
			return getRuleContext(EnumeratorListContext.class,0);
		}
		public EnumeratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEnumeratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEnumeratorList(this);
		}
	}

	public final EnumeratorListContext enumeratorList() throws RecognitionException {
		return enumeratorList(0);
	}

	private EnumeratorListContext enumeratorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EnumeratorListContext _localctx = new EnumeratorListContext(_ctx, _parentState);
		EnumeratorListContext _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_enumeratorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(661);
			enumerator();
			}
			_ctx.stop = _input.LT(-1);
			setState(668);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EnumeratorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_enumeratorList);
					setState(663);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(664);
					match(Comma);
					setState(665);
					enumerator();
					}
					} 
				}
				setState(670);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EnumeratorContext extends ParserRuleContext {
		public EnumerationConstantContext enumerationConstant() {
			return getRuleContext(EnumerationConstantContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public EnumeratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEnumerator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEnumerator(this);
		}
	}

	public final EnumeratorContext enumerator() throws RecognitionException {
		EnumeratorContext _localctx = new EnumeratorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_enumerator);
		try {
			setState(676);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(671);
				enumerationConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				enumerationConstant();
				setState(673);
				match(Assign);
				setState(674);
				constantExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationConstantContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public EnumerationConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterEnumerationConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitEnumerationConstant(this);
		}
	}

	public final EnumerationConstantContext enumerationConstant() throws RecognitionException {
		EnumerationConstantContext _localctx = new EnumerationConstantContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_enumerationConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(678);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicTypeSpecifierContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public AtomicTypeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicTypeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAtomicTypeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAtomicTypeSpecifier(this);
		}
	}

	public final AtomicTypeSpecifierContext atomicTypeSpecifier() throws RecognitionException {
		AtomicTypeSpecifierContext _localctx = new AtomicTypeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_atomicTypeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(Atomic);
			setState(681);
			match(LeftParen);
			setState(682);
			typeName();
			setState(683);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierContext extends ParserRuleContext {
		public TypeQualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTypeQualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTypeQualifier(this);
		}
	}

	public final TypeQualifierContext typeQualifier() throws RecognitionException {
		TypeQualifierContext _localctx = new TypeQualifierContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeQualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionSpecifierContext extends ParserRuleContext {
		public GccAttributeSpecifierContext gccAttributeSpecifier() {
			return getRuleContext(GccAttributeSpecifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public FunctionSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFunctionSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFunctionSpecifier(this);
		}
	}

	public final FunctionSpecifierContext functionSpecifier() throws RecognitionException {
		FunctionSpecifierContext _localctx = new FunctionSpecifierContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_functionSpecifier);
		int _la;
		try {
			setState(693);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case Inline:
			case Noreturn:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << Inline) | (1L << Noreturn))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(688);
				gccAttributeSpecifier();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(689);
				match(T__9);
				setState(690);
				match(LeftParen);
				setState(691);
				match(Identifier);
				setState(692);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AlignmentSpecifierContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public AlignmentSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alignmentSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAlignmentSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAlignmentSpecifier(this);
		}
	}

	public final AlignmentSpecifierContext alignmentSpecifier() throws RecognitionException {
		AlignmentSpecifierContext _localctx = new AlignmentSpecifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_alignmentSpecifier);
		try {
			setState(705);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(695);
				match(Alignas);
				setState(696);
				match(LeftParen);
				setState(697);
				typeName();
				setState(698);
				match(RightParen);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(700);
				match(Alignas);
				setState(701);
				match(LeftParen);
				setState(702);
				constantExpression();
				setState(703);
				match(RightParen);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaratorContext extends ParserRuleContext {
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public DeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarator(this);
		}
	}

	public final DeclaratorContext declarator() throws RecognitionException {
		DeclaratorContext _localctx = new DeclaratorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_declarator);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			_la = _input.LA(1);
			if (_la==Star || _la==Caret) {
				{
				setState(707);
				pointer();
				}
			}

			setState(710);
			directDeclarator(0);
			setState(714);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(711);
					gccDeclaratorExtension();
					}
					} 
				}
				setState(716);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectDeclaratorContext extends ParserRuleContext {
		public Token Identifier;
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public DirectDeclaratorContext directDeclarator() {
			return getRuleContext(DirectDeclaratorContext.class,0);
		}
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ParameterTypeListContext parameterTypeList() {
			return getRuleContext(ParameterTypeListContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public DirectDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDirectDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDirectDeclarator(this);
		}
	}

	public final DirectDeclaratorContext directDeclarator() throws RecognitionException {
		return directDeclarator(0);
	}

	private DirectDeclaratorContext directDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectDeclaratorContext _localctx = new DirectDeclaratorContext(_ctx, _parentState);
		DirectDeclaratorContext _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_directDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(718);
				((DirectDeclaratorContext)_localctx).Identifier = match(Identifier);
				 if (typeDefScope.isTypedef()) {
										typeDefScope.addTypedef((((DirectDeclaratorContext)_localctx).Identifier!=null?((DirectDeclaratorContext)_localctx).Identifier.getText():null));
							} 
				}
				break;
			case LeftParen:
				{
				setState(720);
				match(LeftParen);
				setState(721);
				declarator();
				setState(722);
				match(RightParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(771);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(769);
					switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
					case 1:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(726);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(727);
						match(LeftBracket);
						setState(729);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(728);
							typeQualifierList(0);
							}
						}

						setState(732);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(731);
							assignmentExpression();
							}
						}

						setState(734);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(735);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(736);
						match(LeftBracket);
						setState(737);
						match(Static);
						setState(739);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(738);
							typeQualifierList(0);
							}
						}

						setState(741);
						assignmentExpression();
						setState(742);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(744);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(745);
						match(LeftBracket);
						setState(746);
						typeQualifierList(0);
						setState(747);
						match(Static);
						setState(748);
						assignmentExpression();
						setState(749);
						match(RightBracket);
						}
						break;
					case 4:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(751);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(752);
						match(LeftBracket);
						setState(754);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(753);
							typeQualifierList(0);
							}
						}

						setState(756);
						match(Star);
						setState(757);
						match(RightBracket);
						}
						break;
					case 5:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(758);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(759);
						match(LeftParen);
						setState(760);
						parameterTypeList();
						setState(761);
						match(RightParen);
						}
						break;
					case 6:
						{
						_localctx = new DirectDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directDeclarator);
						setState(763);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(764);
						match(LeftParen);
						setState(766);
						_la = _input.LA(1);
						if (_la==Identifier) {
							{
							setState(765);
							identifierList(0);
							}
						}

						setState(768);
						match(RightParen);
						}
						break;
					}
					} 
				}
				setState(773);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GccDeclaratorExtensionContext extends ParserRuleContext {
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public GccAttributeSpecifierContext gccAttributeSpecifier() {
			return getRuleContext(GccAttributeSpecifierContext.class,0);
		}
		public GccDeclaratorExtensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccDeclaratorExtension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGccDeclaratorExtension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGccDeclaratorExtension(this);
		}
	}

	public final GccDeclaratorExtensionContext gccDeclaratorExtension() throws RecognitionException {
		GccDeclaratorExtensionContext _localctx = new GccDeclaratorExtensionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_gccDeclaratorExtension);
		int _la;
		try {
			setState(783);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(774);
				match(T__10);
				setState(775);
				match(LeftParen);
				setState(777); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(776);
					match(StringLiteral);
					}
					}
					setState(779); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==StringLiteral );
				setState(781);
				match(RightParen);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(782);
				gccAttributeSpecifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeSpecifierContext extends ParserRuleContext {
		public GccAttributeListContext gccAttributeList() {
			return getRuleContext(GccAttributeListContext.class,0);
		}
		public GccAttributeSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttributeSpecifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGccAttributeSpecifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGccAttributeSpecifier(this);
		}
	}

	public final GccAttributeSpecifierContext gccAttributeSpecifier() throws RecognitionException {
		GccAttributeSpecifierContext _localctx = new GccAttributeSpecifierContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_gccAttributeSpecifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(785);
			match(T__11);
			setState(786);
			match(LeftParen);
			setState(787);
			match(LeftParen);
			setState(788);
			gccAttributeList();
			setState(789);
			match(RightParen);
			setState(790);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeListContext extends ParserRuleContext {
		public List<GccAttributeContext> gccAttribute() {
			return getRuleContexts(GccAttributeContext.class);
		}
		public GccAttributeContext gccAttribute(int i) {
			return getRuleContext(GccAttributeContext.class,i);
		}
		public GccAttributeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttributeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGccAttributeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGccAttributeList(this);
		}
	}

	public final GccAttributeListContext gccAttributeList() throws RecognitionException {
		GccAttributeListContext _localctx = new GccAttributeListContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_gccAttributeList);
		int _la;
		try {
			setState(801);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(792);
				gccAttribute();
				setState(797);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(793);
					match(Comma);
					setState(794);
					gccAttribute();
					}
					}
					setState(799);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GccAttributeContext extends ParserRuleContext {
		public ArgumentExpressionListContext argumentExpressionList() {
			return getRuleContext(ArgumentExpressionListContext.class,0);
		}
		public GccAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gccAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterGccAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitGccAttribute(this);
		}
	}

	public final GccAttributeContext gccAttribute() throws RecognitionException {
		GccAttributeContext _localctx = new GccAttributeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_gccAttribute);
		int _la;
		try {
			setState(812);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case Auto:
			case Break:
			case Case:
			case Char:
			case Const:
			case Continue:
			case Default:
			case Do:
			case Double:
			case Else:
			case Enum:
			case Extern:
			case Float:
			case For:
			case Goto:
			case If:
			case Inline:
			case Int:
			case Long:
			case Register:
			case Restrict:
			case Return:
			case Short:
			case Signed:
			case Sizeof:
			case Static:
			case Struct:
			case Switch:
			case Typedef:
			case Union:
			case Unsigned:
			case Void:
			case Volatile:
			case While:
			case Alignas:
			case Alignof:
			case Atomic:
			case Bool:
			case Complex:
			case Generic:
			case Imaginary:
			case Noreturn:
			case StaticAssert:
			case ThreadLocal:
			case LeftBracket:
			case RightBracket:
			case LeftBrace:
			case RightBrace:
			case Less:
			case LessEqual:
			case Greater:
			case GreaterEqual:
			case LeftShift:
			case RightShift:
			case Plus:
			case PlusPlus:
			case Minus:
			case MinusMinus:
			case Star:
			case Div:
			case Mod:
			case And:
			case Or:
			case AndAnd:
			case OrOr:
			case Caret:
			case Not:
			case Tilde:
			case Question:
			case Colon:
			case Semi:
			case Assign:
			case StarAssign:
			case DivAssign:
			case ModAssign:
			case PlusAssign:
			case MinusAssign:
			case LeftShiftAssign:
			case RightShiftAssign:
			case AndAssign:
			case XorAssign:
			case OrAssign:
			case Equal:
			case NotEqual:
			case Arrow:
			case Dot:
			case Ellipsis:
			case Identifier:
			case Constant:
			case StringLiteral:
			case LineDirective:
			case PragmaDirective:
			case Whitespace:
			case Newline:
			case BlockComment:
			case LineComment:
				enterOuterAlt(_localctx, 1);
				{
				setState(803);
				_la = _input.LA(1);
				if ( _la <= 0 || (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (RightParen - 59)) | (1L << (Comma - 59)))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(809);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(804);
					match(LeftParen);
					setState(806);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
						{
						setState(805);
						argumentExpressionList(0);
						}
					}

					setState(808);
					match(RightParen);
					}
				}

				}
				break;
			case RightParen:
			case Comma:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedParenthesesBlockContext extends ParserRuleContext {
		public List<NestedParenthesesBlockContext> nestedParenthesesBlock() {
			return getRuleContexts(NestedParenthesesBlockContext.class);
		}
		public NestedParenthesesBlockContext nestedParenthesesBlock(int i) {
			return getRuleContext(NestedParenthesesBlockContext.class,i);
		}
		public NestedParenthesesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedParenthesesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterNestedParenthesesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitNestedParenthesesBlock(this);
		}
	}

	public final NestedParenthesesBlockContext nestedParenthesesBlock() throws RecognitionException {
		NestedParenthesesBlockContext _localctx = new NestedParenthesesBlockContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_nestedParenthesesBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(821);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Auto) | (1L << Break) | (1L << Case) | (1L << Char) | (1L << Const) | (1L << Continue) | (1L << Default) | (1L << Do) | (1L << Double) | (1L << Else) | (1L << Enum) | (1L << Extern) | (1L << Float) | (1L << For) | (1L << Goto) | (1L << If) | (1L << Inline) | (1L << Int) | (1L << Long) | (1L << Register) | (1L << Restrict) | (1L << Return) | (1L << Short) | (1L << Signed) | (1L << Sizeof) | (1L << Static) | (1L << Struct) | (1L << Switch) | (1L << Typedef) | (1L << Union) | (1L << Unsigned) | (1L << Void) | (1L << Volatile) | (1L << While) | (1L << Alignas) | (1L << Alignof) | (1L << Atomic) | (1L << Bool) | (1L << Complex) | (1L << Generic) | (1L << Imaginary) | (1L << Noreturn) | (1L << StaticAssert) | (1L << ThreadLocal) | (1L << LeftParen) | (1L << LeftBracket) | (1L << RightBracket) | (1L << LeftBrace))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (RightBrace - 64)) | (1L << (Less - 64)) | (1L << (LessEqual - 64)) | (1L << (Greater - 64)) | (1L << (GreaterEqual - 64)) | (1L << (LeftShift - 64)) | (1L << (RightShift - 64)) | (1L << (Plus - 64)) | (1L << (PlusPlus - 64)) | (1L << (Minus - 64)) | (1L << (MinusMinus - 64)) | (1L << (Star - 64)) | (1L << (Div - 64)) | (1L << (Mod - 64)) | (1L << (And - 64)) | (1L << (Or - 64)) | (1L << (AndAnd - 64)) | (1L << (OrOr - 64)) | (1L << (Caret - 64)) | (1L << (Not - 64)) | (1L << (Tilde - 64)) | (1L << (Question - 64)) | (1L << (Colon - 64)) | (1L << (Semi - 64)) | (1L << (Comma - 64)) | (1L << (Assign - 64)) | (1L << (StarAssign - 64)) | (1L << (DivAssign - 64)) | (1L << (ModAssign - 64)) | (1L << (PlusAssign - 64)) | (1L << (MinusAssign - 64)) | (1L << (LeftShiftAssign - 64)) | (1L << (RightShiftAssign - 64)) | (1L << (AndAssign - 64)) | (1L << (XorAssign - 64)) | (1L << (OrAssign - 64)) | (1L << (Equal - 64)) | (1L << (NotEqual - 64)) | (1L << (Arrow - 64)) | (1L << (Dot - 64)) | (1L << (Ellipsis - 64)) | (1L << (Identifier - 64)) | (1L << (Constant - 64)) | (1L << (StringLiteral - 64)) | (1L << (LineDirective - 64)) | (1L << (PragmaDirective - 64)) | (1L << (Whitespace - 64)) | (1L << (Newline - 64)) | (1L << (BlockComment - 64)) | (1L << (LineComment - 64)))) != 0)) {
				{
				setState(819);
				switch (_input.LA(1)) {
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case Auto:
				case Break:
				case Case:
				case Char:
				case Const:
				case Continue:
				case Default:
				case Do:
				case Double:
				case Else:
				case Enum:
				case Extern:
				case Float:
				case For:
				case Goto:
				case If:
				case Inline:
				case Int:
				case Long:
				case Register:
				case Restrict:
				case Return:
				case Short:
				case Signed:
				case Sizeof:
				case Static:
				case Struct:
				case Switch:
				case Typedef:
				case Union:
				case Unsigned:
				case Void:
				case Volatile:
				case While:
				case Alignas:
				case Alignof:
				case Atomic:
				case Bool:
				case Complex:
				case Generic:
				case Imaginary:
				case Noreturn:
				case StaticAssert:
				case ThreadLocal:
				case LeftBracket:
				case RightBracket:
				case LeftBrace:
				case RightBrace:
				case Less:
				case LessEqual:
				case Greater:
				case GreaterEqual:
				case LeftShift:
				case RightShift:
				case Plus:
				case PlusPlus:
				case Minus:
				case MinusMinus:
				case Star:
				case Div:
				case Mod:
				case And:
				case Or:
				case AndAnd:
				case OrOr:
				case Caret:
				case Not:
				case Tilde:
				case Question:
				case Colon:
				case Semi:
				case Comma:
				case Assign:
				case StarAssign:
				case DivAssign:
				case ModAssign:
				case PlusAssign:
				case MinusAssign:
				case LeftShiftAssign:
				case RightShiftAssign:
				case AndAssign:
				case XorAssign:
				case OrAssign:
				case Equal:
				case NotEqual:
				case Arrow:
				case Dot:
				case Ellipsis:
				case Identifier:
				case Constant:
				case StringLiteral:
				case LineDirective:
				case PragmaDirective:
				case Whitespace:
				case Newline:
				case BlockComment:
				case LineComment:
					{
					setState(814);
					_la = _input.LA(1);
					if ( _la <= 0 || (_la==LeftParen || _la==RightParen) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case LeftParen:
					{
					setState(815);
					match(LeftParen);
					setState(816);
					nestedParenthesesBlock();
					setState(817);
					match(RightParen);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerContext extends ParserRuleContext {
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitPointer(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_pointer);
		int _la;
		try {
			setState(842);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(824);
				match(Star);
				setState(826);
				switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
				case 1:
					{
					setState(825);
					typeQualifierList(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(828);
				match(Star);
				setState(830);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(829);
					typeQualifierList(0);
					}
				}

				setState(832);
				pointer();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(833);
				match(Caret);
				setState(835);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(834);
					typeQualifierList(0);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(837);
				match(Caret);
				setState(839);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(838);
					typeQualifierList(0);
					}
				}

				setState(841);
				pointer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeQualifierListContext extends ParserRuleContext {
		public TypeQualifierContext typeQualifier() {
			return getRuleContext(TypeQualifierContext.class,0);
		}
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public TypeQualifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeQualifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTypeQualifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTypeQualifierList(this);
		}
	}

	public final TypeQualifierListContext typeQualifierList() throws RecognitionException {
		return typeQualifierList(0);
	}

	private TypeQualifierListContext typeQualifierList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeQualifierListContext _localctx = new TypeQualifierListContext(_ctx, _parentState);
		TypeQualifierListContext _prevctx = _localctx;
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_typeQualifierList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(845);
			typeQualifier();
			}
			_ctx.stop = _input.LT(-1);
			setState(851);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeQualifierListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeQualifierList);
					setState(847);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(848);
					typeQualifier();
					}
					} 
				}
				setState(853);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterTypeListContext extends ParserRuleContext {
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ParameterTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterParameterTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitParameterTypeList(this);
		}
	}

	public final ParameterTypeListContext parameterTypeList() throws RecognitionException {
		ParameterTypeListContext _localctx = new ParameterTypeListContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_parameterTypeList);
		try {
			setState(859);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(854);
				parameterList(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(855);
				parameterList(0);
				setState(856);
				match(Comma);
				setState(857);
				match(Ellipsis);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public ParameterDeclarationContext parameterDeclaration() {
			return getRuleContext(ParameterDeclarationContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		return parameterList(0);
	}

	private ParameterListContext parameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParameterListContext _localctx = new ParameterListContext(_ctx, _parentState);
		ParameterListContext _prevctx = _localctx;
		int _startState = 114;
		enterRecursionRule(_localctx, 114, RULE_parameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(862);
			parameterDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(869);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParameterListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_parameterList);
					setState(864);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(865);
					match(Comma);
					setState(866);
					parameterDeclaration();
					}
					} 
				}
				setState(871);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParameterDeclarationContext extends ParserRuleContext {
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public DeclarationSpecifiers2Context declarationSpecifiers2() {
			return getRuleContext(DeclarationSpecifiers2Context.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public ParameterDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterParameterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitParameterDeclaration(this);
		}
	}

	public final ParameterDeclarationContext parameterDeclaration() throws RecognitionException {
		ParameterDeclarationContext _localctx = new ParameterDeclarationContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_parameterDeclaration);
		try {
			setState(879);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(872);
				declarationSpecifiers();
				setState(873);
				declarator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(875);
				declarationSpecifiers2();
				setState(877);
				switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
				case 1:
					{
					setState(876);
					abstractDeclarator();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		return identifierList(0);
	}

	private IdentifierListContext identifierList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, _parentState);
		IdentifierListContext _prevctx = _localctx;
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_identifierList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(882);
			match(Identifier);
			}
			_ctx.stop = _input.LT(-1);
			setState(889);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new IdentifierListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_identifierList);
					setState(884);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(885);
					match(Comma);
					setState(886);
					match(Identifier);
					}
					} 
				}
				setState(891);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public SpecifierQualifierListContext specifierQualifierList() {
			return getRuleContext(SpecifierQualifierListContext.class,0);
		}
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(892);
			specifierQualifierList();
			setState(894);
			_la = _input.LA(1);
			if (((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & ((1L << (LeftParen - 59)) | (1L << (LeftBracket - 59)) | (1L << (Star - 59)) | (1L << (Caret - 59)))) != 0)) {
				{
				setState(893);
				abstractDeclarator();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AbstractDeclaratorContext extends ParserRuleContext {
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public AbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitAbstractDeclarator(this);
		}
	}

	public final AbstractDeclaratorContext abstractDeclarator() throws RecognitionException {
		AbstractDeclaratorContext _localctx = new AbstractDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_abstractDeclarator);
		int _la;
		try {
			int _alt;
			setState(907);
			switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(896);
				pointer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(898);
				_la = _input.LA(1);
				if (_la==Star || _la==Caret) {
					{
					setState(897);
					pointer();
					}
				}

				setState(900);
				directAbstractDeclarator(0);
				setState(904);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(901);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(906);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DirectAbstractDeclaratorContext extends ParserRuleContext {
		public AbstractDeclaratorContext abstractDeclarator() {
			return getRuleContext(AbstractDeclaratorContext.class,0);
		}
		public List<GccDeclaratorExtensionContext> gccDeclaratorExtension() {
			return getRuleContexts(GccDeclaratorExtensionContext.class);
		}
		public GccDeclaratorExtensionContext gccDeclaratorExtension(int i) {
			return getRuleContext(GccDeclaratorExtensionContext.class,i);
		}
		public TypeQualifierListContext typeQualifierList() {
			return getRuleContext(TypeQualifierListContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ParameterTypeListContext parameterTypeList() {
			return getRuleContext(ParameterTypeListContext.class,0);
		}
		public DirectAbstractDeclaratorContext directAbstractDeclarator() {
			return getRuleContext(DirectAbstractDeclaratorContext.class,0);
		}
		public DirectAbstractDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directAbstractDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDirectAbstractDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDirectAbstractDeclarator(this);
		}
	}

	public final DirectAbstractDeclaratorContext directAbstractDeclarator() throws RecognitionException {
		return directAbstractDeclarator(0);
	}

	private DirectAbstractDeclaratorContext directAbstractDeclarator(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DirectAbstractDeclaratorContext _localctx = new DirectAbstractDeclaratorContext(_ctx, _parentState);
		DirectAbstractDeclaratorContext _prevctx = _localctx;
		int _startState = 124;
		enterRecursionRule(_localctx, 124, RULE_directAbstractDeclarator, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(955);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(910);
				match(LeftParen);
				setState(911);
				abstractDeclarator();
				setState(912);
				match(RightParen);
				setState(916);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(913);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(918);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,91,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(919);
				match(LeftBracket);
				setState(921);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(920);
					typeQualifierList(0);
					}
				}

				setState(924);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(923);
					assignmentExpression();
					}
				}

				setState(926);
				match(RightBracket);
				}
				break;
			case 3:
				{
				setState(927);
				match(LeftBracket);
				setState(928);
				match(Static);
				setState(930);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
					{
					setState(929);
					typeQualifierList(0);
					}
				}

				setState(932);
				assignmentExpression();
				setState(933);
				match(RightBracket);
				}
				break;
			case 4:
				{
				setState(935);
				match(LeftBracket);
				setState(936);
				typeQualifierList(0);
				setState(937);
				match(Static);
				setState(938);
				assignmentExpression();
				setState(939);
				match(RightBracket);
				}
				break;
			case 5:
				{
				setState(941);
				match(LeftBracket);
				setState(942);
				match(Star);
				setState(943);
				match(RightBracket);
				}
				break;
			case 6:
				{
				setState(944);
				match(LeftParen);
				setState(946);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(945);
					parameterTypeList();
					}
					break;
				}
				setState(948);
				match(RightParen);
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(949);
						gccDeclaratorExtension();
						}
						} 
					}
					setState(954);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1000);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(998);
					switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
					case 1:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(957);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(958);
						match(LeftBracket);
						setState(960);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(959);
							typeQualifierList(0);
							}
						}

						setState(963);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
							{
							setState(962);
							assignmentExpression();
							}
						}

						setState(965);
						match(RightBracket);
						}
						break;
					case 2:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(966);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(967);
						match(LeftBracket);
						setState(968);
						match(Static);
						setState(970);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Const) | (1L << Restrict) | (1L << Volatile) | (1L << Atomic))) != 0)) {
							{
							setState(969);
							typeQualifierList(0);
							}
						}

						setState(972);
						assignmentExpression();
						setState(973);
						match(RightBracket);
						}
						break;
					case 3:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(975);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(976);
						match(LeftBracket);
						setState(977);
						typeQualifierList(0);
						setState(978);
						match(Static);
						setState(979);
						assignmentExpression();
						setState(980);
						match(RightBracket);
						}
						break;
					case 4:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(982);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(983);
						match(LeftBracket);
						setState(984);
						match(Star);
						setState(985);
						match(RightBracket);
						}
						break;
					case 5:
						{
						_localctx = new DirectAbstractDeclaratorContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_directAbstractDeclarator);
						setState(986);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(987);
						match(LeftParen);
						setState(989);
						switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
						case 1:
							{
							setState(988);
							parameterTypeList();
							}
							break;
						}
						setState(991);
						match(RightParen);
						setState(995);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(992);
								gccDeclaratorExtension();
								}
								} 
							}
							setState(997);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,102,_ctx);
						}
						}
						break;
					}
					} 
				}
				setState(1002);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypedefNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public TypedefNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedefName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTypedefName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTypedefName(this);
		}
	}

	public final TypedefNameContext typedefName() throws RecognitionException {
		TypedefNameContext _localctx = new TypedefNameContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_typedefName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1003);
			if (!(typeDefScope.isTypeName(_input.LT(1).getText()))) throw new FailedPredicateException(this, "typeDefScope.isTypeName(_input.LT(1).getText())");
			setState(1004);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerContext extends ParserRuleContext {
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_initializer);
		try {
			setState(1016);
			switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1006);
				assignmentExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1007);
				match(LeftBrace);
				setState(1008);
				initializerList(0);
				setState(1009);
				match(RightBrace);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1011);
				match(LeftBrace);
				setState(1012);
				initializerList(0);
				setState(1013);
				match(Comma);
				setState(1014);
				match(RightBrace);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InitializerListContext extends ParserRuleContext {
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public DesignationContext designation() {
			return getRuleContext(DesignationContext.class,0);
		}
		public InitializerListContext initializerList() {
			return getRuleContext(InitializerListContext.class,0);
		}
		public InitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitInitializerList(this);
		}
	}

	public final InitializerListContext initializerList() throws RecognitionException {
		return initializerList(0);
	}

	private InitializerListContext initializerList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InitializerListContext _localctx = new InitializerListContext(_ctx, _parentState);
		InitializerListContext _prevctx = _localctx;
		int _startState = 130;
		enterRecursionRule(_localctx, 130, RULE_initializerList, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1020);
			_la = _input.LA(1);
			if (_la==LeftBracket || _la==Dot) {
				{
				setState(1019);
				designation();
				}
			}

			setState(1022);
			initializer();
			}
			_ctx.stop = _input.LT(-1);
			setState(1032);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InitializerListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_initializerList);
					setState(1024);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1025);
					match(Comma);
					setState(1027);
					_la = _input.LA(1);
					if (_la==LeftBracket || _la==Dot) {
						{
						setState(1026);
						designation();
						}
					}

					setState(1029);
					initializer();
					}
					} 
				}
				setState(1034);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DesignationContext extends ParserRuleContext {
		public DesignatorListContext designatorList() {
			return getRuleContext(DesignatorListContext.class,0);
		}
		public DesignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDesignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDesignation(this);
		}
	}

	public final DesignationContext designation() throws RecognitionException {
		DesignationContext _localctx = new DesignationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_designation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1035);
			designatorList(0);
			setState(1036);
			match(Assign);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesignatorListContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public DesignatorListContext designatorList() {
			return getRuleContext(DesignatorListContext.class,0);
		}
		public DesignatorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designatorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDesignatorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDesignatorList(this);
		}
	}

	public final DesignatorListContext designatorList() throws RecognitionException {
		return designatorList(0);
	}

	private DesignatorListContext designatorList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DesignatorListContext _localctx = new DesignatorListContext(_ctx, _parentState);
		DesignatorListContext _prevctx = _localctx;
		int _startState = 134;
		enterRecursionRule(_localctx, 134, RULE_designatorList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1039);
			designator();
			}
			_ctx.stop = _input.LT(-1);
			setState(1045);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DesignatorListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_designatorList);
					setState(1041);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1042);
					designator();
					}
					} 
				}
				setState(1047);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,109,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class DesignatorContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDesignator(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_designator);
		try {
			setState(1054);
			switch (_input.LA(1)) {
			case LeftBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1048);
				match(LeftBracket);
				setState(1049);
				constantExpression();
				setState(1050);
				match(RightBracket);
				}
				break;
			case Dot:
				enterOuterAlt(_localctx, 2);
				{
				setState(1052);
				match(Dot);
				setState(1053);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StaticAssertDeclarationContext extends ParserRuleContext {
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public List<TerminalNode> StringLiteral() { return getTokens(CParser.StringLiteral); }
		public TerminalNode StringLiteral(int i) {
			return getToken(CParser.StringLiteral, i);
		}
		public StaticAssertDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticAssertDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStaticAssertDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStaticAssertDeclaration(this);
		}
	}

	public final StaticAssertDeclarationContext staticAssertDeclaration() throws RecognitionException {
		StaticAssertDeclarationContext _localctx = new StaticAssertDeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_staticAssertDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1056);
			match(StaticAssert);
			setState(1057);
			match(LeftParen);
			setState(1058);
			constantExpression();
			setState(1059);
			match(Comma);
			setState(1061); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1060);
				match(StringLiteral);
				}
				}
				setState(1063); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==StringLiteral );
			setState(1065);
			match(RightParen);
			setState(1066);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public List<LogicalOrExpressionContext> logicalOrExpression() {
			return getRuleContexts(LogicalOrExpressionContext.class);
		}
		public LogicalOrExpressionContext logicalOrExpression(int i) {
			return getRuleContext(LogicalOrExpressionContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_statement);
		int _la;
		try {
			setState(1105);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1068);
				labeledStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1069);
				compoundStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1070);
				expressionStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1071);
				selectionStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1072);
				iterationStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1073);
				jumpStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1074);
				_la = _input.LA(1);
				if ( !(_la==T__10 || _la==T__12) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1075);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==Volatile) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(1076);
				match(LeftParen);
				setState(1085);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1077);
					logicalOrExpression(0);
					setState(1082);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(1078);
						match(Comma);
						setState(1079);
						logicalOrExpression(0);
						}
						}
						setState(1084);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Colon) {
					{
					{
					setState(1087);
					match(Colon);
					setState(1096);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
						{
						setState(1088);
						logicalOrExpression(0);
						setState(1093);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(1089);
							match(Comma);
							setState(1090);
							logicalOrExpression(0);
							}
							}
							setState(1095);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					}
					setState(1102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1103);
				match(RightParen);
				setState(1104);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabeledStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ConstantExpressionContext constantExpression() {
			return getRuleContext(ConstantExpressionContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_labeledStatement);
		try {
			setState(1118);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1107);
				match(Identifier);
				setState(1108);
				match(Colon);
				setState(1109);
				statement();
				}
				break;
			case Case:
				enterOuterAlt(_localctx, 2);
				{
				setState(1110);
				match(Case);
				setState(1111);
				constantExpression();
				setState(1112);
				match(Colon);
				setState(1113);
				statement();
				}
				break;
			case Default:
				enterOuterAlt(_localctx, 3);
				{
				setState(1115);
				match(Default);
				setState(1116);
				match(Colon);
				setState(1117);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundStatementContext extends ParserRuleContext {
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCompoundStatement(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_compoundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1120);
			match(LeftBrace);
			setState(1122);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1121);
				blockItemList(0);
				}
				break;
			}
			setState(1124);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockItemListContext extends ParserRuleContext {
		public BlockItemContext blockItem() {
			return getRuleContext(BlockItemContext.class,0);
		}
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public BlockItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterBlockItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitBlockItemList(this);
		}
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		return blockItemList(0);
	}

	private BlockItemListContext blockItemList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, _parentState);
		BlockItemListContext _prevctx = _localctx;
		int _startState = 146;
		enterRecursionRule(_localctx, 146, RULE_blockItemList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1127);
			blockItem();
			}
			_ctx.stop = _input.LT(-1);
			setState(1133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BlockItemListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_blockItemList);
					setState(1129);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1130);
					blockItem();
					}
					} 
				}
				setState(1135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,120,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockItemContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitBlockItem(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_blockItem);
		try {
			setState(1138);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1136);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1137);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1141);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
				{
				setState(1140);
				expression(0);
				}
			}

			setState(1143);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitSelectionStatement(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_selectionStatement);
		try {
			setState(1160);
			switch (_input.LA(1)) {
			case If:
				enterOuterAlt(_localctx, 1);
				{
				setState(1145);
				match(If);
				setState(1146);
				match(LeftParen);
				setState(1147);
				expression(0);
				setState(1148);
				match(RightParen);
				setState(1149);
				statement();
				setState(1152);
				switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
				case 1:
					{
					setState(1150);
					match(Else);
					setState(1151);
					statement();
					}
					break;
				}
				}
				break;
			case Switch:
				enterOuterAlt(_localctx, 2);
				{
				setState(1154);
				match(Switch);
				setState(1155);
				match(LeftParen);
				setState(1156);
				expression(0);
				setState(1157);
				match(RightParen);
				setState(1158);
				statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IterationStatementContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitIterationStatement(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_iterationStatement);
		int _la;
		try {
			setState(1204);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1162);
				match(While);
				setState(1163);
				match(LeftParen);
				setState(1164);
				expression(0);
				setState(1165);
				match(RightParen);
				setState(1166);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1168);
				match(Do);
				setState(1169);
				statement();
				setState(1170);
				match(While);
				setState(1171);
				match(LeftParen);
				setState(1172);
				expression(0);
				setState(1173);
				match(RightParen);
				setState(1174);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1176);
				match(For);
				setState(1177);
				match(LeftParen);
				setState(1179);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1178);
					expression(0);
					}
				}

				setState(1181);
				match(Semi);
				setState(1183);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1182);
					expression(0);
					}
				}

				setState(1185);
				match(Semi);
				setState(1187);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1186);
					expression(0);
					}
				}

				setState(1189);
				match(RightParen);
				setState(1190);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1191);
				match(For);
				setState(1192);
				match(LeftParen);
				setState(1193);
				declaration();
				setState(1195);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1194);
					expression(0);
					}
				}

				setState(1197);
				match(Semi);
				setState(1199);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1198);
					expression(0);
					}
				}

				setState(1201);
				match(RightParen);
				setState(1202);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitJumpStatement(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_jumpStatement);
		int _la;
		try {
			setState(1222);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1206);
				match(Goto);
				setState(1207);
				match(Identifier);
				setState(1208);
				match(Semi);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1209);
				match(Continue);
				setState(1210);
				match(Semi);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1211);
				match(Break);
				setState(1212);
				match(Semi);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1213);
				match(Return);
				setState(1215);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << Sizeof) | (1L << Alignof) | (1L << Generic) | (1L << LeftParen))) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & ((1L << (Plus - 71)) | (1L << (PlusPlus - 71)) | (1L << (Minus - 71)) | (1L << (MinusMinus - 71)) | (1L << (Star - 71)) | (1L << (And - 71)) | (1L << (AndAnd - 71)) | (1L << (Not - 71)) | (1L << (Tilde - 71)) | (1L << (Identifier - 71)) | (1L << (Constant - 71)) | (1L << (StringLiteral - 71)))) != 0)) {
					{
					setState(1214);
					expression(0);
					}
				}

				setState(1217);
				match(Semi);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1218);
				match(Goto);
				setState(1219);
				unaryExpression();
				setState(1220);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CParser.EOF, 0); }
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_compilationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1225);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				{
				setState(1224);
				translationUnit(0);
				}
				break;
			}
			setState(1227);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TranslationUnitContext extends ParserRuleContext {
		public ExternalDeclarationContext externalDeclaration() {
			return getRuleContext(ExternalDeclarationContext.class,0);
		}
		public TranslationUnitContext translationUnit() {
			return getRuleContext(TranslationUnitContext.class,0);
		}
		public TranslationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterTranslationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitTranslationUnit(this);
		}
	}

	public final TranslationUnitContext translationUnit() throws RecognitionException {
		return translationUnit(0);
	}

	private TranslationUnitContext translationUnit(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TranslationUnitContext _localctx = new TranslationUnitContext(_ctx, _parentState);
		TranslationUnitContext _prevctx = _localctx;
		int _startState = 160;
		enterRecursionRule(_localctx, 160, RULE_translationUnit, _p);
		 typeDefScope.createNewScope("translationUnit"); 
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1230);
			externalDeclaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TranslationUnitContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_translationUnit);
					setState(1232);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1233);
					externalDeclaration();
					}
					} 
				}
				setState(1238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			}
			 typeDefScope.removeScope(); 
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExternalDeclarationContext extends ParserRuleContext {
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ExternalDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_externalDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterExternalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitExternalDeclaration(this);
		}
	}

	public final ExternalDeclarationContext externalDeclaration() throws RecognitionException {
		ExternalDeclarationContext _localctx = new ExternalDeclarationContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_externalDeclaration);
		try {
			setState(1242);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1239);
				functionDefinition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1240);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1241);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public DeclaratorContext declarator() {
			return getRuleContext(DeclaratorContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public DeclarationSpecifiersContext declarationSpecifiers() {
			return getRuleContext(DeclarationSpecifiersContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_functionDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1245);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				{
				setState(1244);
				declarationSpecifiers();
				}
				break;
			}
			setState(1247);
			declarator();
			setState(1249);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				{
				setState(1248);
				declarationList(0);
				}
				break;
			}
			setState(1251);
			compoundStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationListContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public DeclarationListContext declarationList() {
			return getRuleContext(DeclarationListContext.class,0);
		}
		public DeclarationListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarationList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).enterDeclarationList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CListener ) ((CListener)listener).exitDeclarationList(this);
		}
	}

	public final DeclarationListContext declarationList() throws RecognitionException {
		return declarationList(0);
	}

	private DeclarationListContext declarationList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DeclarationListContext _localctx = new DeclarationListContext(_ctx, _parentState);
		DeclarationListContext _prevctx = _localctx;
		int _startState = 166;
		enterRecursionRule(_localctx, 166, RULE_declarationList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1254);
			declaration();
			}
			_ctx.stop = _input.LT(-1);
			setState(1260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DeclarationListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_declarationList);
					setState(1256);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1257);
					declaration();
					}
					} 
				}
				setState(1262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return genericAssocList_sempred((GenericAssocListContext)_localctx, predIndex);
		case 4:
			return postfixExpression_sempred((PostfixExpressionContext)_localctx, predIndex);
		case 5:
			return argumentExpressionList_sempred((ArgumentExpressionListContext)_localctx, predIndex);
		case 9:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 10:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 11:
			return shiftExpression_sempred((ShiftExpressionContext)_localctx, predIndex);
		case 12:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 13:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 14:
			return andExpression_sempred((AndExpressionContext)_localctx, predIndex);
		case 15:
			return exclusiveOrExpression_sempred((ExclusiveOrExpressionContext)_localctx, predIndex);
		case 16:
			return inclusiveOrExpression_sempred((InclusiveOrExpressionContext)_localctx, predIndex);
		case 17:
			return logicalAndExpression_sempred((LogicalAndExpressionContext)_localctx, predIndex);
		case 18:
			return logicalOrExpression_sempred((LogicalOrExpressionContext)_localctx, predIndex);
		case 22:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 28:
			return initDeclaratorList_sempred((InitDeclaratorListContext)_localctx, predIndex);
		case 34:
			return structDeclarationList_sempred((StructDeclarationListContext)_localctx, predIndex);
		case 37:
			return structDeclaratorList_sempred((StructDeclaratorListContext)_localctx, predIndex);
		case 40:
			return enumeratorList_sempred((EnumeratorListContext)_localctx, predIndex);
		case 48:
			return directDeclarator_sempred((DirectDeclaratorContext)_localctx, predIndex);
		case 55:
			return typeQualifierList_sempred((TypeQualifierListContext)_localctx, predIndex);
		case 57:
			return parameterList_sempred((ParameterListContext)_localctx, predIndex);
		case 59:
			return identifierList_sempred((IdentifierListContext)_localctx, predIndex);
		case 62:
			return directAbstractDeclarator_sempred((DirectAbstractDeclaratorContext)_localctx, predIndex);
		case 63:
			return typedefName_sempred((TypedefNameContext)_localctx, predIndex);
		case 65:
			return initializerList_sempred((InitializerListContext)_localctx, predIndex);
		case 67:
			return designatorList_sempred((DesignatorListContext)_localctx, predIndex);
		case 73:
			return blockItemList_sempred((BlockItemListContext)_localctx, predIndex);
		case 80:
			return translationUnit_sempred((TranslationUnitContext)_localctx, predIndex);
		case 83:
			return declarationList_sempred((DeclarationListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean genericAssocList_sempred(GenericAssocListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfixExpression_sempred(PostfixExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean argumentExpressionList_sempred(ArgumentExpressionListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shiftExpression_sempred(ShiftExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 4);
		case 16:
			return precpred(_ctx, 3);
		case 17:
			return precpred(_ctx, 2);
		case 18:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 2);
		case 20:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean andExpression_sempred(AndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusiveOrExpression_sempred(ExclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusiveOrExpression_sempred(InclusiveOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalAndExpression_sempred(LogicalAndExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalOrExpression_sempred(LogicalOrExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 25:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean initDeclaratorList_sempred(InitDeclaratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean structDeclarationList_sempred(StructDeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean structDeclaratorList_sempred(StructDeclaratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 29:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean enumeratorList_sempred(EnumeratorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directDeclarator_sempred(DirectDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 31:
			return precpred(_ctx, 6);
		case 32:
			return precpred(_ctx, 5);
		case 33:
			return precpred(_ctx, 4);
		case 34:
			return precpred(_ctx, 3);
		case 35:
			return precpred(_ctx, 2);
		case 36:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean typeQualifierList_sempred(TypeQualifierListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 37:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean parameterList_sempred(ParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 38:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean identifierList_sempred(IdentifierListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 39:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean directAbstractDeclarator_sempred(DirectAbstractDeclaratorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 40:
			return precpred(_ctx, 5);
		case 41:
			return precpred(_ctx, 4);
		case 42:
			return precpred(_ctx, 3);
		case 43:
			return precpred(_ctx, 2);
		case 44:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean typedefName_sempred(TypedefNameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 45:
			return typeDefScope.isTypeName(_input.LT(1).getText());
		}
		return true;
	}
	private boolean initializerList_sempred(InitializerListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 46:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean designatorList_sempred(DesignatorListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 47:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean blockItemList_sempred(BlockItemListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 48:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean translationUnit_sempred(TranslationUnitContext _localctx, int predIndex) {
		switch (predIndex) {
		case 49:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean declarationList_sempred(DeclarationListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 50:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3s\u04f2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\2\6\2\u00ae\n\2\r\2\16\2\u00af\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\5\2\u00b8\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2\u00cc\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4\u00db\n\4\f\4\16\4\u00de\13\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u00e7\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\5\6\u010b\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0115"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0122\n\6\f\6\16"+
		"\6\u0125\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u012d\n\7\f\7\16\7\u0130\13"+
		"\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\5\b\u0148\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u0158\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\7\13\u0166\n\13\f\13\16\13\u0169\13\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u0174\n\f\f\f\16\f\u0177\13\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0182\n\r\f\r\16\r\u0185\13\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\7\16\u0196\n\16\f\16\16\16\u0199\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u01a4\n\17\f\17\16\17\u01a7\13\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u01af\n\20\f\20\16\20\u01b2\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u01ba\n\21\f\21\16\21\u01bd\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\7\22\u01c5\n\22\f\22\16\22\u01c8\13\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u01d0\n\23\f\23\16\23\u01d3\13\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u01db\n\24\f\24\16\24\u01de\13\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u01e6\n\25\3\26\3\26\3\26\3\26\3\26\5\26\u01ed\n"+
		"\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u01f7\n\30\f\30\16\30"+
		"\u01fa\13\30\3\31\3\31\3\32\3\32\5\32\u0200\n\32\3\32\3\32\3\32\5\32\u0205"+
		"\n\32\3\33\6\33\u0208\n\33\r\33\16\33\u0209\3\34\6\34\u020d\n\34\r\34"+
		"\16\34\u020e\3\35\3\35\3\35\3\35\3\35\5\35\u0216\n\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\7\36\u021e\n\36\f\36\16\36\u0221\13\36\3\37\3\37\3\37\3"+
		"\37\3\37\5\37\u0228\n\37\3 \3 \3 \3 \3 \3 \3 \5 \u0231\n \3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0241\n!\3\"\3\"\5\"\u0245\n\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\5\"\u024e\n\"\3#\3#\3$\3$\3$\3$\3$\7$\u0257\n$"+
		"\f$\16$\u025a\13$\3%\3%\5%\u025e\n%\3%\3%\3%\5%\u0263\n%\3&\3&\5&\u0267"+
		"\n&\3&\3&\5&\u026b\n&\5&\u026d\n&\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u0275\n"+
		"\'\f\'\16\'\u0278\13\'\3(\3(\5(\u027c\n(\3(\3(\5(\u0280\n(\3)\3)\5)\u0284"+
		"\n)\3)\3)\3)\3)\3)\3)\5)\u028c\n)\3)\3)\3)\3)\3)\3)\3)\5)\u0295\n)\3*"+
		"\3*\3*\3*\3*\3*\7*\u029d\n*\f*\16*\u02a0\13*\3+\3+\3+\3+\3+\5+\u02a7\n"+
		"+\3,\3,\3-\3-\3-\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\5/\u02b8\n/\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u02c4\n\60\3\61\5\61\u02c7"+
		"\n\61\3\61\3\61\7\61\u02cb\n\61\f\61\16\61\u02ce\13\61\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u02d7\n\62\3\62\3\62\3\62\5\62\u02dc\n\62\3"+
		"\62\5\62\u02df\n\62\3\62\3\62\3\62\3\62\3\62\5\62\u02e6\n\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u02f5\n\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u0301\n\62\3\62"+
		"\7\62\u0304\n\62\f\62\16\62\u0307\13\62\3\63\3\63\3\63\6\63\u030c\n\63"+
		"\r\63\16\63\u030d\3\63\3\63\5\63\u0312\n\63\3\64\3\64\3\64\3\64\3\64\3"+
		"\64\3\64\3\65\3\65\3\65\7\65\u031e\n\65\f\65\16\65\u0321\13\65\3\65\5"+
		"\65\u0324\n\65\3\66\3\66\3\66\5\66\u0329\n\66\3\66\5\66\u032c\n\66\3\66"+
		"\5\66\u032f\n\66\3\67\3\67\3\67\3\67\3\67\7\67\u0336\n\67\f\67\16\67\u0339"+
		"\13\67\38\38\58\u033d\n8\38\38\58\u0341\n8\38\38\38\58\u0346\n8\38\38"+
		"\58\u034a\n8\38\58\u034d\n8\39\39\39\39\39\79\u0354\n9\f9\169\u0357\13"+
		"9\3:\3:\3:\3:\3:\5:\u035e\n:\3;\3;\3;\3;\3;\3;\7;\u0366\n;\f;\16;\u0369"+
		"\13;\3<\3<\3<\3<\3<\5<\u0370\n<\5<\u0372\n<\3=\3=\3=\3=\3=\3=\7=\u037a"+
		"\n=\f=\16=\u037d\13=\3>\3>\5>\u0381\n>\3?\3?\5?\u0385\n?\3?\3?\7?\u0389"+
		"\n?\f?\16?\u038c\13?\5?\u038e\n?\3@\3@\3@\3@\3@\7@\u0395\n@\f@\16@\u0398"+
		"\13@\3@\3@\5@\u039c\n@\3@\5@\u039f\n@\3@\3@\3@\3@\5@\u03a5\n@\3@\3@\3"+
		"@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5@\u03b5\n@\3@\3@\7@\u03b9\n@\f@\16"+
		"@\u03bc\13@\5@\u03be\n@\3@\3@\3@\5@\u03c3\n@\3@\5@\u03c6\n@\3@\3@\3@\3"+
		"@\3@\5@\u03cd\n@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\3@\5"+
		"@\u03e0\n@\3@\3@\7@\u03e4\n@\f@\16@\u03e7\13@\7@\u03e9\n@\f@\16@\u03ec"+
		"\13@\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3B\3B\5B\u03fb\nB\3C\3C\5C\u03ff"+
		"\nC\3C\3C\3C\3C\3C\5C\u0406\nC\3C\7C\u0409\nC\fC\16C\u040c\13C\3D\3D\3"+
		"D\3E\3E\3E\3E\3E\7E\u0416\nE\fE\16E\u0419\13E\3F\3F\3F\3F\3F\3F\5F\u0421"+
		"\nF\3G\3G\3G\3G\3G\6G\u0428\nG\rG\16G\u0429\3G\3G\3G\3H\3H\3H\3H\3H\3"+
		"H\3H\3H\3H\3H\3H\3H\7H\u043b\nH\fH\16H\u043e\13H\5H\u0440\nH\3H\3H\3H"+
		"\3H\7H\u0446\nH\fH\16H\u0449\13H\5H\u044b\nH\7H\u044d\nH\fH\16H\u0450"+
		"\13H\3H\3H\5H\u0454\nH\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\5I\u0461\nI\3"+
		"J\3J\5J\u0465\nJ\3J\3J\3K\3K\3K\3K\3K\7K\u046e\nK\fK\16K\u0471\13K\3L"+
		"\3L\5L\u0475\nL\3M\5M\u0478\nM\3M\3M\3N\3N\3N\3N\3N\3N\3N\5N\u0483\nN"+
		"\3N\3N\3N\3N\3N\3N\5N\u048b\nN\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O"+
		"\3O\3O\3O\3O\5O\u049e\nO\3O\3O\5O\u04a2\nO\3O\3O\5O\u04a6\nO\3O\3O\3O"+
		"\3O\3O\3O\5O\u04ae\nO\3O\3O\5O\u04b2\nO\3O\3O\3O\5O\u04b7\nO\3P\3P\3P"+
		"\3P\3P\3P\3P\3P\3P\5P\u04c2\nP\3P\3P\3P\3P\3P\5P\u04c9\nP\3Q\5Q\u04cc"+
		"\nQ\3Q\3Q\3R\3R\3R\3R\3R\7R\u04d5\nR\fR\16R\u04d8\13R\3S\3S\3S\5S\u04dd"+
		"\nS\3T\5T\u04e0\nT\3T\3T\5T\u04e4\nT\3T\3T\3U\3U\3U\3U\3U\7U\u04ed\nU"+
		"\fU\16U\u04f0\13U\3U\2\36\6\n\f\24\26\30\32\34\36 \"$&.:FLRbptx~\u0084"+
		"\u0088\u0094\u00a2\u00a8V\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\2\r\7\2IIKKMMPPUV\3\2[e\n\2\6\b\24"+
		"\24\31\31\35\35\"#\'(/\60\66\67\3\2\6\b\4\2++..\6\2\25\25%%\61\61\65\65"+
		"\5\2\n\13!!::\4\2=>ZZ\3\2=>\4\2\r\r\17\17\4\2\20\20\61\61\u0567\2\u00cb"+
		"\3\2\2\2\4\u00cd\3\2\2\2\6\u00d4\3\2\2\2\b\u00e6\3\2\2\2\n\u010a\3\2\2"+
		"\2\f\u0126\3\2\2\2\16\u0147\3\2\2\2\20\u0149\3\2\2\2\22\u0157\3\2\2\2"+
		"\24\u0159\3\2\2\2\26\u016a\3\2\2\2\30\u0178\3\2\2\2\32\u0186\3\2\2\2\34"+
		"\u019a\3\2\2\2\36\u01a8\3\2\2\2 \u01b3\3\2\2\2\"\u01be\3\2\2\2$\u01c9"+
		"\3\2\2\2&\u01d4\3\2\2\2(\u01df\3\2\2\2*\u01ec\3\2\2\2,\u01ee\3\2\2\2."+
		"\u01f0\3\2\2\2\60\u01fb\3\2\2\2\62\u0204\3\2\2\2\64\u0207\3\2\2\2\66\u020c"+
		"\3\2\2\28\u0215\3\2\2\2:\u0217\3\2\2\2<\u0227\3\2\2\2>\u0230\3\2\2\2@"+
		"\u0240\3\2\2\2B\u024d\3\2\2\2D\u024f\3\2\2\2F\u0251\3\2\2\2H\u0262\3\2"+
		"\2\2J\u026c\3\2\2\2L\u026e\3\2\2\2N\u027f\3\2\2\2P\u0294\3\2\2\2R\u0296"+
		"\3\2\2\2T\u02a6\3\2\2\2V\u02a8\3\2\2\2X\u02aa\3\2\2\2Z\u02af\3\2\2\2\\"+
		"\u02b7\3\2\2\2^\u02c3\3\2\2\2`\u02c6\3\2\2\2b\u02d6\3\2\2\2d\u0311\3\2"+
		"\2\2f\u0313\3\2\2\2h\u0323\3\2\2\2j\u032e\3\2\2\2l\u0337\3\2\2\2n\u034c"+
		"\3\2\2\2p\u034e\3\2\2\2r\u035d\3\2\2\2t\u035f\3\2\2\2v\u0371\3\2\2\2x"+
		"\u0373\3\2\2\2z\u037e\3\2\2\2|\u038d\3\2\2\2~\u03bd\3\2\2\2\u0080\u03ed"+
		"\3\2\2\2\u0082\u03fa\3\2\2\2\u0084\u03fc\3\2\2\2\u0086\u040d\3\2\2\2\u0088"+
		"\u0410\3\2\2\2\u008a\u0420\3\2\2\2\u008c\u0422\3\2\2\2\u008e\u0453\3\2"+
		"\2\2\u0090\u0460\3\2\2\2\u0092\u0462\3\2\2\2\u0094\u0468\3\2\2\2\u0096"+
		"\u0474\3\2\2\2\u0098\u0477\3\2\2\2\u009a\u048a\3\2\2\2\u009c\u04b6\3\2"+
		"\2\2\u009e\u04c8\3\2\2\2\u00a0\u04cb\3\2\2\2\u00a2\u04cf\3\2\2\2\u00a4"+
		"\u04dc\3\2\2\2\u00a6\u04df\3\2\2\2\u00a8\u04e7\3\2\2\2\u00aa\u00cc\7k"+
		"\2\2\u00ab\u00cc\7l\2\2\u00ac\u00ae\7m\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00cc\3\2\2\2\u00b1"+
		"\u00b2\7=\2\2\u00b2\u00b3\5.\30\2\u00b3\u00b4\7>\2\2\u00b4\u00cc\3\2\2"+
		"\2\u00b5\u00cc\5\4\3\2\u00b6\u00b8\7\3\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7=\2\2\u00ba\u00bb\5\u0092J\2"+
		"\u00bb\u00bc\7>\2\2\u00bc\u00cc\3\2\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf"+
		"\7=\2\2\u00bf\u00c0\5\16\b\2\u00c0\u00c1\7Z\2\2\u00c1\u00c2\5z>\2\u00c2"+
		"\u00c3\7>\2\2\u00c3\u00cc\3\2\2\2\u00c4\u00c5\7\5\2\2\u00c5\u00c6\7=\2"+
		"\2\u00c6\u00c7\5z>\2\u00c7\u00c8\7Z\2\2\u00c8\u00c9\5\16\b\2\u00c9\u00ca"+
		"\7>\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00aa\3\2\2\2\u00cb\u00ab\3\2\2\2\u00cb"+
		"\u00ad\3\2\2\2\u00cb\u00b1\3\2\2\2\u00cb\u00b5\3\2\2\2\u00cb\u00b7\3\2"+
		"\2\2\u00cb\u00bd\3\2\2\2\u00cb\u00c4\3\2\2\2\u00cc\3\3\2\2\2\u00cd\u00ce"+
		"\78\2\2\u00ce\u00cf\7=\2\2\u00cf\u00d0\5*\26\2\u00d0\u00d1\7Z\2\2\u00d1"+
		"\u00d2\5\6\4\2\u00d2\u00d3\7>\2\2\u00d3\5\3\2\2\2\u00d4\u00d5\b\4\1\2"+
		"\u00d5\u00d6\5\b\5\2\u00d6\u00dc\3\2\2\2\u00d7\u00d8\f\3\2\2\u00d8\u00d9"+
		"\7Z\2\2\u00d9\u00db\5\b\5\2\u00da\u00d7\3\2\2\2\u00db\u00de\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\7\3\2\2\2\u00de\u00dc\3\2\2\2"+
		"\u00df\u00e0\5z>\2\u00e0\u00e1\7X\2\2\u00e1\u00e2\5*\26\2\u00e2\u00e7"+
		"\3\2\2\2\u00e3\u00e4\7\27\2\2\u00e4\u00e5\7X\2\2\u00e5\u00e7\5*\26\2\u00e6"+
		"\u00df\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e7\t\3\2\2\2\u00e8\u00e9\b\6\1\2"+
		"\u00e9\u010b\5\2\2\2\u00ea\u00eb\7=\2\2\u00eb\u00ec\5z>\2\u00ec\u00ed"+
		"\7>\2\2\u00ed\u00ee\7A\2\2\u00ee\u00ef\5\u0084C\2\u00ef\u00f0\7B\2\2\u00f0"+
		"\u010b\3\2\2\2\u00f1\u00f2\7=\2\2\u00f2\u00f3\5z>\2\u00f3\u00f4\7>\2\2"+
		"\u00f4\u00f5\7A\2\2\u00f5\u00f6\5\u0084C\2\u00f6\u00f7\7Z\2\2\u00f7\u00f8"+
		"\7B\2\2\u00f8\u010b\3\2\2\2\u00f9\u00fa\7\3\2\2\u00fa\u00fb\7=\2\2\u00fb"+
		"\u00fc\5z>\2\u00fc\u00fd\7>\2\2\u00fd\u00fe\7A\2\2\u00fe\u00ff\5\u0084"+
		"C\2\u00ff\u0100\7B\2\2\u0100\u010b\3\2\2\2\u0101\u0102\7\3\2\2\u0102\u0103"+
		"\7=\2\2\u0103\u0104\5z>\2\u0104\u0105\7>\2\2\u0105\u0106\7A\2\2\u0106"+
		"\u0107\5\u0084C\2\u0107\u0108\7Z\2\2\u0108\u0109\7B\2\2\u0109\u010b\3"+
		"\2\2\2\u010a\u00e8\3\2\2\2\u010a\u00ea\3\2\2\2\u010a\u00f1\3\2\2\2\u010a"+
		"\u00f9\3\2\2\2\u010a\u0101\3\2\2\2\u010b\u0123\3\2\2\2\u010c\u010d\f\f"+
		"\2\2\u010d\u010e\7?\2\2\u010e\u010f\5.\30\2\u010f\u0110\7@\2\2\u0110\u0122"+
		"\3\2\2\2\u0111\u0112\f\13\2\2\u0112\u0114\7=\2\2\u0113\u0115\5\f\7\2\u0114"+
		"\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0122\7>"+
		"\2\2\u0117\u0118\f\n\2\2\u0118\u0119\7i\2\2\u0119\u0122\7k\2\2\u011a\u011b"+
		"\f\t\2\2\u011b\u011c\7h\2\2\u011c\u0122\7k\2\2\u011d\u011e\f\b\2\2\u011e"+
		"\u0122\7J\2\2\u011f\u0120\f\7\2\2\u0120\u0122\7L\2\2\u0121\u010c\3\2\2"+
		"\2\u0121\u0111\3\2\2\2\u0121\u0117\3\2\2\2\u0121\u011a\3\2\2\2\u0121\u011d"+
		"\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2\2\2\u0123"+
		"\u0124\3\2\2\2\u0124\13\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\b\7\1"+
		"\2\u0127\u0128\5*\26\2\u0128\u012e\3\2\2\2\u0129\u012a\f\3\2\2\u012a\u012b"+
		"\7Z\2\2\u012b\u012d\5*\26\2\u012c\u0129\3\2\2\2\u012d\u0130\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\r\3\2\2\2\u0130\u012e\3\2\2\2"+
		"\u0131\u0148\5\n\6\2\u0132\u0133\7J\2\2\u0133\u0148\5\16\b\2\u0134\u0135"+
		"\7L\2\2\u0135\u0148\5\16\b\2\u0136\u0137\5\20\t\2\u0137\u0138\5\22\n\2"+
		"\u0138\u0148\3\2\2\2\u0139\u013a\7)\2\2\u013a\u0148\5\16\b\2\u013b\u013c"+
		"\7)\2\2\u013c\u013d\7=\2\2\u013d\u013e\5z>\2\u013e\u013f\7>\2\2\u013f"+
		"\u0148\3\2\2\2\u0140\u0141\7\64\2\2\u0141\u0142\7=\2\2\u0142\u0143\5z"+
		">\2\u0143\u0144\7>\2\2\u0144\u0148\3\2\2\2\u0145\u0146\7R\2\2\u0146\u0148"+
		"\7k\2\2\u0147\u0131\3\2\2\2\u0147\u0132\3\2\2\2\u0147\u0134\3\2\2\2\u0147"+
		"\u0136\3\2\2\2\u0147\u0139\3\2\2\2\u0147\u013b\3\2\2\2\u0147\u0140\3\2"+
		"\2\2\u0147\u0145\3\2\2\2\u0148\17\3\2\2\2\u0149\u014a\t\2\2\2\u014a\21"+
		"\3\2\2\2\u014b\u0158\5\16\b\2\u014c\u014d\7=\2\2\u014d\u014e\5z>\2\u014e"+
		"\u014f\7>\2\2\u014f\u0150\5\22\n\2\u0150\u0158\3\2\2\2\u0151\u0152\7\3"+
		"\2\2\u0152\u0153\7=\2\2\u0153\u0154\5z>\2\u0154\u0155\7>\2\2\u0155\u0156"+
		"\5\22\n\2\u0156\u0158\3\2\2\2\u0157\u014b\3\2\2\2\u0157\u014c\3\2\2\2"+
		"\u0157\u0151\3\2\2\2\u0158\23\3\2\2\2\u0159\u015a\b\13\1\2\u015a\u015b"+
		"\5\22\n\2\u015b\u0167\3\2\2\2\u015c\u015d\f\5\2\2\u015d\u015e\7M\2\2\u015e"+
		"\u0166\5\22\n\2\u015f\u0160\f\4\2\2\u0160\u0161\7N\2\2\u0161\u0166\5\22"+
		"\n\2\u0162\u0163\f\3\2\2\u0163\u0164\7O\2\2\u0164\u0166\5\22\n\2\u0165"+
		"\u015c\3\2\2\2\u0165\u015f\3\2\2\2\u0165\u0162\3\2\2\2\u0166\u0169\3\2"+
		"\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\25\3\2\2\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016b\b\f\1\2\u016b\u016c\5\24\13\2\u016c\u0175\3\2\2\2"+
		"\u016d\u016e\f\4\2\2\u016e\u016f\7I\2\2\u016f\u0174\5\24\13\2\u0170\u0171"+
		"\f\3\2\2\u0171\u0172\7K\2\2\u0172\u0174\5\24\13\2\u0173\u016d\3\2\2\2"+
		"\u0173\u0170\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176"+
		"\3\2\2\2\u0176\27\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u0179\b\r\1\2\u0179"+
		"\u017a\5\26\f\2\u017a\u0183\3\2\2\2\u017b\u017c\f\4\2\2\u017c\u017d\7"+
		"G\2\2\u017d\u0182\5\26\f\2\u017e\u017f\f\3\2\2\u017f\u0180\7H\2\2\u0180"+
		"\u0182\5\26\f\2\u0181\u017b\3\2\2\2\u0181\u017e\3\2\2\2\u0182\u0185\3"+
		"\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\31\3\2\2\2\u0185"+
		"\u0183\3\2\2\2\u0186\u0187\b\16\1\2\u0187\u0188\5\30\r\2\u0188\u0197\3"+
		"\2\2\2\u0189\u018a\f\6\2\2\u018a\u018b\7C\2\2\u018b\u0196\5\30\r\2\u018c"+
		"\u018d\f\5\2\2\u018d\u018e\7E\2\2\u018e\u0196\5\30\r\2\u018f\u0190\f\4"+
		"\2\2\u0190\u0191\7D\2\2\u0191\u0196\5\30\r\2\u0192\u0193\f\3\2\2\u0193"+
		"\u0194\7F\2\2\u0194\u0196\5\30\r\2\u0195\u0189\3\2\2\2\u0195\u018c\3\2"+
		"\2\2\u0195\u018f\3\2\2\2\u0195\u0192\3\2\2\2\u0196\u0199\3\2\2\2\u0197"+
		"\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\33\3\2\2\2\u0199\u0197\3\2\2"+
		"\2\u019a\u019b\b\17\1\2\u019b\u019c\5\32\16\2\u019c\u01a5\3\2\2\2\u019d"+
		"\u019e\f\4\2\2\u019e\u019f\7f\2\2\u019f\u01a4\5\32\16\2\u01a0\u01a1\f"+
		"\3\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a4\5\32\16\2\u01a3\u019d\3\2\2\2\u01a3"+
		"\u01a0\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2"+
		"\2\2\u01a6\35\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01a9\b\20\1\2\u01a9\u01aa"+
		"\5\34\17\2\u01aa\u01b0\3\2\2\2\u01ab\u01ac\f\3\2\2\u01ac\u01ad\7P\2\2"+
		"\u01ad\u01af\5\34\17\2\u01ae\u01ab\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae"+
		"\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1\37\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3"+
		"\u01b4\b\21\1\2\u01b4\u01b5\5\36\20\2\u01b5\u01bb\3\2\2\2\u01b6\u01b7"+
		"\f\3\2\2\u01b7\u01b8\7T\2\2\u01b8\u01ba\5\36\20\2\u01b9\u01b6\3\2\2\2"+
		"\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc!\3"+
		"\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\b\22\1\2\u01bf\u01c0\5 \21\2\u01c0"+
		"\u01c6\3\2\2\2\u01c1\u01c2\f\3\2\2\u01c2\u01c3\7Q\2\2\u01c3\u01c5\5 \21"+
		"\2\u01c4\u01c1\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c6\u01c7"+
		"\3\2\2\2\u01c7#\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\u01ca\b\23\1\2\u01ca"+
		"\u01cb\5\"\22\2\u01cb\u01d1\3\2\2\2\u01cc\u01cd\f\3\2\2\u01cd\u01ce\7"+
		"R\2\2\u01ce\u01d0\5\"\22\2\u01cf\u01cc\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2%\3\2\2\2\u01d3\u01d1\3\2\2\2"+
		"\u01d4\u01d5\b\24\1\2\u01d5\u01d6\5$\23\2\u01d6\u01dc\3\2\2\2\u01d7\u01d8"+
		"\f\3\2\2\u01d8\u01d9\7S\2\2\u01d9\u01db\5$\23\2\u01da\u01d7\3\2\2\2\u01db"+
		"\u01de\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\'\3\2\2\2"+
		"\u01de\u01dc\3\2\2\2\u01df\u01e5\5&\24\2\u01e0\u01e1\7W\2\2\u01e1\u01e2"+
		"\5.\30\2\u01e2\u01e3\7X\2\2\u01e3\u01e4\5(\25\2\u01e4\u01e6\3\2\2\2\u01e5"+
		"\u01e0\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6)\3\2\2\2\u01e7\u01ed\5(\25\2"+
		"\u01e8\u01e9\5\16\b\2\u01e9\u01ea\5,\27\2\u01ea\u01eb\5*\26\2\u01eb\u01ed"+
		"\3\2\2\2\u01ec\u01e7\3\2\2\2\u01ec\u01e8\3\2\2\2\u01ed+\3\2\2\2\u01ee"+
		"\u01ef\t\3\2\2\u01ef-\3\2\2\2\u01f0\u01f1\b\30\1\2\u01f1\u01f2\5*\26\2"+
		"\u01f2\u01f8\3\2\2\2\u01f3\u01f4\f\3\2\2\u01f4\u01f5\7Z\2\2\u01f5\u01f7"+
		"\5*\26\2\u01f6\u01f3\3\2\2\2\u01f7\u01fa\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f8"+
		"\u01f9\3\2\2\2\u01f9/\3\2\2\2\u01fa\u01f8\3\2\2\2\u01fb\u01fc\5(\25\2"+
		"\u01fc\61\3\2\2\2\u01fd\u01ff\5\64\33\2\u01fe\u0200\5:\36\2\u01ff\u01fe"+
		"\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\7Y\2\2\u0202"+
		"\u0205\3\2\2\2\u0203\u0205\5\u008cG\2\u0204\u01fd\3\2\2\2\u0204\u0203"+
		"\3\2\2\2\u0205\63\3\2\2\2\u0206\u0208\58\35\2\u0207\u0206\3\2\2\2\u0208"+
		"\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\65\3\2\2"+
		"\2\u020b\u020d\58\35\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c"+
		"\3\2\2\2\u020e\u020f\3\2\2\2\u020f\67\3\2\2\2\u0210\u0216\5> \2\u0211"+
		"\u0216\5@!\2\u0212\u0216\5Z.\2\u0213\u0216\5\\/\2\u0214\u0216\5^\60\2"+
		"\u0215\u0210\3\2\2\2\u0215\u0211\3\2\2\2\u0215\u0212\3\2\2\2\u0215\u0213"+
		"\3\2\2\2\u0215\u0214\3\2\2\2\u02169\3\2\2\2\u0217\u0218\b\36\1\2\u0218"+
		"\u0219\5<\37\2\u0219\u021f\3\2\2\2\u021a\u021b\f\3\2\2\u021b\u021c\7Z"+
		"\2\2\u021c\u021e\5<\37\2\u021d\u021a\3\2\2\2\u021e\u0221\3\2\2\2\u021f"+
		"\u021d\3\2\2\2\u021f\u0220\3\2\2\2\u0220;\3\2\2\2\u0221\u021f\3\2\2\2"+
		"\u0222\u0228\5`\61\2\u0223\u0224\5`\61\2\u0224\u0225\7[\2\2\u0225\u0226"+
		"\5\u0082B\2\u0226\u0228\3\2\2\2\u0227\u0222\3\2\2\2\u0227\u0223\3\2\2"+
		"\2\u0228=\3\2\2\2\u0229\u022a\7-\2\2\u022a\u0231\b \1\2\u022b\u0231\7"+
		"\34\2\2\u022c\u0231\7*\2\2\u022d\u0231\7<\2\2\u022e\u0231\7\21\2\2\u022f"+
		"\u0231\7$\2\2\u0230\u0229\3\2\2\2\u0230\u022b\3\2\2\2\u0230\u022c\3\2"+
		"\2\2\u0230\u022d\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u022f\3\2\2\2\u0231"+
		"?\3\2\2\2\u0232\u0241\t\4\2\2\u0233\u0234\7\3\2\2\u0234\u0235\7=\2\2\u0235"+
		"\u0236\t\5\2\2\u0236\u0241\7>\2\2\u0237\u0241\5X-\2\u0238\u0241\5B\"\2"+
		"\u0239\u0241\5P)\2\u023a\u0241\5\u0080A\2\u023b\u023c\7\t\2\2\u023c\u023d"+
		"\7=\2\2\u023d\u023e\5\60\31\2\u023e\u023f\7>\2\2\u023f\u0241\3\2\2\2\u0240"+
		"\u0232\3\2\2\2\u0240\u0233\3\2\2\2\u0240\u0237\3\2\2\2\u0240\u0238\3\2"+
		"\2\2\u0240\u0239\3\2\2\2\u0240\u023a\3\2\2\2\u0240\u023b\3\2\2\2\u0241"+
		"A\3\2\2\2\u0242\u0244\5D#\2\u0243\u0245\7k\2\2\u0244\u0243\3\2\2\2\u0244"+
		"\u0245\3\2\2\2\u0245\u0246\3\2\2\2\u0246\u0247\7A\2\2\u0247\u0248\5F$"+
		"\2\u0248\u0249\7B\2\2\u0249\u024e\3\2\2\2\u024a\u024b\5D#\2\u024b\u024c"+
		"\7k\2\2\u024c\u024e\3\2\2\2\u024d\u0242\3\2\2\2\u024d\u024a\3\2\2\2\u024e"+
		"C\3\2\2\2\u024f\u0250\t\6\2\2\u0250E\3\2\2\2\u0251\u0252\b$\1\2\u0252"+
		"\u0253\5H%\2\u0253\u0258\3\2\2\2\u0254\u0255\f\3\2\2\u0255\u0257\5H%\2"+
		"\u0256\u0254\3\2\2\2\u0257\u025a\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0259"+
		"\3\2\2\2\u0259G\3\2\2\2\u025a\u0258\3\2\2\2\u025b\u025d\5J&\2\u025c\u025e"+
		"\5L\'\2\u025d\u025c\3\2\2\2\u025d\u025e\3\2\2\2\u025e\u025f\3\2\2\2\u025f"+
		"\u0260\7Y\2\2\u0260\u0263\3\2\2\2\u0261\u0263\5\u008cG\2\u0262\u025b\3"+
		"\2\2\2\u0262\u0261\3\2\2\2\u0263I\3\2\2\2\u0264\u0266\5@!\2\u0265\u0267"+
		"\5J&\2\u0266\u0265\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u026d\3\2\2\2\u0268"+
		"\u026a\5Z.\2\u0269\u026b\5J&\2\u026a\u0269\3\2\2\2\u026a\u026b\3\2\2\2"+
		"\u026b\u026d\3\2\2\2\u026c\u0264\3\2\2\2\u026c\u0268\3\2\2\2\u026dK\3"+
		"\2\2\2\u026e\u026f\b\'\1\2\u026f\u0270\5N(\2\u0270\u0276\3\2\2\2\u0271"+
		"\u0272\f\3\2\2\u0272\u0273\7Z\2\2\u0273\u0275\5N(\2\u0274\u0271\3\2\2"+
		"\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2\2\u0276\u0277\3\2\2\2\u0277M"+
		"\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u0280\5`\61\2\u027a\u027c\5`\61\2\u027b"+
		"\u027a\3\2\2\2\u027b\u027c\3\2\2\2\u027c\u027d\3\2\2\2\u027d\u027e\7X"+
		"\2\2\u027e\u0280\5\60\31\2\u027f\u0279\3\2\2\2\u027f\u027b\3\2\2\2\u0280"+
		"O\3\2\2\2\u0281\u0283\7\33\2\2\u0282\u0284\7k\2\2\u0283\u0282\3\2\2\2"+
		"\u0283\u0284\3\2\2\2\u0284\u0285\3\2\2\2\u0285\u0286\7A\2\2\u0286\u0287"+
		"\5R*\2\u0287\u0288\7B\2\2\u0288\u0295\3\2\2\2\u0289\u028b\7\33\2\2\u028a"+
		"\u028c\7k\2\2\u028b\u028a\3\2\2\2\u028b\u028c\3\2\2\2\u028c\u028d\3\2"+
		"\2\2\u028d\u028e\7A\2\2\u028e\u028f\5R*\2\u028f\u0290\7Z\2\2\u0290\u0291"+
		"\7B\2\2\u0291\u0295\3\2\2\2\u0292\u0293\7\33\2\2\u0293\u0295\7k\2\2\u0294"+
		"\u0281\3\2\2\2\u0294\u0289\3\2\2\2\u0294\u0292\3\2\2\2\u0295Q\3\2\2\2"+
		"\u0296\u0297\b*\1\2\u0297\u0298\5T+\2\u0298\u029e\3\2\2\2\u0299\u029a"+
		"\f\3\2\2\u029a\u029b\7Z\2\2\u029b\u029d\5T+\2\u029c\u0299\3\2\2\2\u029d"+
		"\u02a0\3\2\2\2\u029e\u029c\3\2\2\2\u029e\u029f\3\2\2\2\u029fS\3\2\2\2"+
		"\u02a0\u029e\3\2\2\2\u02a1\u02a7\5V,\2\u02a2\u02a3\5V,\2\u02a3\u02a4\7"+
		"[\2\2\u02a4\u02a5\5\60\31\2\u02a5\u02a7\3\2\2\2\u02a6\u02a1\3\2\2\2\u02a6"+
		"\u02a2\3\2\2\2\u02a7U\3\2\2\2\u02a8\u02a9\7k\2\2\u02a9W\3\2\2\2\u02aa"+
		"\u02ab\7\65\2\2\u02ab\u02ac\7=\2\2\u02ac\u02ad\5z>\2\u02ad\u02ae\7>\2"+
		"\2\u02aeY\3\2\2\2\u02af\u02b0\t\7\2\2\u02b0[\3\2\2\2\u02b1\u02b8\t\b\2"+
		"\2\u02b2\u02b8\5f\64\2\u02b3\u02b4\7\f\2\2\u02b4\u02b5\7=\2\2\u02b5\u02b6"+
		"\7k\2\2\u02b6\u02b8\7>\2\2\u02b7\u02b1\3\2\2\2\u02b7\u02b2\3\2\2\2\u02b7"+
		"\u02b3\3\2\2\2\u02b8]\3\2\2\2\u02b9\u02ba\7\63\2\2\u02ba\u02bb\7=\2\2"+
		"\u02bb\u02bc\5z>\2\u02bc\u02bd\7>\2\2\u02bd\u02c4\3\2\2\2\u02be\u02bf"+
		"\7\63\2\2\u02bf\u02c0\7=\2\2\u02c0\u02c1\5\60\31\2\u02c1\u02c2\7>\2\2"+
		"\u02c2\u02c4\3\2\2\2\u02c3\u02b9\3\2\2\2\u02c3\u02be\3\2\2\2\u02c4_\3"+
		"\2\2\2\u02c5\u02c7\5n8\2\u02c6\u02c5\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7"+
		"\u02c8\3\2\2\2\u02c8\u02cc\5b\62\2\u02c9\u02cb\5d\63\2\u02ca\u02c9\3\2"+
		"\2\2\u02cb\u02ce\3\2\2\2\u02cc\u02ca\3\2\2\2\u02cc\u02cd\3\2\2\2\u02cd"+
		"a\3\2\2\2\u02ce\u02cc\3\2\2\2\u02cf\u02d0\b\62\1\2\u02d0\u02d1\7k\2\2"+
		"\u02d1\u02d7\b\62\1\2\u02d2\u02d3\7=\2\2\u02d3\u02d4\5`\61\2\u02d4\u02d5"+
		"\7>\2\2\u02d5\u02d7\3\2\2\2\u02d6\u02cf\3\2\2\2\u02d6\u02d2\3\2\2\2\u02d7"+
		"\u0305\3\2\2\2\u02d8\u02d9\f\b\2\2\u02d9\u02db\7?\2\2\u02da\u02dc\5p9"+
		"\2\u02db\u02da\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02de\3\2\2\2\u02dd\u02df"+
		"\5*\26\2\u02de\u02dd\3\2\2\2\u02de\u02df\3\2\2\2\u02df\u02e0\3\2\2\2\u02e0"+
		"\u0304\7@\2\2\u02e1\u02e2\f\7\2\2\u02e2\u02e3\7?\2\2\u02e3\u02e5\7*\2"+
		"\2\u02e4\u02e6\5p9\2\u02e5\u02e4\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6\u02e7"+
		"\3\2\2\2\u02e7\u02e8\5*\26\2\u02e8\u02e9\7@\2\2\u02e9\u0304\3\2\2\2\u02ea"+
		"\u02eb\f\6\2\2\u02eb\u02ec\7?\2\2\u02ec\u02ed\5p9\2\u02ed\u02ee\7*\2\2"+
		"\u02ee\u02ef\5*\26\2\u02ef\u02f0\7@\2\2\u02f0\u0304\3\2\2\2\u02f1\u02f2"+
		"\f\5\2\2\u02f2\u02f4\7?\2\2\u02f3\u02f5\5p9\2\u02f4\u02f3\3\2\2\2\u02f4"+
		"\u02f5\3\2\2\2\u02f5\u02f6\3\2\2\2\u02f6\u02f7\7M\2\2\u02f7\u0304\7@\2"+
		"\2\u02f8\u02f9\f\4\2\2\u02f9\u02fa\7=\2\2\u02fa\u02fb\5r:\2\u02fb\u02fc"+
		"\7>\2\2\u02fc\u0304\3\2\2\2\u02fd\u02fe\f\3\2\2\u02fe\u0300\7=\2\2\u02ff"+
		"\u0301\5x=\2\u0300\u02ff\3\2\2\2\u0300\u0301\3\2\2\2\u0301\u0302\3\2\2"+
		"\2\u0302\u0304\7>\2\2\u0303\u02d8\3\2\2\2\u0303\u02e1\3\2\2\2\u0303\u02ea"+
		"\3\2\2\2\u0303\u02f1\3\2\2\2\u0303\u02f8\3\2\2\2\u0303\u02fd\3\2\2\2\u0304"+
		"\u0307\3\2\2\2\u0305\u0303\3\2\2\2\u0305\u0306\3\2\2\2\u0306c\3\2\2\2"+
		"\u0307\u0305\3\2\2\2\u0308\u0309\7\r\2\2\u0309\u030b\7=\2\2\u030a\u030c"+
		"\7m\2\2\u030b\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030b\3\2\2\2\u030d"+
		"\u030e\3\2\2\2\u030e\u030f\3\2\2\2\u030f\u0312\7>\2\2\u0310\u0312\5f\64"+
		"\2\u0311\u0308\3\2\2\2\u0311\u0310\3\2\2\2\u0312e\3\2\2\2\u0313\u0314"+
		"\7\16\2\2\u0314\u0315\7=\2\2\u0315\u0316\7=\2\2\u0316\u0317\5h\65\2\u0317"+
		"\u0318\7>\2\2\u0318\u0319\7>\2\2\u0319g\3\2\2\2\u031a\u031f\5j\66\2\u031b"+
		"\u031c\7Z\2\2\u031c\u031e\5j\66\2\u031d\u031b\3\2\2\2\u031e\u0321\3\2"+
		"\2\2\u031f\u031d\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0324\3\2\2\2\u0321"+
		"\u031f\3\2\2\2\u0322\u0324\3\2\2\2\u0323\u031a\3\2\2\2\u0323\u0322\3\2"+
		"\2\2\u0324i\3\2\2\2\u0325\u032b\n\t\2\2\u0326\u0328\7=\2\2\u0327\u0329"+
		"\5\f\7\2\u0328\u0327\3\2\2\2\u0328\u0329\3\2\2\2\u0329\u032a\3\2\2\2\u032a"+
		"\u032c\7>\2\2\u032b\u0326\3\2\2\2\u032b\u032c\3\2\2\2\u032c\u032f\3\2"+
		"\2\2\u032d\u032f\3\2\2\2\u032e\u0325\3\2\2\2\u032e\u032d\3\2\2\2\u032f"+
		"k\3\2\2\2\u0330\u0336\n\n\2\2\u0331\u0332\7=\2\2\u0332\u0333\5l\67\2\u0333"+
		"\u0334\7>\2\2\u0334\u0336\3\2\2\2\u0335\u0330\3\2\2\2\u0335\u0331\3\2"+
		"\2\2\u0336\u0339\3\2\2\2\u0337\u0335\3\2\2\2\u0337\u0338\3\2\2\2\u0338"+
		"m\3\2\2\2\u0339\u0337\3\2\2\2\u033a\u033c\7M\2\2\u033b\u033d\5p9\2\u033c"+
		"\u033b\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u034d\3\2\2\2\u033e\u0340\7M"+
		"\2\2\u033f\u0341\5p9\2\u0340\u033f\3\2\2\2\u0340\u0341\3\2\2\2\u0341\u0342"+
		"\3\2\2\2\u0342\u034d\5n8\2\u0343\u0345\7T\2\2\u0344\u0346\5p9\2\u0345"+
		"\u0344\3\2\2\2\u0345\u0346\3\2\2\2\u0346\u034d\3\2\2\2\u0347\u0349\7T"+
		"\2\2\u0348\u034a\5p9\2\u0349\u0348\3\2\2\2\u0349\u034a\3\2\2\2\u034a\u034b"+
		"\3\2\2\2\u034b\u034d\5n8\2\u034c\u033a\3\2\2\2\u034c\u033e\3\2\2\2\u034c"+
		"\u0343\3\2\2\2\u034c\u0347\3\2\2\2\u034do\3\2\2\2\u034e\u034f\b9\1\2\u034f"+
		"\u0350\5Z.\2\u0350\u0355\3\2\2\2\u0351\u0352\f\3\2\2\u0352\u0354\5Z.\2"+
		"\u0353\u0351\3\2\2\2\u0354\u0357\3\2\2\2\u0355\u0353\3\2\2\2\u0355\u0356"+
		"\3\2\2\2\u0356q\3\2\2\2\u0357\u0355\3\2\2\2\u0358\u035e\5t;\2\u0359\u035a"+
		"\5t;\2\u035a\u035b\7Z\2\2\u035b\u035c\7j\2\2\u035c\u035e\3\2\2\2\u035d"+
		"\u0358\3\2\2\2\u035d\u0359\3\2\2\2\u035es\3\2\2\2\u035f\u0360\b;\1\2\u0360"+
		"\u0361\5v<\2\u0361\u0367\3\2\2\2\u0362\u0363\f\3\2\2\u0363\u0364\7Z\2"+
		"\2\u0364\u0366\5v<\2\u0365\u0362\3\2\2\2\u0366\u0369\3\2\2\2\u0367\u0365"+
		"\3\2\2\2\u0367\u0368\3\2\2\2\u0368u\3\2\2\2\u0369\u0367\3\2\2\2\u036a"+
		"\u036b\5\64\33\2\u036b\u036c\5`\61\2\u036c\u0372\3\2\2\2\u036d\u036f\5"+
		"\66\34\2\u036e\u0370\5|?\2\u036f\u036e\3\2\2\2\u036f\u0370\3\2\2\2\u0370"+
		"\u0372\3\2\2\2\u0371\u036a\3\2\2\2\u0371\u036d\3\2\2\2\u0372w\3\2\2\2"+
		"\u0373\u0374\b=\1\2\u0374\u0375\7k\2\2\u0375\u037b\3\2\2\2\u0376\u0377"+
		"\f\3\2\2\u0377\u0378\7Z\2\2\u0378\u037a\7k\2\2\u0379\u0376\3\2\2\2\u037a"+
		"\u037d\3\2\2\2\u037b\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037cy\3\2\2\2"+
		"\u037d\u037b\3\2\2\2\u037e\u0380\5J&\2\u037f\u0381\5|?\2\u0380\u037f\3"+
		"\2\2\2\u0380\u0381\3\2\2\2\u0381{\3\2\2\2\u0382\u038e\5n8\2\u0383\u0385"+
		"\5n8\2\u0384\u0383\3\2\2\2\u0384\u0385\3\2\2\2\u0385\u0386\3\2\2\2\u0386"+
		"\u038a\5~@\2\u0387\u0389\5d\63\2\u0388\u0387\3\2\2\2\u0389\u038c\3\2\2"+
		"\2\u038a\u0388\3\2\2\2\u038a\u038b\3\2\2\2\u038b\u038e\3\2\2\2\u038c\u038a"+
		"\3\2\2\2\u038d\u0382\3\2\2\2\u038d\u0384\3\2\2\2\u038e}\3\2\2\2\u038f"+
		"\u0390\b@\1\2\u0390\u0391\7=\2\2\u0391\u0392\5|?\2\u0392\u0396\7>\2\2"+
		"\u0393\u0395\5d\63\2\u0394\u0393\3\2\2\2\u0395\u0398\3\2\2\2\u0396\u0394"+
		"\3\2\2\2\u0396\u0397\3\2\2\2\u0397\u03be\3\2\2\2\u0398\u0396\3\2\2\2\u0399"+
		"\u039b\7?\2\2\u039a\u039c\5p9\2\u039b\u039a\3\2\2\2\u039b\u039c\3\2\2"+
		"\2\u039c\u039e\3\2\2\2\u039d\u039f\5*\26\2\u039e\u039d\3\2\2\2\u039e\u039f"+
		"\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u03be\7@\2\2\u03a1\u03a2\7?\2\2\u03a2"+
		"\u03a4\7*\2\2\u03a3\u03a5\5p9\2\u03a4\u03a3\3\2\2\2\u03a4\u03a5\3\2\2"+
		"\2\u03a5\u03a6\3\2\2\2\u03a6\u03a7\5*\26\2\u03a7\u03a8\7@\2\2\u03a8\u03be"+
		"\3\2\2\2\u03a9\u03aa\7?\2\2\u03aa\u03ab\5p9\2\u03ab\u03ac\7*\2\2\u03ac"+
		"\u03ad\5*\26\2\u03ad\u03ae\7@\2\2\u03ae\u03be\3\2\2\2\u03af\u03b0\7?\2"+
		"\2\u03b0\u03b1\7M\2\2\u03b1\u03be\7@\2\2\u03b2\u03b4\7=\2\2\u03b3\u03b5"+
		"\5r:\2\u03b4\u03b3\3\2\2\2\u03b4\u03b5\3\2\2\2\u03b5\u03b6\3\2\2\2\u03b6"+
		"\u03ba\7>\2\2\u03b7\u03b9\5d\63\2\u03b8\u03b7\3\2\2\2\u03b9\u03bc\3\2"+
		"\2\2\u03ba\u03b8\3\2\2\2\u03ba\u03bb\3\2\2\2\u03bb\u03be\3\2\2\2\u03bc"+
		"\u03ba\3\2\2\2\u03bd\u038f\3\2\2\2\u03bd\u0399\3\2\2\2\u03bd\u03a1\3\2"+
		"\2\2\u03bd\u03a9\3\2\2\2\u03bd\u03af\3\2\2\2\u03bd\u03b2\3\2\2\2\u03be"+
		"\u03ea\3\2\2\2\u03bf\u03c0\f\7\2\2\u03c0\u03c2\7?\2\2\u03c1\u03c3\5p9"+
		"\2\u03c2\u03c1\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c5\3\2\2\2\u03c4\u03c6"+
		"\5*\26\2\u03c5\u03c4\3\2\2\2\u03c5\u03c6\3\2\2\2\u03c6\u03c7\3\2\2\2\u03c7"+
		"\u03e9\7@\2\2\u03c8\u03c9\f\6\2\2\u03c9\u03ca\7?\2\2\u03ca\u03cc\7*\2"+
		"\2\u03cb\u03cd\5p9\2\u03cc\u03cb\3\2\2\2\u03cc\u03cd\3\2\2\2\u03cd\u03ce"+
		"\3\2\2\2\u03ce\u03cf\5*\26\2\u03cf\u03d0\7@\2\2\u03d0\u03e9\3\2\2\2\u03d1"+
		"\u03d2\f\5\2\2\u03d2\u03d3\7?\2\2\u03d3\u03d4\5p9\2\u03d4\u03d5\7*\2\2"+
		"\u03d5\u03d6\5*\26\2\u03d6\u03d7\7@\2\2\u03d7\u03e9\3\2\2\2\u03d8\u03d9"+
		"\f\4\2\2\u03d9\u03da\7?\2\2\u03da\u03db\7M\2\2\u03db\u03e9\7@\2\2\u03dc"+
		"\u03dd\f\3\2\2\u03dd\u03df\7=\2\2\u03de\u03e0\5r:\2\u03df\u03de\3\2\2"+
		"\2\u03df\u03e0\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e5\7>\2\2\u03e2\u03e4"+
		"\5d\63\2\u03e3\u03e2\3\2\2\2\u03e4\u03e7\3\2\2\2\u03e5\u03e3\3\2\2\2\u03e5"+
		"\u03e6\3\2\2\2\u03e6\u03e9\3\2\2\2\u03e7\u03e5\3\2\2\2\u03e8\u03bf\3\2"+
		"\2\2\u03e8\u03c8\3\2\2\2\u03e8\u03d1\3\2\2\2\u03e8\u03d8\3\2\2\2\u03e8"+
		"\u03dc\3\2\2\2\u03e9\u03ec\3\2\2\2\u03ea\u03e8\3\2\2\2\u03ea\u03eb\3\2"+
		"\2\2\u03eb\177\3\2\2\2\u03ec\u03ea\3\2\2\2\u03ed\u03ee\6A/\2\u03ee\u03ef"+
		"\7k\2\2\u03ef\u0081\3\2\2\2\u03f0\u03fb\5*\26\2\u03f1\u03f2\7A\2\2\u03f2"+
		"\u03f3\5\u0084C\2\u03f3\u03f4\7B\2\2\u03f4\u03fb\3\2\2\2\u03f5\u03f6\7"+
		"A\2\2\u03f6\u03f7\5\u0084C\2\u03f7\u03f8\7Z\2\2\u03f8\u03f9\7B\2\2\u03f9"+
		"\u03fb\3\2\2\2\u03fa\u03f0\3\2\2\2\u03fa\u03f1\3\2\2\2\u03fa\u03f5\3\2"+
		"\2\2\u03fb\u0083\3\2\2\2\u03fc\u03fe\bC\1\2\u03fd\u03ff\5\u0086D\2\u03fe"+
		"\u03fd\3\2\2\2\u03fe\u03ff\3\2\2\2\u03ff\u0400\3\2\2\2\u0400\u0401\5\u0082"+
		"B\2\u0401\u040a\3\2\2\2\u0402\u0403\f\3\2\2\u0403\u0405\7Z\2\2\u0404\u0406"+
		"\5\u0086D\2\u0405\u0404\3\2\2\2\u0405\u0406\3\2\2\2\u0406\u0407\3\2\2"+
		"\2\u0407\u0409\5\u0082B\2\u0408\u0402\3\2\2\2\u0409\u040c\3\2\2\2\u040a"+
		"\u0408\3\2\2\2\u040a\u040b\3\2\2\2\u040b\u0085\3\2\2\2\u040c\u040a\3\2"+
		"\2\2\u040d\u040e\5\u0088E\2\u040e\u040f\7[\2\2\u040f\u0087\3\2\2\2\u0410"+
		"\u0411\bE\1\2\u0411\u0412\5\u008aF\2\u0412\u0417\3\2\2\2\u0413\u0414\f"+
		"\3\2\2\u0414\u0416\5\u008aF\2\u0415\u0413\3\2\2\2\u0416\u0419\3\2\2\2"+
		"\u0417\u0415\3\2\2\2\u0417\u0418\3\2\2\2\u0418\u0089\3\2\2\2\u0419\u0417"+
		"\3\2\2\2\u041a\u041b\7?\2\2\u041b\u041c\5\60\31\2\u041c\u041d\7@\2\2\u041d"+
		"\u0421\3\2\2\2\u041e\u041f\7i\2\2\u041f\u0421\7k\2\2\u0420\u041a\3\2\2"+
		"\2\u0420\u041e\3\2\2\2\u0421\u008b\3\2\2\2\u0422\u0423\7;\2\2\u0423\u0424"+
		"\7=\2\2\u0424\u0425\5\60\31\2\u0425\u0427\7Z\2\2\u0426\u0428\7m\2\2\u0427"+
		"\u0426\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u0427\3\2\2\2\u0429\u042a\3\2"+
		"\2\2\u042a\u042b\3\2\2\2\u042b\u042c\7>\2\2\u042c\u042d\7Y\2\2\u042d\u008d"+
		"\3\2\2\2\u042e\u0454\5\u0090I\2\u042f\u0454\5\u0092J\2\u0430\u0454\5\u0098"+
		"M\2\u0431\u0454\5\u009aN\2\u0432\u0454\5\u009cO\2\u0433\u0454\5\u009e"+
		"P\2\u0434\u0435\t\13\2\2\u0435\u0436\t\f\2\2\u0436\u043f\7=\2\2\u0437"+
		"\u043c\5&\24\2\u0438\u0439\7Z\2\2\u0439\u043b\5&\24\2\u043a\u0438\3\2"+
		"\2\2\u043b\u043e\3\2\2\2\u043c\u043a\3\2\2\2\u043c\u043d\3\2\2\2\u043d"+
		"\u0440\3\2\2\2\u043e\u043c\3\2\2\2\u043f\u0437\3\2\2\2\u043f\u0440\3\2"+
		"\2\2\u0440\u044e\3\2\2\2\u0441\u044a\7X\2\2\u0442\u0447\5&\24\2\u0443"+
		"\u0444\7Z\2\2\u0444\u0446\5&\24\2\u0445\u0443\3\2\2\2\u0446\u0449\3\2"+
		"\2\2\u0447\u0445\3\2\2\2\u0447\u0448\3\2\2\2\u0448\u044b\3\2\2\2\u0449"+
		"\u0447\3\2\2\2\u044a\u0442\3\2\2\2\u044a\u044b\3\2\2\2\u044b\u044d\3\2"+
		"\2\2\u044c\u0441\3\2\2\2\u044d\u0450\3\2\2\2\u044e\u044c\3\2\2\2\u044e"+
		"\u044f\3\2\2\2\u044f\u0451\3\2\2\2\u0450\u044e\3\2\2\2\u0451\u0452\7>"+
		"\2\2\u0452\u0454\7Y\2\2\u0453\u042e\3\2\2\2\u0453\u042f\3\2\2\2\u0453"+
		"\u0430\3\2\2\2\u0453\u0431\3\2\2\2\u0453\u0432\3\2\2\2\u0453\u0433\3\2"+
		"\2\2\u0453\u0434\3\2\2\2\u0454\u008f\3\2\2\2\u0455\u0456\7k\2\2\u0456"+
		"\u0457\7X\2\2\u0457\u0461\5\u008eH\2\u0458\u0459\7\23\2\2\u0459\u045a"+
		"\5\60\31\2\u045a\u045b\7X\2\2\u045b\u045c\5\u008eH\2\u045c\u0461\3\2\2"+
		"\2\u045d\u045e\7\27\2\2\u045e\u045f\7X\2\2\u045f\u0461\5\u008eH\2\u0460"+
		"\u0455\3\2\2\2\u0460\u0458\3\2\2\2\u0460\u045d\3\2\2\2\u0461\u0091\3\2"+
		"\2\2\u0462\u0464\7A\2\2\u0463\u0465\5\u0094K\2\u0464\u0463\3\2\2\2\u0464"+
		"\u0465\3\2\2\2\u0465\u0466\3\2\2\2\u0466\u0467\7B\2\2\u0467\u0093\3\2"+
		"\2\2\u0468\u0469\bK\1\2\u0469\u046a\5\u0096L\2\u046a\u046f\3\2\2\2\u046b"+
		"\u046c\f\3\2\2\u046c\u046e\5\u0096L\2\u046d\u046b\3\2\2\2\u046e\u0471"+
		"\3\2\2\2\u046f\u046d\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0095\3\2\2\2\u0471"+
		"\u046f\3\2\2\2\u0472\u0475\5\62\32\2\u0473\u0475\5\u008eH\2\u0474\u0472"+
		"\3\2\2\2\u0474\u0473\3\2\2\2\u0475\u0097\3\2\2\2\u0476\u0478\5.\30\2\u0477"+
		"\u0476\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u0479\3\2\2\2\u0479\u047a\7Y"+
		"\2\2\u047a\u0099\3\2\2\2\u047b\u047c\7 \2\2\u047c\u047d\7=\2\2\u047d\u047e"+
		"\5.\30\2\u047e\u047f\7>\2\2\u047f\u0482\5\u008eH\2\u0480\u0481\7\32\2"+
		"\2\u0481\u0483\5\u008eH\2\u0482\u0480\3\2\2\2\u0482\u0483\3\2\2\2\u0483"+
		"\u048b\3\2\2\2\u0484\u0485\7,\2\2\u0485\u0486\7=\2\2\u0486\u0487\5.\30"+
		"\2\u0487\u0488\7>\2\2\u0488\u0489\5\u008eH\2\u0489\u048b\3\2\2\2\u048a"+
		"\u047b\3\2\2\2\u048a\u0484\3\2\2\2\u048b\u009b\3\2\2\2\u048c\u048d\7\62"+
		"\2\2\u048d\u048e\7=\2\2\u048e\u048f\5.\30\2\u048f\u0490\7>\2\2\u0490\u0491"+
		"\5\u008eH\2\u0491\u04b7\3\2\2\2\u0492\u0493\7\30\2\2\u0493\u0494\5\u008e"+
		"H\2\u0494\u0495\7\62\2\2\u0495\u0496\7=\2\2\u0496\u0497\5.\30\2\u0497"+
		"\u0498\7>\2\2\u0498\u0499\7Y\2\2\u0499\u04b7\3\2\2\2\u049a\u049b\7\36"+
		"\2\2\u049b\u049d\7=\2\2\u049c\u049e\5.\30\2\u049d\u049c\3\2\2\2\u049d"+
		"\u049e\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a1\7Y\2\2\u04a0\u04a2\5.\30"+
		"\2\u04a1\u04a0\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a3\3\2\2\2\u04a3\u04a5"+
		"\7Y\2\2\u04a4\u04a6\5.\30\2\u04a5\u04a4\3\2\2\2\u04a5\u04a6\3\2\2\2\u04a6"+
		"\u04a7\3\2\2\2\u04a7\u04a8\7>\2\2\u04a8\u04b7\5\u008eH\2\u04a9\u04aa\7"+
		"\36\2\2\u04aa\u04ab\7=\2\2\u04ab\u04ad\5\62\32\2\u04ac\u04ae\5.\30\2\u04ad"+
		"\u04ac\3\2\2\2\u04ad\u04ae\3\2\2\2\u04ae\u04af\3\2\2\2\u04af\u04b1\7Y"+
		"\2\2\u04b0\u04b2\5.\30\2\u04b1\u04b0\3\2\2\2\u04b1\u04b2\3\2\2\2\u04b2"+
		"\u04b3\3\2\2\2\u04b3\u04b4\7>\2\2\u04b4\u04b5\5\u008eH\2\u04b5\u04b7\3"+
		"\2\2\2\u04b6\u048c\3\2\2\2\u04b6\u0492\3\2\2\2\u04b6\u049a\3\2\2\2\u04b6"+
		"\u04a9\3\2\2\2\u04b7\u009d\3\2\2\2\u04b8\u04b9\7\37\2\2\u04b9\u04ba\7"+
		"k\2\2\u04ba\u04c9\7Y\2\2\u04bb\u04bc\7\26\2\2\u04bc\u04c9\7Y\2\2\u04bd"+
		"\u04be\7\22\2\2\u04be\u04c9\7Y\2\2\u04bf\u04c1\7&\2\2\u04c0\u04c2\5.\30"+
		"\2\u04c1\u04c0\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u04c3\3\2\2\2\u04c3\u04c9"+
		"\7Y\2\2\u04c4\u04c5\7\37\2\2\u04c5\u04c6\5\16\b\2\u04c6\u04c7\7Y\2\2\u04c7"+
		"\u04c9\3\2\2\2\u04c8\u04b8\3\2\2\2\u04c8\u04bb\3\2\2\2\u04c8\u04bd\3\2"+
		"\2\2\u04c8\u04bf\3\2\2\2\u04c8\u04c4\3\2\2\2\u04c9\u009f\3\2\2\2\u04ca"+
		"\u04cc\5\u00a2R\2\u04cb\u04ca\3\2\2\2\u04cb\u04cc\3\2\2\2\u04cc\u04cd"+
		"\3\2\2\2\u04cd\u04ce\7\2\2\3\u04ce\u00a1\3\2\2\2\u04cf\u04d0\bR\1\2\u04d0"+
		"\u04d1\5\u00a4S\2\u04d1\u04d6\3\2\2\2\u04d2\u04d3\f\3\2\2\u04d3\u04d5"+
		"\5\u00a4S\2\u04d4\u04d2\3\2\2\2\u04d5\u04d8\3\2\2\2\u04d6\u04d4\3\2\2"+
		"\2\u04d6\u04d7\3\2\2\2\u04d7\u00a3\3\2\2\2\u04d8\u04d6\3\2\2\2\u04d9\u04dd"+
		"\5\u00a6T\2\u04da\u04dd\5\62\32\2\u04db\u04dd\7Y\2\2\u04dc\u04d9\3\2\2"+
		"\2\u04dc\u04da\3\2\2\2\u04dc\u04db\3\2\2\2\u04dd\u00a5\3\2\2\2\u04de\u04e0"+
		"\5\64\33\2\u04df\u04de\3\2\2\2\u04df\u04e0\3\2\2\2\u04e0\u04e1\3\2\2\2"+
		"\u04e1\u04e3\5`\61\2\u04e2\u04e4\5\u00a8U\2\u04e3\u04e2\3\2\2\2\u04e3"+
		"\u04e4\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\5\u0092J\2\u04e6\u00a7"+
		"\3\2\2\2\u04e7\u04e8\bU\1\2\u04e8\u04e9\5\62\32\2\u04e9\u04ee\3\2\2\2"+
		"\u04ea\u04eb\f\3\2\2\u04eb\u04ed\5\62\32\2\u04ec\u04ea\3\2\2\2\u04ed\u04f0"+
		"\3\2\2\2\u04ee\u04ec\3\2\2\2\u04ee\u04ef\3\2\2\2\u04ef\u00a9\3\2\2\2\u04f0"+
		"\u04ee\3\2\2\2\u008d\u00af\u00b7\u00cb\u00dc\u00e6\u010a\u0114\u0121\u0123"+
		"\u012e\u0147\u0157\u0165\u0167\u0173\u0175\u0181\u0183\u0195\u0197\u01a3"+
		"\u01a5\u01b0\u01bb\u01c6\u01d1\u01dc\u01e5\u01ec\u01f8\u01ff\u0204\u0209"+
		"\u020e\u0215\u021f\u0227\u0230\u0240\u0244\u024d\u0258\u025d\u0262\u0266"+
		"\u026a\u026c\u0276\u027b\u027f\u0283\u028b\u0294\u029e\u02a6\u02b7\u02c3"+
		"\u02c6\u02cc\u02d6\u02db\u02de\u02e5\u02f4\u0300\u0303\u0305\u030d\u0311"+
		"\u031f\u0323\u0328\u032b\u032e\u0335\u0337\u033c\u0340\u0345\u0349\u034c"+
		"\u0355\u035d\u0367\u036f\u0371\u037b\u0380\u0384\u038a\u038d\u0396\u039b"+
		"\u039e\u03a4\u03b4\u03ba\u03bd\u03c2\u03c5\u03cc\u03df\u03e5\u03e8\u03ea"+
		"\u03fa\u03fe\u0405\u040a\u0417\u0420\u0429\u043c\u043f\u0447\u044a\u044e"+
		"\u0453\u0460\u0464\u046f\u0474\u0477\u0482\u048a\u049d\u04a1\u04a5\u04ad"+
		"\u04b1\u04b6\u04c1\u04c8\u04cb\u04d6\u04dc\u04df\u04e3\u04ee";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}