/*
 [The "BSD licence"]
 Copyright (c) 2013 Sam Harwell
 Copyright (c) 2015 https://github.com/timeraider4u
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

grammar C;

@parser::header {
	import java.util.Set;
	import java.util.HashSet;
	import java.util.Stack;
}

@parser::members {
	
	private final class Symbols {
		public final String scopeName;
		public final Set<String> types = new HashSet<String>();
		public Symbols(final String scopeName) {
			this.scopeName = scopeName;
		}
	}
	
	protected final Stack<Symbols> scope = new Stack<Symbols>();
	protected Symbols currScope = null;
	
	protected final boolean isTypeName(final String name) {
		// System.out.println("searching for typeName='" + name + "', scopeSize='"
		//	+ this.scope.size() + "'");
		if (currScope.types.contains(name)) {
			//System.out.println("found in currScope!");
			return true;
		}
		for (int i = 0; i < this.scope.size(); i++) {
			final Symbols symbols = this.scope.get(i);
			if (symbols.types.contains(name)) {
				// System.out.println("found in scope='" + symbols.scopeName + "'");
				return true;
			}
			// System.out.println("no type found in scope='" + symbols.scopeName + "'");
		}
		return false;
	}
	
	protected final void createNewScope(final String scopeName) {
		// System.out.println("createNewScope='" + scopeName + "'");
		final Symbols symbols = new Symbols(scopeName);
		if (this.currScope != null) {
			this.scope.push(this.currScope);
		}
		this.currScope = symbols;
		this.setTypedef(false);
	}
	
	protected final void removeScope() {
		// System.out.println("removeScope='" + currScope.scopeName + "'");
		if (this.scope.isEmpty()) {
			this.currScope = null;
		}
		else {
			this.currScope = this.scope.pop();
		}
		this.setTypedef(false);
	}
	
	protected final void addTypedef(final String name) {
		this.currScope.types.add(name);
		// System.out.println("define type='" + name + "'");
	}
	
	protected final void setTypedef(final boolean newTypeDef) {
		isTypedefValue = newTypeDef;
	}
	
	protected final boolean isTypedef() {
		return isTypedefValue;
	}
	
	protected boolean isTypedefValue = false;
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}


/*** parser ***/
translationunit
@init {
	this.createNewScope("translationUnit");
}
@after {
	this.removeScope();
}:
	(externalDeclaration)+
;

externalDeclaration:
 		declaration
    | SEMI // stray ;
;

//
// ambiguity:
// 1.)declarationSpecifiers->declarationSpecifier->typeSpecifier->typedefName->IDENTIFIER
// 2.)initDeclaratorList->initDeclarator->declarator->directDeclarator->IDENTIFIER

declaration
@init {
	this.setTypedef(false);
}:
	declarationSpecifiers (initDeclaratorList)? SEMI
;

declarationSpecifiers: 
	(
		declarationSpecifier
	)+
;

declarationSpecifier: 
	
	(storageClassSpecifier
    |   typeSpecifier
    |   typeQualifier
    )
;

initDeclaratorList: initDeclarator
	(initDeclarator)*
;

initDeclarator: declarator;

storageClassSpecifier:
	( 
	TYPEDEF
    |   EXTERN
    |   STATIC
    |   THREADLOCAL
    |   AUTO
    |   REGISTER
    )
;

typeSpecifier:
	(
	VOID
    |   CHAR
    |   SHORT
    |   INT
    |   LONG
    |   FLOAT
    |   DOUBLE
    |   SIGNED
    |   UNSIGNED
    |   BOOL
    |   COMPLEX
    |   '__m128'
    |   '__m128d'
    |   '__m128i'
    |  typedefName
    )
;

typeQualifier:
	( 
	CONST
    |   RESTRICT
    |   VOLATILE
    |   ATOMIC
    )
;

declarator:  (directDeclarator);

directDeclarator:
	(ID 
			{
					if (this.isTypedef()) {
						this.addTypedef($Identifier.text);
					}
			}
		| LEFTPAREN declarator RIGHTPAREN
	)
;


typedefName  returns [Object current=new String("typedefName")] 
    @init { System.out.println("enter rule"); 
    }
    @after { System.out.println("leave rule!"); }:

    {isTypeName(_input.LT(1).getText())}?
    
    this_ID_0=ID {
		$current.merge(this_ID_0);
		System.out.println("ID='" + $ID + "'");
    }
	
	 { System.out.println("do something"); }
	;


/*** lexer ***/
 UNDERSCORE: '_';

 AUTO : 'auto';
 BREAK : 'break';
 CASE : 'case';
 CHAR : 'char';
 CONST : 'const';
 CONTINUE : 'continue';
 DEFAULT : 'default';
 DO : 'do';
 DOUBLE : 'double';
 ELSE : 'else';
 ENUM : 'enum';
 EXTERN : 'extern';
 FLOAT : 'float';
 FOR : 'for';
 GOTO : 'goto';
 IF : 'if';
 INLINE : 'inline';
 INT : 'int';
 LONG : 'long';
 REGISTER : 'register';
 RESTRICT : 'restrict';
 RETURN : 'return';
 SHORT : 'short';
 SIGNED : 'signed';
 SIZEOF : 'sizeof';
 STATIC : 'static';
 STRUCT : 'struct';
 SWITCH : 'switch';
 TYPEDEF : 'typedef';
 UNION : 'union';
 UNSIGNED : 'unsigned';
 VOID : 'void';
 VOLATILE : 'volatile';
 WHILE : 'while';

 ALIGNAS : '_Alignas';
 ALIGNOF : '_Alignof';
 ASM: 'asm';
 ATOMIC : '_Atomic';
 BOOL : '_Bool';
 COMPLEX : '_Complex';
 GENERIC : '_Generic';
 IMAGINARY : '_Imaginary';
 NORETURN : '_Noreturn';
 STATICASSERT : '_Static_assert';
 THREADLOCAL : '_Thread_local';
 PRAGMA: 'pragma';

 LEFTPAREN: '(';
 RIGHTPAREN: ')';
 LEFTBRACKET: '[';
 RIGHTBRACKET: ']';
 LEFTBRACE: '{';
 RIGHTBRACE: '}';
 LESS: '<';
 LESSEQUAL: LESS ASSIGN;
 GREATER: '>';
 GREATEREQUAL: GREATER ASSIGN;
 LEFTSHIFT: LESS LESS;
 RIGHTSHIFT: GREATER GREATER;

 PLUS: '+';
 PLUSPLUS: PLUS PLUS;
 MINUS: '-';
 MINUSMINUS: MINUS MINUS;
 STAR: '*';
 DIV: '/';
 MOD: '%';

 AND: '&';
 ANDAND: AND AND;
 OR: '|';
 OROR: OR OR;
 CARET: '^';
 NOT: '!';
 TILDE: '~';

 QUESTION: '?';
 COLON: ':';
 SEMI: ';';
 COMMA: ',';
 ASSIGN: '=';

 STARASSIGN: STAR ASSIGN;
 DIVASSIGN: DIV ASSIGN;
 MODASSIGN: MOD ASSIGN;
 PLUSASSIGN: PLUS ASSIGN;
 MINUSASSIGN: MINUS ASSIGN;
 LEFTSHIFTASSIGN: LEFTSHIFT ASSIGN;
//'>>='
 RIGHTSHIFTASSIGN:RIGHTSHIFT ASSIGN;
 ANDASSIGN: AND ASSIGN;
 XORASSIGN: CARET ASSIGN;
 ORASSIGN: OR ASSIGN;

 EQUAL: ASSIGN ASSIGN;
 NOTEQUAL: NOT ASSIGN;

 ARROW: MINUS GREATER;
 DOT: '.';
 ELLIPSIS: DOT DOT DOT;

 ZERO: '0';

 fragment IDENTIFIER:
	IDENTIFIERNONDIGIT
        (   IDENTIFIERNONDIGIT
        |   DIGIT
        )*
;
 fragment IDENTIFIERNONDIGIT:
	NONDIGIT
    |   UNIVERSALCHARACTERNAME
    //|   // other implementation-defined characters...
;
 fragment NONDIGIT: ('a' .. 'z' | 'A' .. 'Z'); // [a-zA-Z_];
 fragment DIGIT: '0' .. '9'; //[0-9];
 fragment UNIVERSALCHARACTERNAME:
	'\\u' HEXQUAD
    |   '\\U' HEXQUAD HEXQUAD
;
 fragment HEXQUAD: HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT HEXADECIMALDIGIT;
 CONSTANT: INTEGERCONSTANT
    |   FLOATINGCONSTANT
    //|   EnumerationCONSTANT
    |   CHARACTERCONSTANT
;
 fragment INTEGERCONSTANT:
	DECIMALCONSTANT INTEGERSUFFIX?
    |   OCTALCONSTANT INTEGERSUFFIX?
    |   HEXADECIMALCONSTANT INTEGERSUFFIX?
;
 fragment DECIMALCONSTANT: NONZERODIGIT DIGIT*;
 fragment OCTALCONSTANT: '0' OCTALDIGIT*;
 fragment HEXADECIMALCONSTANT: HEXADECIMALPREFIX HEXADECIMALDIGIT+;
 fragment HEXADECIMALPREFIX: '0' ('x' | 'X'); // [xX];
 fragment NONZERODIGIT: '1' .. '9'; //[1-9];
 fragment OCTALDIGIT: ('0' .. '7'); //[0-7];
 fragment HEXADECIMALDIGIT: ('0'..'9' | 'a' .. 'f' | 'A' .. 'F'); // [0-9a-fA-F];
 fragment INTEGERSUFFIX:
	UNSIGNEDSUFFIX LONGSUFFIX?
    |   UNSIGNEDSUFFIX LONGLONGSUFFIX
    |   LONGSUFFIX UNSIGNEDSUFFIX?
    |   LONGLONGSUFFIX UNSIGNEDSUFFIX?
;
 fragment UNSIGNEDSUFFIX: 'u' | 'U'; //[uU];
 fragment LONGSUFFIX: 'l' | 'L'; //[lL];
 fragment LONGLONGSUFFIX: 'll' | 'LL';
 fragment FLOATINGCONSTANT:
	DECIMALFLOATINGCONSTANT
    |   HEXADECIMALFLOATINGCONSTANT
;
 fragment DECIMALFLOATINGCONSTANT:
	FRACTIONALCONSTANT EXPONENTPART? FLOATINGSUFFIX?
    |   DIGITSEQUENCE EXPONENTPART FLOATINGSUFFIX?
;
 fragment HEXADECIMALFLOATINGCONSTANT:
	HEXADECIMALPREFIX HEXADECIMALFRACTIONALCONSTANT BINARYEXPONENTPART FLOATINGSUFFIX?
    |   HEXADECIMALPREFIX HEXADECIMALDIGITSEQUENCE BINARYEXPONENTPART FLOATINGSUFFIX?
;
 fragment FRACTIONALCONSTANT: 
	DIGITSEQUENCE? DOT DIGITSEQUENCE
    |   DIGITSEQUENCE DOT
;
 fragment EXPONENTPART:
	'e' SIGN? DIGITSEQUENCE
    |   'E' SIGN? DIGITSEQUENCE
;
 fragment SIGN: PLUS | MINUS;
 fragment DIGITSEQUENCE: DIGIT+;
 fragment HEXADECIMALFRACTIONALCONSTANT:
	HEXADECIMALDIGITSEQUENCE? DOT HEXADECIMALDIGITSEQUENCE
    |   HEXADECIMALDIGITSEQUENCE DOT
;
 fragment BINARYEXPONENTPART: 
	'p' SIGN? DIGITSEQUENCE
    |   'P' SIGN? DIGITSEQUENCE
;
 fragment HEXADECIMALDIGITSEQUENCE: HEXADECIMALDIGIT+;
 fragment FLOATINGSUFFIX: 'f' | 'l' | 'F' | 'L';
 fragment CHARACTERCONSTANT: 
	SINGLEQUOTE CCHARSEQUENCE SINGLEQUOTE
    |   'L\'' CCHARSEQUENCE SINGLEQUOTE
    |   'u\'' CCHARSEQUENCE SINGLEQUOTE
    |   'U\'' CCHARSEQUENCE SINGLEQUOTE
;
 fragment CCHARSEQUENCE: CCHAR+;
 fragment CCHAR:
	~(BACKSLASH | NEWLINE)
    |   ESCAPESEQUENCE
;
 fragment ESCAPESEQUENCE: SIMPLEESCAPESEQUENCE
	|   OCTALESCAPESEQUENCE
	|   HEXADECIMALESCAPESEQUENCE
	|   UNIVERSALCHARACTERNAME
;
 fragment SIMPLEESCAPESEQUENCE: 
	BACKSLASH //['"?abfnrtv\\]
	(SINGLEQUOTE | DOUBLEQUOTE | 'a' | 'b' | 'f' | 'n' | 'r' | 't' | 'v' | QUESTION | BACKSLASH)
;
 fragment OCTALESCAPESEQUENCE: BACKSLASH OCTALDIGIT
    |   BACKSLASH OCTALDIGIT OCTALDIGIT
    |   BACKSLASH OCTALDIGIT OCTALDIGIT OCTALDIGIT
;

 fragment HEXADECIMALESCAPESEQUENCE: '\\x' HEXADECIMALDIGIT+;

 STRINGLITERAL: ENCODINGPREFIX? '"' SCHARSEQUENCE? '"';

 fragment ENCODINGPREFIX: 'u8'
    |   'u'
    |   'U'
    |   'L'
;
 fragment SCHARSEQUENCE: SCHAR+;
 fragment SCHAR: 
	~('\n' | '\r'| BACKSLASH | DOUBLEQUOTE) //~["\\\r\n]
	|   ESCAPESEQUENCE
;
 SINGLEQUOTE: '\'';
 DOUBLEQUOTE: '"';
 BACKSLASH: '\\';
 LINEDIRECTIVE: 
	'#' WHITESPACE? DECIMALCONSTANT WHITESPACE? STRINGLITERAL (~NEWLINE)*;
 PRAGMADIRECTIVE: '#' WHITESPACE? PRAGMA WHITESPACE (~NEWLINE)*;
 WHITESPACE: (' ' | '\t')+;
 BLOCK_COMMENT: '/*' ( options {greedy=false;} : . )*  '*/';
 LINE_COMMENT: '//' (~NEWLINE)*;
 NEWLINE: ('\r'|'\n');

 ANYOTHER: ~(COMMA | LEFTPAREN | RIGHTPAREN);
// NOPAREN: !(LEFTPAREN | RIGHTPAREN);
 ID: IDENTIFIER;
 
