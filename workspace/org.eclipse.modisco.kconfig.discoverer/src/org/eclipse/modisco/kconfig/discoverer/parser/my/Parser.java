package org.eclipse.modisco.kconfig.discoverer.parser.my;

import org.eclipse.modisco.kconfig.BooleanExprType;
import org.eclipse.modisco.kconfig.Config;
import org.eclipse.modisco.kconfig.ConfigType;
import org.eclipse.modisco.kconfig.Default;
import org.eclipse.modisco.kconfig.Expr;
import org.eclipse.modisco.kconfig.KconfigFactory;
import org.eclipse.modisco.kconfig.Model;
import org.eclipse.modisco.kconfig.Option;
import org.eclipse.modisco.kconfig.Range;
import org.eclipse.modisco.kconfig.Select;
import org.eclipse.modisco.kconfig.TranslationUnit;
import org.eclipse.modisco.kconfig.TristateValue;
import org.eclipse.modisco.kconfig.discoverer.parser.ParserUtils;


// Set the name of your grammar here (and at the end of this grammar):

import java.util.List;

public class Parser {
	public static final int _EOF = 0;
	public static final int _ident = 1;
	public static final int _tab = 2;
	public static final int _str_start = 3;
	public static final int _newline = 4;
	public static final int _config = 5;
	public static final int _type_bool = 6;
	public static final int _type_int = 7;
	public static final int _type_hex = 8;
	public static final int _type_tristate = 9;
	public static final int _type_string = 10;
	public static final int _type_defbool = 11;
	public static final int _type_deftristate = 12;
	public static final int _help = 13;
	public static final int _help2 = 14;
	public static final int _depends = 15;
	public static final int _on = 16;
	public static final int _negate = 17;
	public static final int _prompt = 18;
	public static final int _if = 19;
	public static final int _default = 20;
	public static final int _tristate_y = 21;
	public static final int _tristate_m = 22;
	public static final int _tristate_n = 23;
	public static final int _select = 24;
	public static final int _range = 25;
	public static final int _option = 26;
	public static final int _env = 27;
	public static final int _equals = 28;
	public static final int _and = 29;
	public static final int _or = 30;
	public static final int _source = 31;
	public static final int _menu = 32;
	public static final int _endmenu = 33;
	public static final int maxT = 34;

	static final boolean T = true;
	static final boolean x = false;
	static final int minErrDist = 2;

	public Token t;    // last recognized token
	public Token la;   // lookahead token
	int errDist = minErrDist;
	
	public Scanner scanner;
	public Errors errors;

	//only for the editor
	private boolean isContentAssistant = false;
	private boolean errorsDetected = false;
	private boolean updateProposals = false;

	private int stopPosition = 0;
	private int proposalToken = _EOF;
	private List<String> ccSymbols = null;
	private List<String> proposals = null;
	private Token dummy = new Token();
	private final ParserUtils utils;


	

	public Parser(Scanner scanner, KconfigFactory factory, Model model, TranslationUnit unit) {
		this.utils = new ParserUtils(factory, model, unit);
		this.scanner = scanner;
		errors = new Errors();
	}

	void SynErr (int n) {
		if (errDist >= minErrDist) errors.SynErr(la.line, la.col, n);
		errDist = 0;
		
		//for the editor
		errorsDetected = true;
	}

	public void SemErr (String msg) {
		if (errDist >= minErrDist) errors.SemErr(t.line, t.col, msg);
		errDist = 0;

		//for the editor
		errorsDetected = true;
	}
	 
	void Get () {
		if(isContentAssistant && updateProposals){
			la = la.next;
			if(!errorsDetected){
				proposals = ccSymbols;
			
				errorsDetected = true;
			}
		}
		
		else{
			for (;;) {
				t = la;
				la = scanner.Scan();
				if (la.kind <= maxT) {
					++errDist;
					break;
				} 

				la = t;

			}
		}
				

		

		//auch aktuellen token mitgeben,
		//if la.charPos >= current Token && la.charPos < stopPosition + la.val.length()
		//  Token temp = la.clone();
		//	la.kind = proposalToken;


		//only for the Editor
		if(isContentAssistant && !errorsDetected && la.charPos >= stopPosition + la.val.length()){
			dummy = createDummy();
			dummy.next = la;
			la = dummy;
			updateProposals = true;
			
		}
		ccSymbols = null;
	}
	
	void Expect (int n) {
		if (la.kind==n) Get(); else { SynErr(n); }
	}
	
	boolean StartOf (int s) {
		return set[s][la.kind];
	}
	
	void ExpectWeak (int n, int follow) {
		if (la.kind == n) Get();
		else {
			SynErr(n);
			while (!StartOf(follow)) Get();
		}
	}
	
	boolean WeakSeparator (int n, int syFol, int repFol) {
		int kind = la.kind;
		if (kind == n) { Get(); return true; }
		else if (StartOf(repFol)) return false;
		else {
			SynErr(n);
			while (!(set[syFol][kind] || set[repFol][kind] || set[0][kind])) {
				Get();
				kind = la.kind;
			}
			return StartOf(syFol);
		}
	}
	
	void Kconfig() {
		while (la.kind == 5 || la.kind == 31 || la.kind == 32) {
			Scope();
		}
	}

	void Scope() {
		if (la.kind == 5) {
			Config();
		} else if (la.kind == 31) {
			Source();
		} else if (la.kind == 32) {
			Menu();
		} else SynErr(35);
	}

	void Config() {
		Config config = null; 
		Expect(5);
		String name = Ident();
		config = utils.insertConfig(name); 
		Expect(4);
		Expect(2);
		Type();
		MyPrompt();
		Expect(4);
		while (la.kind == 2) {
			ConfigAdditional();
		}
		if (la.kind == 4) {
			Get();
		} else if (la.kind == 0) {
			Get();
		} else SynErr(36);
	}

	void Source() {
		Expect(31);
		String fileName = MyString();
		utils.addSourceUnit(fileName); 
		Expect(4);
		while (la.kind == 4) {
			Get();
		}
	}

	void Menu() {
		Expect(32);
		String name = MyString();
		Expect(4);
		Expect(4);
		while (la.kind == 5 || la.kind == 31 || la.kind == 32) {
			Scope();
		}
		Expect(33);
		Expect(4);
		Expect(4);
	}

	String  MyString() {
		String  string;
		string = ""; 
		Expect(3);
		while (StartOf(1)) {
			Get();
			string = string + t.val; 
		}
		Expect(3);
		return string;
	}

	String  Ident() {
		String  name;
		Expect(1);
		name = t.val; 
		return name;
	}

	void Type() {
		switch (la.kind) {
		case 6: {
			Get();
			utils.setType(ConfigType.BOOL); 
			break;
		}
		case 7: {
			Get();
			utils.setType(ConfigType.INT); 
			break;
		}
		case 8: {
			Get();
			utils.setType(ConfigType.HEX); 
			break;
		}
		case 9: {
			Get();
			utils.setType(ConfigType.TRISTATE); 
			break;
		}
		case 10: {
			Get();
			utils.setType(ConfigType.STRING); 
			break;
		}
		case 11: {
			Get();
			utils.setType(ConfigType.BOOL); 
			DefaultValue();
			break;
		}
		case 12: {
			Get();
			utils.setType(ConfigType.TRISTATE); 
			DefaultValue();
			break;
		}
		default: SynErr(37); break;
		}
	}

	void MyPrompt() {
		if (la.kind == 3) {
			String desc = MyString();
			utils.setDescription(desc); 
		}
		if (la.kind == 19) {
			Get();
			Expr expr = Expr();
			utils.addExprPrompt(expr); 
		}
	}

	void ConfigAdditional() {
		Expect(2);
		switch (la.kind) {
		case 15: {
			Dependencies();
			break;
		}
		case 18: {
			Prompt();
			break;
		}
		case 20: {
			Defaults();
			break;
		}
		case 24: {
			Selects();
			break;
		}
		case 25: {
			Ranges();
			break;
		}
		case 26: {
			Options();
			break;
		}
		case 13: case 14: {
			Help();
			break;
		}
		default: SynErr(38); break;
		}
	}

	void Dependencies() {
		Expr depends = Depends();
		utils.addDependsToUtils(depends); 
		Expect(4);
	}

	void Prompt() {
		Expect(18);
		MyPrompt();
		Expect(4);
	}

	void Defaults() {
		Expect(20);
		DefaultValue();
		Expect(4);
	}

	void Selects() {
		Select select = null; 
		Expect(24);
		Expr expr = Expr();
		select = utils.addSelectExpr(expr); 
		if (la.kind == 19) {
			Get();
			Expr ifExpr = Expr();
			utils.addSelectIfExpr(select, ifExpr); 
		}
		Expect(4);
	}

	void Ranges() {
		Range range = utils.createRange(); 
		Expect(25);
		String lower = Ident();
		utils.setLowerRangeExpr(range, lower); 
		String upper = Ident();
		utils.setUpperRangeExpr(range, upper); 
		if (la.kind == 19) {
			Get();
			Expr ifExpr = Expr();
			utils.addRangeIfExpr(range, ifExpr); 
		}
		Expect(4);
	}

	void Options() {
		Option option = utils.createOption(); 
		Expect(26);
		Expect(27);
		Expect(28);
		String value = MyString();
		utils.setOptionValue(option, value); 
		Expect(4);
	}

	void Help() {
		if (la.kind == 13) {
			Get();
		} else if (la.kind == 14) {
			Get();
		} else SynErr(39);
		Expect(4);
		while (la.kind == 2) {
			Get();
			while (StartOf(2)) {
				Get();
			}
			
			Expect(4);
		}
	}

	void DefaultValue() {
		Default myDefault = null; 
		Expr expr = Expr();
		myDefault = utils.addDefaultExpr(expr); 
		if (la.kind == 19) {
			Get();
			Expr ifExpr = Expr();
			utils.addDefaultIfExpr(myDefault, ifExpr); 
		}
	}

	Expr  Depends() {
		Expr  depends;
		depends = null; 
		Expect(15);
		Expect(16);
		Expr expr = Expr();
		depends = expr; 
		return depends;
	}

	Expr  Expr() {
		Expr  expr;
		expr = null; 
		Expr outExpr = SimpleExpr();
		expr = outExpr; 
		if (StartOf(3)) {
			if (la.kind == 30) {
				Get();
				expr = utils.createBooleanExpr(expr, BooleanExprType.OR); 
				Expr rightExpr = Expr();
				utils.setRightExpr(expr, rightExpr); 
			} else if (la.kind == 29) {
				Get();
				expr = utils.createBooleanExpr(expr, BooleanExprType.AND); 
				Expr rightExpr = Expr();
				utils.setRightExpr(expr, rightExpr); 
			} else if (la.kind == 28) {
				Get();
				expr = utils.createBooleanExpr(expr, BooleanExprType.EQUALS); 
				Expr rightExpr = Expr();
				utils.setRightExpr(expr, rightExpr); 
			} else {
				Get();
				Expect(28);
				expr = utils.createBooleanExpr(expr, BooleanExprType.NONEQUALS); 
				Expr rightExpr = Expr();
				utils.setRightExpr(expr, rightExpr); 
			}
		}
		return expr;
	}

	Expr  SimpleExpr() {
		Expr  expr;
		expr = null; boolean neg = false; 
		if (la.kind == 1 || la.kind == 17) {
			if (la.kind == 17) {
				Get();
				neg = true; 
			}
			String name = Ident();
			expr = utils.createConfigExpr(neg,name); 
		} else if (la.kind == 21) {
			Get();
			expr = utils.createTristateExpr(TristateValue.Y); 
		} else if (la.kind == 22) {
			Get();
			expr = utils.createTristateExpr(TristateValue.M); 
		} else if (la.kind == 23) {
			Get();
			expr = utils.createTristateExpr(TristateValue.N); 
		} else if (la.kind == 3) {
			String string = MyString();
			expr = utils.createLitExpr(string); 
		} else SynErr(40);
		return expr;
	}



	public void Parse() {
		la = new Token();
		la.val = "";		
		Get();
		Kconfig();
		Expect(0);

	}

	private static final boolean[][] set = {
		{T,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x},
		{x,T,T,x, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,x},
		{x,T,T,T, x,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,T, T,T,T,x},
		{x,x,x,x, x,x,x,x, x,x,x,x, x,x,x,x, x,T,x,x, x,x,x,x, x,x,x,x, T,T,T,x, x,x,x,x}

	};
 
	
	//only for the editor
	public Parser(Scanner scanner, int proposalToken, int stopPosition, KconfigFactory factory, 
			Model model, TranslationUnit unit){
		this(scanner, factory, model, unit);
		isContentAssistant = true;
		this.proposalToken = proposalToken;
		this.stopPosition = stopPosition;
	}

	public String ParseErrors(){
		java.io.PrintStream oldStream = System.out;
		
		java.io.OutputStream out = new java.io.ByteArrayOutputStream();
		java.io.PrintStream newStream = new java.io.PrintStream(out);
		
		errors.errorStream = newStream;
				
		Parse();

		String errorStream = out.toString();
		errors.errorStream = oldStream;

		return errorStream;

	}

	public List<String> getCodeCompletionProposals(){
		return proposals;
	}

	private Token createDummy(){
		Token token = new Token();
		
		token.pos = la.pos;
		token.charPos = la.charPos;
		token.line = la.line;
		token.col = la.col;
		
		token.kind = proposalToken;
		token.val = "";
		
		
		return token;
	}
} // end Parser


class Errors {
	public int count = 0;                                    // number of errors detected
	public java.io.PrintStream errorStream = System.out;     // error messages go to this stream
	public String errMsgFormat = "-- line {0} col {1}: {2}"; // 0=line, 1=column, 2=text
	
	protected void printMsg(int line, int column, String msg) {
		StringBuffer b = new StringBuffer(errMsgFormat);
		int pos = b.indexOf("{0}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, line); }
		pos = b.indexOf("{1}");
		if (pos >= 0) { b.delete(pos, pos+3); b.insert(pos, column); }
		pos = b.indexOf("{2}");
		if (pos >= 0) b.replace(pos, pos+3, msg);
		errorStream.println(b.toString());
	}
	
	public void SynErr (int line, int col, int n) {
		String s;
		switch (n) {
			case 0: s = "EOF expected"; break;
			case 1: s = "ident expected"; break;
			case 2: s = "tab expected"; break;
			case 3: s = "str_start expected"; break;
			case 4: s = "newline expected"; break;
			case 5: s = "config expected"; break;
			case 6: s = "type_bool expected"; break;
			case 7: s = "type_int expected"; break;
			case 8: s = "type_hex expected"; break;
			case 9: s = "type_tristate expected"; break;
			case 10: s = "type_string expected"; break;
			case 11: s = "type_defbool expected"; break;
			case 12: s = "type_deftristate expected"; break;
			case 13: s = "help expected"; break;
			case 14: s = "help2 expected"; break;
			case 15: s = "depends expected"; break;
			case 16: s = "on expected"; break;
			case 17: s = "negate expected"; break;
			case 18: s = "prompt expected"; break;
			case 19: s = "if expected"; break;
			case 20: s = "default expected"; break;
			case 21: s = "tristate_y expected"; break;
			case 22: s = "tristate_m expected"; break;
			case 23: s = "tristate_n expected"; break;
			case 24: s = "select expected"; break;
			case 25: s = "range expected"; break;
			case 26: s = "option expected"; break;
			case 27: s = "env expected"; break;
			case 28: s = "equals expected"; break;
			case 29: s = "and expected"; break;
			case 30: s = "or expected"; break;
			case 31: s = "source expected"; break;
			case 32: s = "menu expected"; break;
			case 33: s = "endmenu expected"; break;
			case 34: s = "??? expected"; break;
			case 35: s = "invalid Scope"; break;
			case 36: s = "invalid Config"; break;
			case 37: s = "invalid Type"; break;
			case 38: s = "invalid ConfigAdditional"; break;
			case 39: s = "invalid Help"; break;
			case 40: s = "invalid SimpleExpr"; break;
			default: s = "error " + n; break;
		}
		printMsg(line, col, s);
		count++;
	}

	public void SemErr (int line, int col, String s) {	
		printMsg(line, col, s);
		count++;
	}
	
	public void SemErr (String s) {
		errorStream.println(s);
		count++;
	}
	
	public void Warning (int line, int col, String s) {	
		printMsg(line, col, s);
	}
	
	public void Warning (String s) {
		errorStream.println(s);
	}
} // Errors


class FatalError extends RuntimeException {
	public static final long serialVersionUID = 1L;
	public FatalError(String s) { super(s); }
}
