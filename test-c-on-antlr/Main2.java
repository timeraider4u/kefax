import org.antlr.*;
//import org.antlr.runtime.*;
import org.antlr.v4.runtime.*;
//import org.antlr.runtime.tree.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class Main2 {

	public static void main(String[] args) throws Exception {
		try {
			//ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(args[0]));
			C2Lexer lex = new C2Lexer(new ANTLRFileStream(args[0]));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			C2Parser parser = new C2Parser(tokens);
					
			ParseTree tree = parser.translation_unit();
			
			System.out.println(tree.toString());
			System.out.println(tree.toStringTree());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			// printTree(ast, 0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
    
}
