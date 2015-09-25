import org.antlr.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

public class Main {

	public static void main(String[] args) throws Exception {
		try {
			CLexer lex = new CLexer(new ANTLRFileStream(args[0]));
			CommonTokenStream tokens = new CommonTokenStream(lex);
			CParser parser = new CParser(tokens);
					
			//acquire parse result
			parser.setTreeAdaptor(
				new CommonTreeAdaptor() {
					public Object create(Token payload) {
						return new CommonTree(payload);
					}
				}
			);
			CParser.translation_unit_return ret = parser.translation_unit();
			CommonTree ast = (CommonTree) ret.getTree();
			
			System.out.println(ast.toString());
			System.out.println(ast.toStringTree());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			printTree(ast, 0);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
    public static void printTree(CommonTree t, int indent) {
		if ( t != null ) {
			StringBuffer sb = new StringBuffer(indent);
		
			if (t.getParent() == null){
				String text = t.getText(); //.toString();
				System.out.println(sb.toString() + text);	
			}
			for ( int i = 0; i < indent; i++ )
				sb = sb.append("   ");
			for ( int i = 0; i < t.getChildCount(); i++ ) {
				System.out.println(sb.toString() + t.getChild(i).toString());
				printTree((CommonTree)t.getChild(i), indent+1);
			}
		}
	}
	
}
